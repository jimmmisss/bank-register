package br.com.bank.service.mapper;

import br.com.bank.assembly.request.NaturalnessParseRequest;
import br.com.bank.assembly.request.NaturalnessRequest;
import br.com.bank.assembly.response.NaturalnessResponse;
import br.com.bank.entity.Naturalness;
import br.com.bank.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface NaturalnessMapper {

    NaturalnessResponse map(Naturalness entity);

    Naturalness map(NaturalnessRequest request);

    NaturalnessRequest map(NaturalnessParseRequest request, Person person);

    Naturalness map(NaturalnessParseRequest request, @MappingTarget Naturalness naturalness);
}
