package domain.datacollection;

import domain.enums.Symbol;
import domain.enums.TimeUnit;
import infrastructure.rest.RestYahooService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DataCollectionService {
    //TODO implement input formatter

    @Inject
    RestYahooService yahooService;

    public HistoricalIndicators getDailyHistoricalIndicators(Symbol symbol, int range, TimeUnit unit) {
        return yahooService.getDailyHistoricalIndicators(symbol, range, unit);
    }
}
