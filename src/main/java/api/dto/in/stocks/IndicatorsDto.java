package api.dto.in.stocks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class IndicatorsDto {
    public final List<QuoteDto> quote;
    public final List<AdjCloseDto> adjClose;

    public IndicatorsDto(List<QuoteDto> quote, @JsonProperty("adjclose") List<AdjCloseDto> adjClose) {
        this.quote = quote;
        this.adjClose = adjClose;
    }
}
