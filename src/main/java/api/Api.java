package api;

import api.dto.in.CalculationInputsDto;
import api.dto.out.CalculationResultsDto;
import api.dto.out.stocks.CandleDto;
import domain.learning.LearningService;
import domain.template.CalculationInputs;
import domain.template.CalculationResults;
import domain.template.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class Api {

    @Inject
    Service service;
    @Inject
    LearningService learningService;

    public CalculationResultsDto calculate(CalculationInputsDto inputsDto) {
        CalculationInputs inputs = inputsDto.toDomain();
        CalculationResults results = service.calculate(inputs);
        return CalculationResultsDto.fromDomain(results);
    }

    public String startTraining() {
        return learningService.startTraining();
    }

    public List<CandleDto> readCandles() {
        return learningService.readCandles().stream().map(CandleDto::fromDomain).collect(Collectors.toList());
    }
}
