package br.com.bank.controller;

import br.com.bank.assembly.request.PersonParserRequest;
import br.com.bank.assembly.request.PersonRequest;
import br.com.bank.assembly.response.PersonResponse;
import br.com.bank.controller.openapi.PersonOpenApi;
import br.com.bank.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

@Path("/v1/clientes")
@Tag(name = "Cliente")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonController implements PersonOpenApi {

    private final PersonService service;

    @GET
    @Path("/{id}")
    public PersonResponse getPerson(@PathParam("id") Long id) {
        return service.getPerson(id);
    }

    @POST
    public Response create(@Valid PersonParserRequest request) {
        service.create(request);
        return Response.status(CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid PersonRequest request) {
        service.update(id, request);
        return Response.status(NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(NO_CONTENT).build();
    }
}