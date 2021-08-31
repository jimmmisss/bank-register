package br.com.bank.assembly.response;

import br.com.bank.enumeration.AddressTypeEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class AddressResponse {

    private Long id;
    private String zipCode;
    private String state;
    private String city;
    private String streetAddress;
    private Integer number;
    private String complement;
    private String neighborhood;

    @Enumerated(EnumType.STRING)
    private AddressTypeEnum typeAddress;
    private PersonResponse customer;
}
