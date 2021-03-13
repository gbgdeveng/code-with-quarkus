package infrastructure.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@RegisterRestClient()
public interface YahooClient {

//    @GET
//    @Path("/v7/finance/chart/{symbol}?range={range}{rangeUnit}&interval={interval}{intervalUnit}&indicators=quote&includeTimestamps=true")
//    Uni<ChartsDto> getHistoricalData(@PathParam("symbol") String symbol,
//                                     @PathParam("range") int range,
//                                     @PathParam("rangeUnit") String rangeUnit,
//                                     @PathParam("interval") int interval,
//                                     @PathParam("intervalUnit") String intervalUnit);

    @GET
    @Produces("application/json")
    @Path("v7/finance/chart/AAPL?range=2y&interval=1d&indicators=quote&includeTimestamps=true")
    JsonObject getHistoricalData();
}