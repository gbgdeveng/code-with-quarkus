package api.dto.in.stocks;

import domain.enums.TimeUnit;

public class TestInputsDto {
    public final String symbol;
    public final Integer range;
    public final TimeUnit unit;

    public TestInputsDto(String symbol, Integer range, TimeUnit unit) {
        this.symbol = symbol;
        this.range = range;
        this.unit = unit;
    }
}
