package br.com.bank.assembly.message.address;

import br.com.bank.assembly.response.PersonResponse;
import br.com.bank.enumeration.AddressTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class AddressProduceBaseDTO {

    private Long id;
    private String zipCode;
    private String state;
    private String city;
    private String streetAddress;
    private Integer number;
    private String complement;
    private String neighborhood;
    private AddressTypeEnum typeAddress;
    private PersonResponse customer;

    private String sourceOrigin;
    private String action;
}
