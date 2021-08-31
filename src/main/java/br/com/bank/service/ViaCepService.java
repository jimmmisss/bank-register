package br.com.bank.service;

import br.com.bank.api.viacep.ViaCepApi;
import br.com.bank.assembly.response.ViaCepAddressResponse;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

import static br.com.bank.service.utils.RegularExpressionUtils.validZipCode;


@ApplicationScoped
@RequiredArgsConstructor
public class ViaCepService {

    @RestClient
    ViaCepApi viaCepApi;

    public ViaCepAddressResponse viaCep(String zipCode) {
        return viaCepApi.findAddressByCep(validZipCode(zipCode));
    }
}
