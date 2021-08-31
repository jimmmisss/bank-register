package br.com.bank.assembly.response;

import lombok.Data;

@Data
public class FileStorageResponse {

    private Long id;
    private String docType;
    private String photo;
    private PersonResponse customer;
}