package br.com.bank.controller;

import br.com.bank.assembly.request.FileStorageParseRequest;
import br.com.bank.assembly.request.FileStorageRequest;
import br.com.bank.assembly.response.FileStorageResponse;
import br.com.bank.controller.openapi.FileStorageOpenApi;
import br.com.bank.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

@Path("/v1/arquivos")
@Tag(name = "Arquivos do cliente")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FileStorageController implements FileStorageOpenApi {

    private final FileStorageService service;

    @GET
    @Path("/{legalPersonId}")
    public Set<FileStorageResponse> getFileStoragesByPerson(
            @PathParam("legalPersonId") Long legalPersonId) {
        return service.getFileStoragesByPerson(legalPersonId);
    }

    @POST
    public Response create(@Valid FileStorageRequest request) {
        service.create(request);
        return Response.status(CREATED).build();
    }

    @PUT
    @Path("/{legalPersonId}")
    public Response update(@PathParam("legalPersonId") Long legalPersonId, @Valid FileStorageParseRequest request) {
        service.update(legalPersonId, request);
        return Response.status(NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(NO_CONTENT).build();
    }
}