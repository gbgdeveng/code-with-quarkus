package infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import infrastructure.config.shared.Environment;

public class ProdConfig extends ApiConfig {

    public ProdConfig(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    public Environment environment() {
        return Environment.PROD;
    }
}
