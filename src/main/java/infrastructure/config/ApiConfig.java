package infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import infrastructure.config.shared.Environment;

public abstract class ApiConfig {

    private final ObjectMapper objectMapper;

    protected ApiConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public abstract Environment environment();
}
