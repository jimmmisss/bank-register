package br.com.bank.service.mapper;

import br.com.bank.assembly.request.ContactDetailParseRequest;
import br.com.bank.assembly.request.ContactDetailRequest;
import br.com.bank.assembly.response.ContactDetailResponse;
import br.com.bank.entity.ContactDetail;
import br.com.bank.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface ContactDetailMapper {

    ContactDetailResponse map(ContactDetail entity);

    ContactDetail map(ContactDetailRequest request);

    ContactDetailRequest map(ContactDetailParseRequest request, Person person);

    ContactDetail map(ContactDetailParseRequest request, @MappingTarget ContactDetail entity);
}
