package br.com.bank.service.mapper;

import br.com.bank.assembly.request.ProfessionalDataParseRequest;
import br.com.bank.assembly.request.ProfessionalDataRequest;
import br.com.bank.assembly.response.ProfessionalDataResponse;
import br.com.bank.entity.Person;
import br.com.bank.entity.ProfessionalData;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface ProfessionalDataMapper {

    ProfessionalDataResponse map(ProfessionalData entity);

    ProfessionalData map(ProfessionalDataRequest request);

    ProfessionalDataRequest map(ProfessionalDataParseRequest request, Person person);

    ProfessionalData map(ProfessionalDataRequest request, @MappingTarget ProfessionalData entity);
}
