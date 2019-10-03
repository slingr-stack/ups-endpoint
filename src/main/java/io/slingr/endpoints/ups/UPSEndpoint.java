package io.slingr.endpoints.ups;

import io.slingr.endpoints.Endpoint;
import io.slingr.endpoints.framework.annotations.EndpointProperty;
import io.slingr.endpoints.framework.annotations.SlingrEndpoint;
import org.apache.log4j.Logger;

@SlingrEndpoint(name = "fedex")
public class UPSEndpoint extends Endpoint {

    private static final Logger logger = Logger.getLogger(UPSEndpoint.class);

    @EndpointProperty
    private String environment;

    @EndpointProperty
    private String userName;

    @EndpointProperty
    private String password;

    @EndpointProperty
    private String apiKey;



}
