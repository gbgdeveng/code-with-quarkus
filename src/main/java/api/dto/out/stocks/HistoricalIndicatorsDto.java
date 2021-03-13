package api.dto.out.stocks;

import domain.datacollection.HistoricalIndicators;

import java.math.BigDecimal;
import java.util.List;

public class HistoricalIndicatorsDto {
    public final String symbol;
    public final List<Long> timestamps;
    public final List<BigDecimal> open;
    public final List<BigDecimal> close;
    public final List<BigDecimal> low;
    public final List<BigDecimal> high;
    public final List<BigDecimal> volume;
    public final List<BigDecimal> adjClose;

    public HistoricalIndicatorsDto(String symbol, List<Long> timestamps, List<BigDecimal> open, List<BigDecimal> close, List<BigDecimal> low, List<BigDecimal> high, List<BigDecimal> volume, List<BigDecimal> adjClose) {
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
        return new HistoricalIndicatorsDto(domain.symbol().getSymbol(), domain.timestamps(), domain.open(), domain.close(), domain.low(), domain.high(),  domain.volume(), domain.adjClose());
    }
}
