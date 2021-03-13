package infrastructure.rest;

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
         yahooClient.getHistoricalData();
//        return yahooClient.getHistoricalData(symbol.getSymbol(),
//                String.format("%x%s", range, unit.name().toLowerCase()),
//                "1d")
//                .toDomain();

        return HistoricalIndicators.builder().symbol(symbol).build();
    }

}
