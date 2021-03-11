//package infrastructure.lib;
//
//import com.google.common.collect.Sets;
//import io.vertx.core.http.HttpMethod;
//import org.apache.commons.io.IOUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.json.Json;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.container.PreMatching;
//import javax.ws.rs.ext.Provider;
//import java.io.BufferedInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Optional;
//import java.util.Set;
//
//// Unused
//@Provider
//@PreMatching
//public class BodyLoggingFilter implements ContainerRequestFilter {
//    private static final Logger logger = LoggerFactory.getLogger(BodyLoggingFilter.class);
//    private static final Set<HttpMethod> BODIED_HTTP = Sets.newHashSet(HttpMethod.POST, HttpMethod.PUT);
//
//    @Override
//    public void filter(ContainerRequestContext context) throws IOException {
//        final HttpMethod method = HttpMethod.valueOf(context.getMethod());
//        final String path = Optional.ofNullable(context.getUriInfo().getPath()).orElse("");
//        if (BODIED_HTTP.contains(method)) {
//            InputStream stream = new BufferedInputStream(context.getEntityStream());
//            String inputs = Json.createReader(stream).read().toString();
//            context.setEntityStream(IOUtils.toInputStream(inputs, "UTF-8"));
//
//            if (!inputs.isEmpty()) {
//                String message = String.format("%s %s",method, path);
//                message = String.format("%s body: %s", message, inputs);
//                logger.info(message);
//            }
//        }
//
//    }
//}
