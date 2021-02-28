package infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import infrastructure.config.shared.Environment;

public class StubConfig extends ApiConfig {

    public StubConfig(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    public Environment environment() {
        return Environment.DEV;
    }
}
