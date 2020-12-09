package me.potato;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;

@QuarkusTest
public class MultipartResourceTest {
  @Test
  public void testMultipartDataIsSent() {
    given().when()
           .post("/client/multipart")
           .then()
           .statusCode(Response.Status.OK.getStatusCode())
           .body(containsString("Content-Disposition: form-data; name=\"file\"")
                   , containsStringIgnoringCase("HELLO WORLD")
                   , containsString("fileName")
                   , containsString("greeting.txt"));

  }

}
