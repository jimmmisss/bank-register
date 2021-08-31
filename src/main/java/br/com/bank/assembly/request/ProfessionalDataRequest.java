package br.com.bank.assembly.request;

import br.com.bank.entity.Person;
import lombok.Data;

@Data
public class ProfessionalDataRequest {

    private String occupation;
    private String company;
    private Person person;
}