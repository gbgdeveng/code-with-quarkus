package infrastructure.rest.client;

import api.dto.in.stocks.ChartsDto;
import infrastructure.lib.exceptions.ExceptionHandler;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@ApplicationScoped
@RegisterRestClient
@RegisterProvider(ExceptionHandler.class)
@Produces("application/json")
@Consumes("application/json")
public interface YahooClient {

    @GET
    @Path("/v7/finance/chart/{symbol}?range={range}{rangeUnit}&interval={interval}{intervalUnit}&indicators=quote&includeTimestamps=true")
    Uni<ChartsDto> getHistoricalData(@PathParam("symbol") String symbol,
                                     @PathParam("range") int range,
                                     @PathParam("rangeUnit") String rangeUnit,
                                     @PathParam("interval") int interval,
                                     @PathParam("intervalUnit") String intervalUnit);
}
