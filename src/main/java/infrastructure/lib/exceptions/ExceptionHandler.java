package infrastructure.lib.exceptions;

import javax.json.Json;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public Response toResponse(Exception exception) {
        int code = 500;

        if (exception instanceof WebApplicationException) {
            code = ((WebApplicationException) exception)
                    .getResponse().getStatus();
        }

        logger.log(Level.SEVERE, "Exception occurred during request.", exception);
        Optional<String> message = Optional.ofNullable(exception.getMessage());

        return Response.status(code)
                .entity(
                        Json.createObjectBuilder()
                                .add("code", code)
                                .add("error", exception.getClass().getSimpleName())
                                .add("message", message.orElse(""))
                                .build().toString()
                )
                .build();
    }
}

