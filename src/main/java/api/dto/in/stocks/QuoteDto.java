package api.dto.in.stocks;

import java.util.List;

public class QuoteDto {
    public final List<Double> open;
    public final List<Double> close;
    public final List<Double> low;
    public final List<Double> high;
    public final List<Long> volume;

    public QuoteDto(List<Double> open, List<Double> close, List<Double> low, List<Double> high, List<Long> volume) {
        this.open = open;
        this.close = close;
        this.low = low;
        this.high = high;
        this.volume = volume;
    }
}
