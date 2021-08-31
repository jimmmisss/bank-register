package br.com.bank.controller.openapi;

import br.com.bank.assembly.request.FileStorageParseRequest;
import br.com.bank.assembly.request.FileStorageRequest;
import br.com.bank.assembly.response.FileStorageResponse;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.validation.Valid;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

public interface FileStorageOpenApi {

    @Operation(summary = "Return only one")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = FileStorageResponse.class, type = SchemaType.OBJECT)))
    Set<FileStorageResponse> getFileStoragesByPerson(Long page);

    @Operation(summary = "Create object")
    @APIResponse(responseCode = "201", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = FileStorageRequest.class, type = SchemaType.OBJECT)))
    Response create(@Valid FileStorageRequest request);

    @Operation(summary = "Update object")
    @APIResponse(responseCode = "204", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = FileStorageParseRequest.class, type = SchemaType.OBJECT)))
    Response update(@PathParam("legalPersonId") Long legalPersonId,
                    @Valid FileStorageParseRequest request);

    @Operation(summary = "Delete object")
    @APIResponse(responseCode = "204", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(type = SchemaType.INTEGER)))
    Response delete(@PathParam("id") Long id);
}
