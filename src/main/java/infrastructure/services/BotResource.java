package infrastructure.services;

import api.Api;
import api.dto.out.stocks.CandleDto;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bot")
@Produces(MediaType.APPLICATION_JSON)
public class BotResource {
    @Inject
    Api api;

    @PUT()
    @Path("/train")
    public String train() {
        return api.startTraining();
    }

    @GET
    @Path("/candles")
    public List<CandleDto> getCandles() {
        return api.readCandles();
    }
}
