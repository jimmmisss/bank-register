package br.com.bank.service;

import br.com.bank.assembly.request.ContactDetailParseRequest;
import br.com.bank.assembly.request.ContactDetailRequest;
import br.com.bank.assembly.response.ContactDetailResponse;
import br.com.bank.entity.ContactDetail;
import br.com.bank.repository.ContactDetailRepository;
import br.com.bank.service.mapper.ContactDetailMapper;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.Set;
import java.util.stream.Collectors;

import static br.com.bank.service.constants.Constants.CONTACT_DETAIL;
import static br.com.bank.service.constants.Constants.ENTITY_NOT_FOUND;
import static java.lang.String.format;

@ApplicationScoped
@RequiredArgsConstructor
public class ContactDetailService {

    private final ContactDetailMapper mapper;
    private final ContactDetailRepository repository;
    private final PersonService personService;

    public Set<ContactDetailResponse> getContactDetailByPerson(Long personId) {
        var id = personService.getPerson(personId).getId();
        var entities = repository.findContactDetailByPerson(id);
        return entities.stream().map(mapper::map).collect(Collectors.toSet());
    }

    @Transactional
    public void create(ContactDetailRequest request) {
        repository.persist(mapper.map(request));
    }

    @Transactional
    public void update(Long personId, ContactDetailParseRequest request) {
        repository.persist(mapper.map(request, findContactDetailByPerson(personId)));
    }

    @Transactional
    public void delete(Long id) {
        var optional = repository.findByIdOptional(id);
        optional.ifPresentOrElse(repository::delete, () -> {
            throw new NotFoundException(format(ENTITY_NOT_FOUND, CONTACT_DETAIL, id));
        });
    }

    private ContactDetail findContactDetailByPerson(Long personId) {
        var optional = repository.findByIdOptional(personId);
        return optional.orElseThrow(() -> new NotFoundException(format(ENTITY_NOT_FOUND, CONTACT_DETAIL, personId)));
    }
}