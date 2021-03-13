package domain.datacollection;

import domain.enums.Index;
import domain.enums.Symbol;
import infrastructure.rest.RestYahooService;
import org.joda.time.DateTime;
import yahoofinance.histquotes.Interval;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DataCollectionService {
    //TODO implement input formatter

    @Inject
    RestYahooService yahooService;

    public HistoricalIndicators getDailyHistoricalIndicators(Symbol symbol, Date date, Interval interval) {
        System.out.println(getIndexIndicators().toString());
         return yahooService.getDailyHistoricalIndicators(symbol, date, interval).normalize();
    }

    public List<HistoricalIndicators> getIndexIndicators() {
        Date from = DateTime.now().minusYears(1).toDate();
        return Arrays.stream(Index.values())
                .map(idx -> yahooService.getDailyHistoricalIndicators(idx, from, Interval.DAILY))
                .map(HistoricalIndicators::normalize).collect(Collectors.toList());
    }
}
