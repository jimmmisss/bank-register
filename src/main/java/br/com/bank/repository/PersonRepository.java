package br.com.bank.repository;

import br.com.bank.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    @Transactional
    public Person create(Person request) {
        persist(request);
        return request;
    }
}
