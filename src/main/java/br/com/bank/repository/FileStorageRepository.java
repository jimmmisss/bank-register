package br.com.bank.repository;

import br.com.bank.entity.FileStorage;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FileStorageRepository implements PanacheRepository<FileStorage> {

    public List<FileStorage> findFileStoragesByPerson(Long personId) {
        return find("FROM FileStorage a WHERE a.person = ?1", personId).list();
    }
}
