package br.com.bank.service;

import br.com.bank.assembly.request.NaturalnessParseRequest;
import br.com.bank.assembly.request.NaturalnessRequest;
import br.com.bank.assembly.response.NaturalnessResponse;
import br.com.bank.entity.Naturalness;
import br.com.bank.repository.NaturalnessRepository;
import br.com.bank.service.mapper.NaturalnessMapper;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import static br.com.bank.service.constants.Constants.ENTITY_NOT_FOUND;
import static br.com.bank.service.constants.Constants.NATURALNESS;
import static java.lang.String.format;

@ApplicationScoped
@RequiredArgsConstructor
public class NaturalnessService {

    private final NaturalnessMapper mapper;
    private final NaturalnessRepository repository;
    private final PersonService personService;

    public NaturalnessResponse getNaturalnessByPerson(Long personId) {
        var id = personService.getPerson(personId).getId();
        return mapper.map(findNaturalnessByPerson(id));
    }

    @Transactional
    public void create(NaturalnessRequest request) {
        repository.persist(mapper.map(request));
    }

    @Transactional
    public void update(Long personId, NaturalnessParseRequest request) {
        repository.persist(mapper.map(request, findNaturalnessByPerson(personId)));
    }

    @Transactional
    public void delete(Long id) {
        var optional = repository.findByIdOptional(id);
        optional.ifPresentOrElse(repository::delete, () -> {
            throw new NotFoundException(format(ENTITY_NOT_FOUND, NATURALNESS, id));
        });
    }

    private Naturalness findNaturalnessByPerson(Long personId) {
        var optional = repository.findNaturalnessByPerson(personId);
        return optional.orElseThrow(() -> new NotFoundException(format(ENTITY_NOT_FOUND, NATURALNESS, personId)));
    }
}