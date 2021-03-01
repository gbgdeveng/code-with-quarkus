package infrastructure.lib;

import io.vertx.core.http.HttpServerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonReader;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

@Provider
@PreMatching
public class RequestLoggingFilter implements ContainerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Context
    UriInfo info;

    @Context
    HttpServerRequest request;

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        final String method = context.getMethod();
        final String path = info.getPath();
        InputStream stream = new BufferedInputStream(context.getEntityStream());
        stream.mark(0);
        JsonReader reader = Json.createReader(stream);
        String inputs = reader.read().toString();
        stream.reset();
        context.setEntityStream(stream);

        if (!inputs.isEmpty()) {
            String message = String.format("%s %s",method, path);
            message = String.format("%s body: %s", message, inputs);
            logger.info(message);
        }
    }
}
