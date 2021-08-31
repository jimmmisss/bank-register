package br.com.bank.service;

import br.com.bank.assembly.request.ProfessionalDataRequest;
import br.com.bank.assembly.response.ProfessionalDataResponse;
import br.com.bank.entity.ProfessionalData;
import br.com.bank.repository.ProfessionalDataRepository;
import br.com.bank.service.mapper.ProfessionalDataMapper;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import static br.com.bank.service.constants.Constants.ENTITY_NOT_FOUND;
import static br.com.bank.service.constants.Constants.PROFESSIONAL_DATA;
import static java.lang.String.format;

@ApplicationScoped
@RequiredArgsConstructor
public class ProfessionalDataService {

    private final ProfessionalDataMapper mapper;
    private final ProfessionalDataRepository repository;
    private final PersonService personService;

    public ProfessionalDataResponse getProfessionalDataByPerson(Long personId) {
        var id = personService.getPerson(personId).getId();
        return mapper.map(findProfessionalDataByPerson(id));
    }

    @Transactional
    public void create(ProfessionalDataRequest request) {
        repository.persist(mapper.map(request));
    }

    @Transactional
    public void update(Long personId, ProfessionalDataRequest request) {
        repository.persist(mapper.map(request, findProfessionalDataByPerson(personId)));
    }

    @Transactional
    public void delete(Long id) {
        var optional = repository.findByIdOptional(id);
        optional.ifPresentOrElse(repository::delete, () -> {
            throw new NotFoundException(format(ENTITY_NOT_FOUND, PROFESSIONAL_DATA, id));
        });
    }

    private ProfessionalData findProfessionalDataByPerson(Long personId) {
        var optional = repository.findProfessionalDataByPerson(personId);
        return optional.orElseThrow(() ->
                new NotFoundException(format(ENTITY_NOT_FOUND, PROFESSIONAL_DATA, personId)));
    }
}