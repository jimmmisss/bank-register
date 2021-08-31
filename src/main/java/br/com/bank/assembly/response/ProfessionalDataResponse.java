package br.com.bank.assembly.response;

import br.com.bank.entity.Person;
import lombok.Data;

@Data
public class ProfessionalDataResponse {

    private Long id;
    private String profession;
    private Double salary;
    private String companyName;
    private Person person;
}
