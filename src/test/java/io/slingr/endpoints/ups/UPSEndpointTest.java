package io.slingr.endpoints.ups;

import io.slingr.endpoints.utils.Json;
import io.slingr.endpoints.utils.tests.EndpointTests;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("For dev purposes only")
public class UPSEndpointTest {

    private static EndpointTests test;
    private static UPSEndpoint endpoint;

    @BeforeClass
    public static void init() throws Exception {
        test = EndpointTests.start(new io.slingr.endpoints.ups.Runner(), "test.properties");
        endpoint = (UPSEndpoint) test.getEndpoint();
    }


    @Test
    public void testRequest() {

    }

}
