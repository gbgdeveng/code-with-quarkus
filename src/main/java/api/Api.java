package api;

import api.dto.in.CalculationInputsDto;
import api.dto.out.CalculationResultsDto;
import domain.CalculationInputs;
import domain.CalculationResults;
import domain.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Api {
    public final Service service;

    @Inject
    public Api(Service service) {
        this.service = service;
    }

    public CalculationResultsDto calculate(CalculationInputsDto inputsDto) {
        CalculationInputs inputs = inputsDto.toDomain();
        CalculationResults results = service.calculate(inputs);
        return CalculationResultsDto.fromDomain(results);
    }
}
