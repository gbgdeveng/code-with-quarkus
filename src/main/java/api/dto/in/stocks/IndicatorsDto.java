package api.dto.in.stocks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class IndicatorsDto {
    public final QuoteDto quote;
    @JsonProperty("adjclose")
    public final List<AdjCloseDto> adjClose;
    public String symbol;

    public IndicatorsDto(QuoteDto quote, List<AdjCloseDto> adjClose) {
        this.quote = quote;
        this.adjClose = adjClose;
    }

    @JsonProperty("meta")
    private void unpackNameFromNestedObject(Map<String, String> meta) {
        symbol = meta.get("symbol");
    }
}
