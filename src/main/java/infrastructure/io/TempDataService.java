package infrastructure.io;

import domain.learning.DataService;
import domain.stocks.Candle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named("temp")
@ApplicationScoped
public class TempDataService implements DataService {

    @Override
    public List<Candle> getHistoricCandles() {
        Logger.getAnonymousLogger().severe("logging from tempService");
        return new ArrayList<>();
    }
}
