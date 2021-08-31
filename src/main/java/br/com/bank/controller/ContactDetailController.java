package br.com.bank.controller;

import br.com.bank.assembly.request.ContactDetailParseRequest;
import br.com.bank.assembly.request.ContactDetailRequest;
import br.com.bank.assembly.response.ContactDetailResponse;
import br.com.bank.controller.openapi.ContactDetailOpenApi;
import br.com.bank.service.ContactDetailService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

@Path("/v1/contatos")
@Tag(name = "Contato do cliente")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactDetailController implements ContactDetailOpenApi {

    private final ContactDetailService service;

    @GET
    @Path("/{personId}")
    public Set<ContactDetailResponse> getContactDetailByPerson(@PathParam("personId") Long personId) {
        return service.getContactDetailByPerson(personId);
    }

    @POST
    public Response create(@Valid ContactDetailRequest request) {
        service.create(request);
        return Response.status(CREATED).build();
    }

    @PUT
    @Path("/{personId}")
    public Response update(@PathParam("personId") Long personId, @Valid ContactDetailParseRequest request) {
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