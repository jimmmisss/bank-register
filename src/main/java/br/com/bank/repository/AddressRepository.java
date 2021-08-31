package br.com.bank.repository;

import br.com.bank.entity.Address;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AddressRepository implements PanacheRepository<Address> {

    public List<Address> findAddressesByPerson(Long personId) {
        return find("FROM Address a WHERE a.person = ?1", personId).list();
    }
}
