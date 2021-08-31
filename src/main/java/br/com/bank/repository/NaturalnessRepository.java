package br.com.bank.repository;

import br.com.bank.entity.Naturalness;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
public class NaturalnessRepository implements PanacheRepository<Naturalness> {

    public Optional<Naturalness> findNaturalnessByPerson(Long personId) {
        return find("FROM Naturalness a WHERE a.person = ?1", personId).firstResultOptional();
    }

    @Transactional
    public Naturalness create(Naturalness request) {
        persist(request);
        return request;
    }
}
