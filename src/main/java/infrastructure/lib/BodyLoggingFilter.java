package infrastructure.lib;

import com.google.common.collect.Sets;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

@Provider
@PreMatching
public class BodyLoggingFilter implements ContainerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(BodyLoggingFilter.class);
    private static final Set<HttpMethod> BODIED_HTTP = Sets.newHashSet(HttpMethod.POST, HttpMethod.PUT);

    @Context
    UriInfo info;

    @Context
    HttpServerRequest request;

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        final HttpMethod method = HttpMethod.valueOf(context.getMethod());
        final String path = info.getPath();
        if (BODIED_HTTP.contains(method)) {
            InputStream stream = new BufferedInputStream(context.getEntityStream());
            String inputs = Json.createReader(stream).read().toString();
            context.setEntityStream(IOUtils.toInputStream(inputs, "UTF-8"));

            if (!inputs.isEmpty()) {
                String message = String.format("%s %s",method, path);
                message = String.format("%s body: %s", message, inputs);
                logger.info(message);
            }
        }

    }
}
