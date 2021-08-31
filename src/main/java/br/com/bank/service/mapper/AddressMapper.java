package br.com.bank.service.mapper;

import br.com.bank.assembly.request.AddressParseRequest;
import br.com.bank.assembly.request.AddressRequest;
import br.com.bank.assembly.response.AddressResponse;
import br.com.bank.entity.Address;
import br.com.bank.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface AddressMapper {

    AddressResponse map(Address entity);

    Address map(AddressRequest request);

    AddressRequest map(AddressParseRequest request, Person person);

    Address map(AddressParseRequest request, @MappingTarget Address entity);
}
