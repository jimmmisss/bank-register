package br.com.bank.controller.openapi;

import br.com.bank.assembly.request.ProfessionalDataRequest;
import br.com.bank.assembly.response.ProfessionalDataResponse;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.validation.Valid;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface ProfessionalDataOpenApi {

    @Operation(summary = "Return only one")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = ProfessionalDataResponse.class, type = SchemaType.OBJECT)))
    ProfessionalDataResponse getProfessionalDataByPerson(Long page);

    @Operation(summary = "Create object")
    @APIResponse(responseCode = "201", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = ProfessionalDataRequest.class, type = SchemaType.OBJECT)))
    Response create(@Valid ProfessionalDataRequest request);

    @Operation(summary = "Update object")
    @APIResponse(responseCode = "204", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = ProfessionalDataRequest.class, type = SchemaType.OBJECT)))
    Response update(@PathParam("personId") Long personId,
                    @Valid ProfessionalDataRequest request);

    @Operation(summary = "Delete object")
    @APIResponse(responseCode = "204", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(type = SchemaType.INTEGER)))
    Response delete(@PathParam("id") Long id);
}
