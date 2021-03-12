package api.dto.in.stocks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AdjCloseDto {
    @JsonProperty("adjclose")
    public final List<Double> adjClose;

    public AdjCloseDto(List<Double> adjClose) {
        this.adjClose = adjClose;
    }
}
