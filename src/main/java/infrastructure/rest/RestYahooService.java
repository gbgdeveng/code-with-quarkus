package infrastructure.rest;

import domain.datacollection.HistoricalIndicators;
import domain.enums.Symbol;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@ApplicationScoped
public class RestYahooService {
    public final YahooFinance yahooClient;

    public RestYahooService() {
        this.yahooClient = new YahooFinance();
    }

    public HistoricalIndicators getDailyHistoricalIndicators(Symbol symbol, Date date, Interval interval) {
        Stock stock = new Stock(symbol.getSymbol());
        Calendar from = Calendar.getInstance();
        from.setTime(date);
        try {
            stock = YahooFinance.get(symbol.getSymbol(), from, interval);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return HistoricalIndicators.fromStock(stock);
    }

}
