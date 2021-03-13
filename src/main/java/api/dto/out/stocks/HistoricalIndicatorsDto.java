package api.dto.out.stocks;

import domain.datacollection.HistoricalIndicators;
import domain.enums.Symbol;

import java.util.List;

public class HistoricalIndicatorsDto {
    public final Symbol symbol;
    public final List<Long> timestamps;
    public final List<Double> open;
    public final List<Double> close;
    public final List<Double> low;
    public final List<Double> high;
    public final List<Long> volume;
    public final List<Double> adjClose;

    public HistoricalIndicatorsDto(Symbol symbol, List<Long> timestamps, List<Double> open, List<Double> close, List<Double> low, List<Double> high, List<Long> volume, List<Double> adjClose) {
        this.symbol = symbol;
        this.timestamps = timestamps;
        this.open = open;
        this.close = close;
        this.low = low;
        this.high = high;
        this.volume = volume;
        this.adjClose = adjClose;
    }

    public static HistoricalIndicatorsDto fromDomain(HistoricalIndicators domain) {
        return new HistoricalIndicatorsDto(domain.symbol(), domain.timestamps(), domain.open(), domain.close(), domain.low(), domain.high(),  domain.volume(), domain.adjClose());
    }
}
