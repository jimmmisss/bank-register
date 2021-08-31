package br.com.bank.controller;

import br.com.bank.assembly.request.AddressParseRequest;
import br.com.bank.assembly.request.AddressRequest;
import br.com.bank.assembly.response.AddressResponse;
import br.com.bank.controller.openapi.AddressOpenApi;
import br.com.bank.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

@Path("/v1/enderecos")
@Tag(name = "Endereço do cliente")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddressController implements AddressOpenApi {

    private final AddressService service;

    @GET
    @Path("/{personId}")
    public Set<AddressResponse> getAddressByPerson(@PathParam("personId") Long personId) {
        return service.getAddressByPerson(personId);
    }

    @POST
    public Response create(@Valid AddressRequest request) {
        service.create(request);
        return Response.status(CREATED).build();
    }

    @PUT
    @Path("/{personId}")
    public Response update(@PathParam("personId") Long personId, @Valid AddressParseRequest request) {
        service.update(personId, request);
        return Response.status(NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(NO_CONTENT).build();
    }
}