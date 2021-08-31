package br.com.bank.assembly.request;

import br.com.bank.assembly.response.PersonResponse;
import br.com.bank.enumeration.AddressTypeEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
public class AddressRequest {

    private String zipCode;
    @NotBlank(message = "State is mandatory")
    private String state;
    @NotBlank(message = "City is mandatory")
    private String city;
    @NotBlank(message = "Street address is mandatory")
    private String streetAddress;
    private Integer number;
    private String complement;
    private String neighborhood;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Type address is mandatory")
    private AddressTypeEnum typeAddress;

    private PersonResponse person;
}
