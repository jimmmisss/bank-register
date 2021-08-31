package br.com.bank.controller;

import br.com.bank.assembly.request.ProfessionalDataRequest;
import br.com.bank.assembly.response.ProfessionalDataResponse;
import br.com.bank.controller.openapi.ProfessionalDataOpenApi;
import br.com.bank.service.ProfessionalDataService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

@Path("/v1/dados-profissionais")
@Tag(name = "Dados profissionais")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfessionalDataController implements ProfessionalDataOpenApi {

    private final ProfessionalDataService service;

    @GET
    @Path("/{personId}")
    public ProfessionalDataResponse getProfessionalDataByPerson(@PathParam("personId")
                                                                        Long personId) {
        return service.getProfessionalDataByPerson(personId);
    }

    @POST
    public Response create(@Valid ProfessionalDataRequest request) {
        service.create(request);
        return Response.status(CREATED).build();
    }

    @PUT
    @Path("/{personId}")
    public Response update(@PathParam("personId") Long personId,
                           @Valid ProfessionalDataRequest request) {
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