package domain.learning;

import domain.stocks.Candle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.Instant;
import java.util.List;

@ApplicationScoped
public class LearningService {

    @Named("csv")
    @Inject
    DataService dataService;

    public String startTraining() {
        Thread thread = new Thread(new TrainingRunnable());
        thread.start();

        return "Training has started at " + Instant.now();
    }

    public List<Candle> readCandles() {
        return dataService.getHistoricCandles();
    }
}
