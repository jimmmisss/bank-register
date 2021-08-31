package br.com.bank.assembly.request;

import br.com.bank.assembly.response.PersonResponse;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NaturalnessRequest {

    @NotBlank(message = "Country is mandatory")
    private String country;
    @NotBlank(message = "State is mandatory")
    private String state;
    @NotBlank(message = "City is mandatory")
    private String city;
    @NotBlank(message = " person is mandatory")
    private PersonResponse person;
}
