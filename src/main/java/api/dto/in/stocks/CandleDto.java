package api.dto.in.stocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import domain.stocks.Candle;

public class CandleDto {
    //Date	Open	High	Low	Close	Adj Close	Volume
    @JsonProperty("Date")
    public String date;
    @JsonProperty("Open")
    public Double openPrice;
    @JsonProperty("High")
    public Double highPrice;
    @JsonProperty("Low")
    public Double lowPrice;
    @JsonProperty("Close")
    public Double closePrice;
    @JsonProperty("Adj Close")
    public Double adjClosePrice;
    @JsonProperty("Volume")
    public Long volume;

    public CandleDto() {
    }

    public CandleDto(String date, Double openPrice, Double highPrice, Double lowPrice, Double closePrice, Double adjClosePrice, Long volume) {
        this.date = date;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closePrice = closePrice;
        this.adjClosePrice = adjClosePrice;
        this.volume = volume;
    }

    public Candle toDomain() {
        return Candle.create(date, openPrice, highPrice, lowPrice, closePrice, adjClosePrice, volume);
    }
}
