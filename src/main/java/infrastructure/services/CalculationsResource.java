package infrastructure.services;

import api.Api;
import api.dto.in.CalculationInputsDto;
import api.dto.out.CalculationResultsDto;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calculate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculationsResource {
    @Inject
    Api api;

    @POST
    public CalculationResultsDto calculateExpression(@Valid CalculationInputsDto dto) {
        return api.calculate(dto);
    }
}
