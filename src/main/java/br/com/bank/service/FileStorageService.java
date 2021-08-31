package br.com.bank.service;

import br.com.bank.assembly.request.FileStorageParseRequest;
import br.com.bank.assembly.request.FileStorageRequest;
import br.com.bank.assembly.response.FileStorageResponse;
import br.com.bank.entity.FileStorage;
import br.com.bank.repository.FileStorageRepository;
import br.com.bank.service.mapper.FileStorageMapper;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.Set;
import java.util.stream.Collectors;

import static br.com.bank.service.constants.Constants.ENTITY_NOT_FOUND;
import static br.com.bank.service.constants.Constants.FILE_STORAGE;
import static java.lang.String.format;

@ApplicationScoped
@RequiredArgsConstructor
public class FileStorageService {

    private final FileStorageMapper mapper;
    private final FileStorageRepository repository;
    private final PersonService personService;

    public Set<FileStorageResponse> getFileStoragesByPerson(Long personId) {
        var id = personService.getPerson(personId).getId();
        var response = repository.findFileStoragesByPerson(id);
        return response.stream().map(mapper::map).collect(Collectors.toSet());
    }

    @Transactional
    public void create(FileStorageRequest request) {
        repository.persist(mapper.map(request));
    }

    @Transactional
    public void update(Long personId, FileStorageParseRequest request) {
        repository.persist(mapper.map(request, findFileStorageByPerson(personId)));
    }

    @Transactional
    public void delete(Long id) {
        var optional = repository.findByIdOptional(id);
        optional.ifPresentOrElse(repository::delete, () -> {
            throw new NotFoundException(format(ENTITY_NOT_FOUND, FILE_STORAGE, id));
        });
    }

    private FileStorage findFileStorageByPerson(Long personId) {
        var optional = repository.findByIdOptional(personId);
        return optional.orElseThrow(() -> new NotFoundException(format(ENTITY_NOT_FOUND, FILE_STORAGE, personId)));
    }
}