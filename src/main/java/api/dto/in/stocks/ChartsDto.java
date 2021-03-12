package api.dto.in.stocks;

import domain.datacollection.HistoricalIndicators;
import domain.enums.Symbol;

import javax.ws.rs.NotFoundException;
import java.util.List;

public class ChartsDto {
    public final ChartDto chart;

    public ChartsDto(ChartDto chart) {
        this.chart = chart;
    }

    public static class ChartDto {
        List<HistoricalIndicatorsDto> results;
    }

    public HistoricalIndicators toDomain() {
        HistoricalIndicatorsDto indicators = chart.results
                                                  .stream()
                                                  .findFirst()
                                                  .orElseThrow(() -> new NotFoundException("No indicators were returned"));

        AdjCloseDto adjClose = indicators.indicators
                                         .adjClose
                                         .stream()
                                         .findFirst()
                                         .orElseThrow(() -> new NotFoundException("No adjclose was returned"));


        return HistoricalIndicators.create(Symbol.parse(indicators.indicators.symbol),
                                           indicators.timestamp,
                                           indicators.indicators.quote.open,
                                           indicators.indicators.quote.close,
                                           indicators.indicators.quote.low,
                                           indicators.indicators.quote.high,
                                           indicators.indicators.quote.volume,
                                           adjClose.adjClose);
    }
}
