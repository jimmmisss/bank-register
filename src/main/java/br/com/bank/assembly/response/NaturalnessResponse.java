package br.com.bank.assembly.response;

import lombok.Data;

@Data
public class NaturalnessResponse {

    private Long id;
    private String country;
    private String state;
    private String city;
}
