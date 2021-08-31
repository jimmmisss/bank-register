package br.com.bank.service.mapper;

import br.com.bank.assembly.request.FileStorageParseRequest;
import br.com.bank.assembly.request.FileStorageRequest;
import br.com.bank.assembly.response.FileStorageResponse;
import br.com.bank.entity.FileStorage;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface FileStorageMapper {

    FileStorageResponse map(FileStorage entity);

    FileStorage map(FileStorageRequest request);

    FileStorage map(FileStorageParseRequest request, @MappingTarget FileStorage entity);
}
