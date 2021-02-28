package infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.arc.DefaultBean;
import io.quarkus.runtime.configuration.ProfileManager;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

@ApplicationScoped
public class ApiConfigProducer {
    @Inject
    ObjectMapper objectMapper;

    @DefaultBean
    @Singleton
    @Produces
    public ApiConfig apiConfig() {
        String activeProfile = ProfileManager.getActiveProfile();
        switch (activeProfile) {
            case "stub":
                return new StubConfig(objectMapper);
            case "dev":
                return new DevConfig(objectMapper);
            case "staging":
                return new StagingConfig(objectMapper);
            case "prod":
                return new ProdConfig(objectMapper);
            default:
                throw new IllegalStateException("Unknown environment");
        }
    }
}
