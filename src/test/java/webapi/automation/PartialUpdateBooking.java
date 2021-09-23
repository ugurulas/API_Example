package webapi.automation;


import com.squareup.okhttp.*;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Test(description="When we deal with PartialUpdateBooking, we should use PATCH Method")
public class PartialUpdateBooking extends BaseClass{

    OkHttpClient client = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(mediaType, "{\r\n    \"firstname\" : \"ugurtest\",\r\n    \"lastname\" : \"Brown\"\r\n}");
    Request request = new Request.Builder()
            .url(BASE_ENDPOINT+"/booking/13")
            .method("PATCH", body)
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .addHeader("Cookie", "token=d80deb495c57e4b")
            .build();
    Response response = client.newCall(request).execute();

    public PartialUpdateBooking() throws IOException {
    }
}
