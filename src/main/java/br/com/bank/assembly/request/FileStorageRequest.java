package br.com.bank.assembly.request;

import br.com.bank.entity.Person;
import br.com.bank.enumeration.FileTypeEnum;
import lombok.Data;

@Data
public class FileStorageRequest {

    private String docType;
    private String name;
    private String description;
    private String path;
    private FileTypeEnum fileType;
    private Person person;
}
