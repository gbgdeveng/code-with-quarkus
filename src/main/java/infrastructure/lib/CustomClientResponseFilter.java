package infrastructure.lib;

import org.apache.commons.io.IOUtils;

import javax.json.Json;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

// TODO: remove if unused
@Provider
public class CustomClientResponseFilter implements ClientResponseFilter {

    @Override
    public void filter(ClientRequestContext req, ClientResponseContext res) throws IOException {
        String resBody = "";
        if (res.hasEntity()) {
            InputStream stream = new BufferedInputStream(res.getEntityStream());
            resBody = Json.createReader(stream).read().toString();
            res.setEntityStream(IOUtils.toInputStream(resBody, "UTF-8"));
        }
        Logger.getAnonymousLogger().info("responseBody: " + resBody);
    }
}
