package api;

import api.dto.in.CalculationInputsDto;
import api.dto.out.stocks.HistoricalIndicatorsDto;
import api.dto.in.stocks.TestInputsDto;
import api.dto.out.CalculationResultsDto;
import domain.datacollection.DataCollectionService;
import domain.enums.Symbol;
import domain.learning.LearningService;
import domain.template.CalculationInputs;
import domain.template.CalculationResults;
import domain.template.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Api {

    @Inject
    Service service;
    @Inject
    LearningService learningService;
    @Inject
    DataCollectionService dataCollectionService;

    public CalculationResultsDto calculate(CalculationInputsDto inputsDto) {
        CalculationInputs inputs = inputsDto.toDomain();
        CalculationResults results = service.calculate(inputs);
        return CalculationResultsDto.fromDomain(results);
    }

    public String startTraining() {
        return learningService.startTraining();
    }

    public HistoricalIndicatorsDto readCandles(TestInputsDto dto) {
        return HistoricalIndicatorsDto.fromDomain(dataCollectionService.getDailyHistoricalIndicators(Symbol.parse(dto.symbol), dto.range, dto.unit));
    }
}
