package br.com.bank.api.viacep;

import br.com.bank.assembly.response.ViaCepAddressResponse;
import br.com.bank.exception.ApiResponseExceptionMapper;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/ws")
@RegisterRestClient
@RegisterProvider(ApiResponseExceptionMapper.class)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ViaCepApi {

    @GET
    @Path("/{code}/json")
    ViaCepAddressResponse findAddressByCep(@PathParam("code") String cep);
}
