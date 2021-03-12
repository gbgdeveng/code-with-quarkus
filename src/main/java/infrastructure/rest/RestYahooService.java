package infrastructure.rest;

import api.dto.in.stocks.ChartsDto;
import domain.datacollection.HistoricalIndicators;
import domain.enums.Symbol;
import domain.enums.TimeUnit;
import infrastructure.rest.client.YahooClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RestYahooService {

    @Inject
    @RestClient
    YahooClient yahooClient;

    public HistoricalIndicators getDailyHistoricalIndicators(Symbol symbol, int range, TimeUnit unit) {
        ChartsDto dto = yahooClient.getHistoricalData(symbol.getSymbol(), range, unit.name().toLowerCase(), 1, TimeUnit.D.name().toLowerCase())
                          .await()
                          .indefinitely();
        return dto.toDomain();
    }
}
