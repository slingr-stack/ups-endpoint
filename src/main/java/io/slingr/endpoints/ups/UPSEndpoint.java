package io.slingr.endpoints.ups;

import io.slingr.endpoints.HttpEndpoint;
import io.slingr.endpoints.framework.annotations.EndpointFunction;
import io.slingr.endpoints.framework.annotations.EndpointProperty;
import io.slingr.endpoints.framework.annotations.SlingrEndpoint;
import io.slingr.endpoints.utils.Json;
import io.slingr.endpoints.ws.exchange.FunctionRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

@SlingrEndpoint(name = "ups", functionPrefix = "_")
public class UPSEndpoint extends HttpEndpoint {

    private static final Logger logger = Logger.getLogger(UPSEndpoint.class);

    private static final String PRDUCTION_URL = "https://onlinetools.ups.com/rest";
    private static final String TESTING_URL = "https://wwwcie.ups.com/rest";

    @EndpointProperty
    private String environment;

    @EndpointProperty
    private String userName;

    @EndpointProperty
    private String password;

    @EndpointProperty
    private String apiKey;

    @Override
    public String getApiUri() {
        return StringUtils.equals("PRODUCTION", environment) ? PRDUCTION_URL : TESTING_URL;
    }

    @Override
    public void endpointStarted() {
        this.httpService().setDebug(true);
        this.httpService().setDefaultEmptyPath("");
        this.httpService().setupDefaultHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        this.httpService().setupDefaultHeader("Access-Control-Allow-Methods", "POST");
        this.httpService().setupDefaultHeader("Access-Control-Allow-Origin", "*");
        this.httpService().setupDefaultHeader("Accept", "application/json");
        this.httpService().setupDefaultHeader("Content-Type", "application/json");
    }

    @EndpointFunction(name = "_post")
    public Json postRequest(FunctionRequest request) {

        Json req = request.getJsonParams();
        String path = req.string("path");
        logger.debug(String.format("[POST] request to %s", path));

        Json body = req.json("body");
        if (body == null) {
            body = Json.map();
        }

        setUpsSecurity(body);

        req.set("body", body);
        return httpService().defaultPostRequest(req);

    }

    private void setUpsSecurity(Json body) {

        Json userToken = Json.map()
                .set("UsernameToken", Json.map()
                        .set("Username", userName)
                        .set("Password", password)
                )
                .set("ServiceAccessToken", Json.map()
                        .set("AccessLicenseNumber", apiKey)
                );

        if (body != null) {
            body.set("UPSSecurity", userToken);
        }

    }
}
