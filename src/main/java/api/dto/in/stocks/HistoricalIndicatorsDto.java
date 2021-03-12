package api.dto.in.stocks;

import java.util.List;

public class HistoricalIndicatorsDto {
    public final List<Long> timestamp;
    public final IndicatorsDto indicators;

    public HistoricalIndicatorsDto(List<Long> timestamp, IndicatorsDto indicators) {
        this.timestamp = timestamp;
        this.indicators = indicators;
    }
}
