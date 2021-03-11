package api.dto.out.stocks;

import domain.stocks.Candle;

public class CandleDto {
    //Date	Open	High	Low	Close	Adj Close	Volume
    public String date;
    public Double openPrice;
    public Double highPrice;
    public Double lowPrice;
    public Double adjClosePrice;
    public Long volume;

    public CandleDto() {
    }

    public CandleDto(String date, Double openPrice, Double highPrice, Double lowPrice, Double adjClosePrice, Long volume) {
        this.date = date;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.adjClosePrice = adjClosePrice;
        this.volume = volume;
    }

    public static CandleDto fromDomain(Candle domain) {
        return new CandleDto(domain.date(), domain.openPrice(), domain.highPrice(), domain.lowPrice(), domain.adjClosePrice(), domain.volume());
    }
}
