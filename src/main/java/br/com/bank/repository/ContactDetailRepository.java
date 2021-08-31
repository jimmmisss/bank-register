package br.com.bank.repository;

import br.com.bank.entity.ContactDetail;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ContactDetailRepository implements PanacheRepository<ContactDetail> {

    public List<ContactDetail> findContactDetailByPerson(Long personId) {
        return find("FROM ContactDetail a WHERE a.person = ?1", personId).list();
    }
}
