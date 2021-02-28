package infrastructure.services;

import api.Api;
import api.dto.in.CalculationInputsDto;
import api.dto.out.CalculationResultsDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/calculate")
public class CalculationsResource {
    @Inject
    Api api;

    @Inject
    ObjectMapper mapper;

    @POST
    public CalculationResultsDto calculateExpression(@Valid CalculationInputsDto dto) {
        return api.calculate(dto);
    }
}
