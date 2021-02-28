//package infrastructure.lib;
//
//import io.vertx.core.http.HttpServerRequest;
//import org.apache.commons.io.IOUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.ext.Provider;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//@Provider
//public class RequestLoggingFilter implements ContainerRequestFilter {
//    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);
//
//    @Context
//    UriInfo info;
//
//    @Context
//    HttpServerRequest request;
//
//    @Override
//    public void filter(ContainerRequestContext context) {
//        final String method = context.getMethod();
//        final String path = info.getPath();
//        final String address = request.remoteAddress().toString();
//        String inputs = null;
//        try {
//            inputs = IOUtils.toString(context.getEntityStream(), StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String message = String.format("%s %s from %s",method, path, address);
//        if (!inputs.isEmpty()) {
//            message = String.format("%s Payload: %s", message, inputs);
//        }
//
//        logger.info(message);
//    }
//}
