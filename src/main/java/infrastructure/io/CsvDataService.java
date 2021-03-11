package infrastructure.io;

import api.dto.in.stocks.CandleDto;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import domain.learning.DataService;
import domain.stocks.Candle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Named("csv")
@ApplicationScoped
public class CsvDataService implements DataService {
    public final String DATA_SET_PATH = "/Users/gustavobeckman/Documents/Projects/code-with-quarkus/src/main/resources/datasets/AAPL.csv";
    @Override
    public List<Candle> getHistoricCandles() {
        List<CandleDto> reads = new ArrayList<>();
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        ObjectReader oReader = csvMapper.reader(CandleDto.class).with(schema);
        try {
            File file = new File(DATA_SET_PATH);
            System.out.println(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Reader reader = new FileReader(DATA_SET_PATH)) {

            System.out.println();
            MappingIterator<CandleDto> mi = oReader.readValues(reader);
            reads.addAll(mi.readAll());

        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.INFO, "unable to load file", e);
        }

        System.out.println(reads.get(10).date + reads.get(11).date);

        Logger.getAnonymousLogger().severe("logging from implementationn");
        return reads.stream().map(CandleDto::toDomain).collect(Collectors.toList());
    }
}
