package webapi.automation;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class deleteBooking extends BaseClass {
@Test
    public void deleteBookingTests() {

        // Create JSON body
        Response responseCreate = createBooking();
        responseCreate.prettyPrint();

        // Get bookingId of new booking
        int bookingid = responseCreate.jsonPath().getInt("bookingid");

        // Delete booking
        Response responseDelete = RestAssured.given(rs).auth().preemptive().basic("admin", "password123")
                .delete("/booking/" + bookingid);
        responseDelete.print();

        // Verifications
        // Verify response 201
        Assertions.assertEquals(201, responseDelete.getStatusCode(),  "Status code should be 201, but it's not.");

        Response responseGet = RestAssured.get("https://restful-booker.herokuapp.com/booking/" + bookingid);
        responseGet.print();

        Assertions.assertEquals("Not Found",responseGet.getBody().asString(),  "Body should be 'Not Found', but it's not.");
}
