package infrastructure.services;

import api.Api;
import api.dto.in.stocks.TestInputsDto;
import api.dto.out.stocks.HistoricalIndicatorsDto;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

    @POST
    @Path("/candles")
    public HistoricalIndicatorsDto getCandles(@Valid TestInputsDto dto) {
        return api.readCandles(dto);
    }
}
