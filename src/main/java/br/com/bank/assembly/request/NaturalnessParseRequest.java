package br.com.bank.assembly.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NaturalnessParseRequest {

    @NotBlank(message = "Country is mandatory")
    private String country;
    @NotBlank(message = "State is mandatory")
    private String state;
    @NotBlank(message = "City is mandatory")
    private String city;
}
