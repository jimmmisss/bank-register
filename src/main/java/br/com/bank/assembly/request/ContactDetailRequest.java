package br.com.bank.assembly.request;

import br.com.bank.assembly.response.PersonResponse;
import lombok.Data;

@Data
public class ContactDetailRequest {

    private String email;
    private String phone;
    private PersonResponse person;
}
