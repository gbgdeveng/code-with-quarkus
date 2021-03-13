package api.dto.in.stocks;

public class MetaDto {
    public final String currency;
    public final String symbol;
    public final String exchangeName;

    public MetaDto(String currency, String symbol, String exchangeName) {
        this.currency = currency;
        this.symbol = symbol;
        this.exchangeName = exchangeName;
    }
}
