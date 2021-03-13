package api;

import api.dto.in.CalculationInputsDto;
import api.dto.in.stocks.TestInputsDto;
import api.dto.out.CalculationResultsDto;
import api.dto.out.stocks.HistoricalIndicatorsDto;
import domain.datacollection.DataCollectionService;
import domain.enums.Symbol;
import domain.learning.LearningService;
import domain.template.CalculationInputs;
import domain.template.CalculationResults;
import domain.template.Service;
import org.joda.time.DateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.temporal.ChronoUnit;
import java.util.Date;

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
        return HistoricalIndicatorsDto.fromDomain(dataCollectionService.getDailyHistoricalIndicators(Symbol.parse(dto.symbol), getStartDate(dto.range, dto.rangeUnit), dto.interval));
    }

    private Date getStartDate(int duration, ChronoUnit unit) {
        DateTime now = DateTime.now();
        switch (unit) {
            case DAYS:
                return now.minusDays(duration).toDate();
            case MONTHS:
                return now.minusMonths(duration).toDate();
            default:
                return now.minusYears(duration).toDate();
        }
    }
}
