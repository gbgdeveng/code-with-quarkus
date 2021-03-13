package api.dto.in.stocks;

import yahoofinance.histquotes.Interval;

import java.time.temporal.ChronoUnit;

public class TestInputsDto {
    public final String symbol;
    public final Integer range;
    public final ChronoUnit rangeUnit;
    public final Interval interval;

    public TestInputsDto(String symbol, Integer range, ChronoUnit rangeUnit, Interval interval) {
        this.symbol = symbol;
        this.range = range;
        this.rangeUnit = rangeUnit;
        this.interval = interval;
    }
}
