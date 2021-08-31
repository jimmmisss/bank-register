package br.com.bank.service;

import br.com.bank.assembly.request.AddressParseRequest;
import br.com.bank.assembly.request.AddressRequest;
import br.com.bank.assembly.response.AddressResponse;
import br.com.bank.entity.Address;
import br.com.bank.repository.AddressRepository;
import br.com.bank.service.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.Set;
import java.util.stream.Collectors;

import static br.com.bank.service.constants.Constants.ADDRESS;
import static br.com.bank.service.constants.Constants.ENTITY_NOT_FOUND;
import static java.lang.String.format;

@ApplicationScoped
@RequiredArgsConstructor
public class AddressService {

    private final AddressMapper mapper;
    private final AddressRepository repository;
    private final PersonService personService;

    public Set<AddressResponse> getAddressByPerson(Long personId) {
        var id = personService.getPerson(personId).getId();
        var entities = repository.findAddressesByPerson(id);
        return entities.stream().map(mapper::map).collect(Collectors.toSet());
    }

    @Transactional
    public void create(AddressRequest request) {
        repository.persist(mapper.map(request));
    }

    @Transactional
    public void update(Long personId, AddressParseRequest request) {
        repository.persist(mapper.map(request, findAddressByPerson(personId)));
    }

    @Transactional
    public void delete(Long id) {
        var optional = repository.findByIdOptional(id);
        optional.ifPresentOrElse(repository::delete, () -> {
            throw new NotFoundException(format(ENTITY_NOT_FOUND, ADDRESS, id));
        });
    }

    private Address findAddressByPerson(Long personId) {
        var optional = repository.findByIdOptional(personId);
        return optional.orElseThrow(() -> new NotFoundException(format(ENTITY_NOT_FOUND, ADDRESS, personId)));
    }
}