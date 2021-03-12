package infrastructure.lib.exceptions;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
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

        JsonObjectBuilder response = Json.createObjectBuilder()
                                         .add("code", code)
                                         .add("error", exception.getClass().getSimpleName());

        logger.log(Level.SEVERE, "Exception occurred during request.", exception);

        if (!exception.getClass().getSimpleName().equals("MismatchedInputException")) {
            response.add("message", exception.getMessage());
        }

        return Response.status(code)
                .entity(response.build().toString())
                .build();
    }
}

