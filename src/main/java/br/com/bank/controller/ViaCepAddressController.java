package br.com.bank.controller;

import br.com.bank.assembly.response.ViaCepAddressResponse;
import br.com.bank.service.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/ceps")
@Tag(name = "Busca endereço via cep")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ViaCepAddressController {

    private final ViaCepService service;

    @GET
    @Path("/{zipCode}")
    public ViaCepAddressResponse getAddressByPerson(@PathParam("zipCode") String zipCode) {
        return service.viaCep(zipCode);
    }
}