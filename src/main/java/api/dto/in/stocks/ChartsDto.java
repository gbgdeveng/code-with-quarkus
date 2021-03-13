package api.dto.in.stocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import domain.datacollection.HistoricalIndicators;
import domain.enums.Symbol;

import javax.ws.rs.NotFoundException;
import java.util.List;

public class ChartsDto {
    public final ChartDto chart;

    public ChartsDto(@JsonProperty("chart") ChartDto chart) {
        this.chart = chart;
    }

    public static class ChartDto {
        List<HistoricalIndicatorsDto> result;

        public ChartDto(@JsonProperty("result") List<HistoricalIndicatorsDto> result) {
            this.result = result;
        }
    }

    public HistoricalIndicators toDomain() {
        HistoricalIndicatorsDto indicators = chart.result
                                                  .stream()
                                                  .findFirst()
                                                  .orElseThrow(() -> new NotFoundException("No indicators were returned"));
        QuoteDto quote = indicators.indicators.quote.stream().findFirst()
                                   .orElseThrow(() -> new NotFoundException("No quote was returned"));
        AdjCloseDto adjClose = indicators.indicators
                                         .adjClose
                                         .stream()
                                         .findFirst()
                                         .orElseThrow(() -> new NotFoundException("No adjclose was returned"));


        System.out.println(indicators.meta.symbol);
        return HistoricalIndicators.create(Symbol.parse(indicators.meta.symbol),
                                           indicators.timestamp,
                                           quote.open,
                                           quote.close,
                                           quote.low,
                                           quote.high,
                                           quote.volume,
                                           adjClose.adjClose);
    }
}
