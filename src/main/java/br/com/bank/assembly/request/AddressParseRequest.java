package br.com.bank.assembly.request;

import br.com.bank.enumeration.AddressTypeEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
public class AddressParseRequest {

    private String zipCode;
    private String state;
    private String city;
    private String streetAddress;
    private Integer number;
    private String complement;
    private String neighborhood;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Type address is mandatory")
    private AddressTypeEnum typeAddress;
}
