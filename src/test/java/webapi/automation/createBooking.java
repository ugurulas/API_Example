package webapi.automation;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class createBooking extends BaseClass {
    @Test
    public void createBookingReturns201() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(BASE_ENDPOINT + "/auth");
        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);
        String json = "\"{\\r\\n\\\"firstname\\\" : \\\"Ugur\\\",\\r\\n    \\\"lastname\\\" : \\\"Ulas\\\",\\r\\n    \\\"totalprice\\\" : 222,\\r\\n    \\\"depositpaid\\\" : true,\\r\\n    \\\"bookingdates\\\" : {\\r\\n        \\\"checkin\\\" : \\\"2018-01-01\\\",\\r\\n        \\\"checkout\\\" : \\\"2019-01-01\\\"\\r\\n    },\\r\\n    \\\"additionalneeds\\\" : \\\"Breakfast\\\"\\r\\n}\"";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 201);
    }
}