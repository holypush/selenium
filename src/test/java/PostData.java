import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostData {

    @Test
    public void testPostRequest() {
        // Define the base URI
        RestAssured.baseURI = "https://postman-echo.com";

        // Define the request body
        String foo1 = "bar1";
        String foo2 = "bar2";

        // Send the POST request
        Response response = given()
                .contentType("multipart/form-data")
                .multiPart("foo1", foo1)
                .multiPart("foo2", foo2)
                .when()
                .post("/post");

        // Verify the response status code
        response.then().statusCode(200);

        // Verify the response body
        response.then()
                .body("form.foo1", equalTo(foo1))
                .body("form.foo2", equalTo(foo2));
               
    }
}