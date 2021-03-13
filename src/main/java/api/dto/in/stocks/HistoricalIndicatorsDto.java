package api.dto.in.stocks;

import java.util.List;

public class HistoricalIndicatorsDto {
    public final List<Long> timestamp;
    public final IndicatorsDto indicators;
    public final MetaDto meta;

    public HistoricalIndicatorsDto(List<Long> timestamp, IndicatorsDto indicators, MetaDto meta) {
        this.timestamp = timestamp;
        this.indicators = indicators;
        this.meta = meta;
    }
}
