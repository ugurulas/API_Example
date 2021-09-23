package webapi.automation;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class deleteBooking extends BaseClass {
    @Test
    public void deleteIsSuccessful() throws IOException {

        HttpDelete request = new HttpDelete(BASE_ENDPOINT);

        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 204);
    }
}
