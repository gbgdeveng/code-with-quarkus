package domain.learning;

import domain.stocks.Candle;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public interface DataService {
    List<Candle> getHistoricCandles();
}
