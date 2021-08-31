package br.com.bank.assembly.response;

import lombok.Data;

@Data
public class ViaCepAddressResponse {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String gia;
}
