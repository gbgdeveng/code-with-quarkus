package api.dto.in.stocks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AdjCloseDto {
    public final List<Double> adjClose;

    public AdjCloseDto(@JsonProperty("adjclose") List<Double> adjClose) {
        this.adjClose = adjClose;
    }
}
