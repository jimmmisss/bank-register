package br.com.bank.service;

import br.com.bank.assembly.message.person.PersonProduceCreateDTO;
import br.com.bank.assembly.request.PersonParserRequest;
import br.com.bank.assembly.request.PersonRequest;
import br.com.bank.assembly.response.PersonResponse;
import br.com.bank.entity.Person;
import br.com.bank.repository.PersonRepository;
import br.com.bank.service.mapper.*;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import static br.com.bank.service.constants.Constants.*;
import static java.lang.String.format;

@ApplicationScoped
@RequiredArgsConstructor
public class PersonService {

    @Inject
    @Channel("person-out")
    Emitter<PersonProduceCreateDTO> emitterCreated;

    private final PersonMapper mapper;
    private final AddressMapper addressMapper;
    private final NaturalnessMapper naturalnessMapper;
    private final ProfessionalDataMapper professionalDataMapper;
    private final ContactDetailMapper contactDetailMapper;
    private final PersonRepository repository;
    private final AddressService addressService;
    private final NaturalnessService naturalnessService;
    private final ProfessionalDataService professionalDataService;
    private final ContactDetailService contactDetailService;

    public PersonResponse getPerson(Long id) {
        return mapper.map(findPerson(id));
    }

    public void create(PersonParserRequest request) {
        var entity = createdPerson(request);
        createdAddressAndNaturalness(request, entity);
    }

    @Transactional
    public void update(Long id, PersonRequest request) {
        repository.persist(mapper.map(request, findPerson(id)));
    }

    @Transactional
    public void delete(Long id) {
        var entityOptional = repository.findByIdOptional(id);
        entityOptional.ifPresentOrElse(repository::delete, () -> {
            throw new NotFoundException(format(ENTITY_NOT_FOUND, PHYSICAL_PERSON, id));
        });
    }

    private Person findPerson(Long id) {
        var optionalEntity = repository.findByIdOptional(id);
        return optionalEntity.orElseThrow(() ->
                new NotFoundException(format(ENTITY_NOT_FOUND, PHYSICAL_PERSON, id)));
    }

    @Transactional
    private Person createdPerson(PersonParserRequest request) {
        var entity = repository.create(mapper.map(request));
        emitterCreated.send(mapper.toProducerCreated(PERSON_PRODUCER, CREATE, entity));
        return entity;
    }

    @Transactional
    private void createdAddressAndNaturalness(PersonParserRequest request, Person person) {
        addressService.create(addressMapper.map(request.getAddressParseRequest(), person));
        naturalnessService.create(naturalnessMapper.map(request.getNaturalnessParseRequest(), person));
        professionalDataService.create(professionalDataMapper.map(request.getProfessionalDataParseRequest(), person));
        contactDetailService.create(contactDetailMapper.map(request.getContactDetailParseRequest(), person));
    }
}