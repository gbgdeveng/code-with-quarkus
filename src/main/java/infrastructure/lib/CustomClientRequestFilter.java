package infrastructure.lib;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

// TODO: remove if unused
@Provider
public class CustomClientRequestFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext context) throws IOException {
        final String path = Optional.ofNullable(context.getUri().getPath()).orElse("");
        Logger.getAnonymousLogger().info(context.getHeaders().toString());
        Logger.getAnonymousLogger().info(path);
    }
}
