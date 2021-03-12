package infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import infrastructure.config.shared.Environment;

public abstract class ApiConfig {

    private final ObjectMapper objectMapper;

    protected ApiConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public abstract Environment environment();

    public final String getYahooFinanceApiKey() {
        return "df4533e479msh6dd37460bbf2d4dp1f35ddjsne4231c29bd30";
    }
}
