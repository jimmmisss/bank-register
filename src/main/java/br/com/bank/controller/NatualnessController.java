package br.com.bank.controller;

import br.com.bank.assembly.request.NaturalnessParseRequest;
import br.com.bank.assembly.request.NaturalnessRequest;
import br.com.bank.assembly.response.NaturalnessResponse;
import br.com.bank.controller.openapi.NaturalnessOpenApi;
import br.com.bank.service.NaturalnessService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

@Path("/v1/naturalidades")
@Tag(name = "Naturalidade do cliente")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NatualnessController implements NaturalnessOpenApi {

    private final NaturalnessService service;

    @GET
    @Path("/{personId}")
    public NaturalnessResponse getNaturalnessByPerson(@PathParam("personId") Long personId) {
        return service.getNaturalnessByPerson(personId);
    }

    @POST
    public Response create(@Valid NaturalnessRequest request) {
        service.create(request);
        return Response.status(CREATED).build();
    }

    @PUT
    @Path("/{personId}")
    public Response update(@PathParam("personId") Long personId,
                           @Valid NaturalnessParseRequest request) {
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