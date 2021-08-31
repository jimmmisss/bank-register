package br.com.bank.assembly.request;

import lombok.Data;

@Data
public class ContactDetailParseRequest {

    private String email;
    private String phone;
}
