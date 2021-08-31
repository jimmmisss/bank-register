package br.com.bank.assembly.request;

import br.com.bank.enumeration.FileTypeEnum;
import lombok.Data;

@Data
public class FileStorageParseRequest {

    private String docType;
    private String name;
    private String description;
    private String path;
    private FileTypeEnum fileType;
}

