package br.com.bank.repository;

import br.com.bank.entity.ProfessionalData;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class ProfessionalDataRepository implements PanacheRepository<ProfessionalData> {

    public Optional<ProfessionalData> findProfessionalDataByPerson(Long personId) {
        return find("FROM ProfessionalData a WHERE a.person = ?1", personId).firstResultOptional();
    }
}
