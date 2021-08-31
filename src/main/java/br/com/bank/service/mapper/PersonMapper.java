package br.com.bank.service.mapper;

import br.com.bank.assembly.message.person.PersonProduceCreateDTO;
import br.com.bank.assembly.request.PersonParserRequest;
import br.com.bank.assembly.request.PersonRequest;
import br.com.bank.assembly.response.PersonResponse;
import br.com.bank.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface PersonMapper {

    PersonResponse map(Person entity);

    Person map(PersonRequest request);

    Person map(PersonParserRequest request);

    Person map(PersonRequest request, @MappingTarget Person entity);

    PersonProduceCreateDTO toProducerCreated(String origin, String method, Person entity);
}
