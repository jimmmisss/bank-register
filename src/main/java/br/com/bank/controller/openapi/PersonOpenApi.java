package br.com.bank.controller.openapi;

import br.com.bank.assembly.request.PersonParserRequest;
import br.com.bank.assembly.request.PersonRequest;
import br.com.bank.assembly.response.PersonResponse;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.validation.Valid;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface PersonOpenApi {

    @Operation(summary = "Return only one")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = PersonResponse.class, type = SchemaType.OBJECT)))
    PersonResponse getPerson(Long page);

    @Operation(summary = "Create object")
    @APIResponse(responseCode = "201", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = PersonParserRequest.class, type = SchemaType.OBJECT)))
    Response create(@Valid PersonParserRequest request);

    @Operation(summary = "Update object")
    @APIResponse(responseCode = "204", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = PersonRequest.class, type = SchemaType.OBJECT)))
    Response update(@PathParam("id") Long id, @Valid PersonRequest request);

    @Operation(summary = "Delete object")
    @APIResponse(responseCode = "204", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(type = SchemaType.INTEGER)))
    Response delete(@PathParam("id") Long id);
}
