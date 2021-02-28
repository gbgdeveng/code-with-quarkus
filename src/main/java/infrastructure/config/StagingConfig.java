package infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import infrastructure.config.shared.Environment;

public class StagingConfig extends ApiConfig {

    public StagingConfig(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    public Environment environment() {
        return Environment.STAGING;
    }
}
