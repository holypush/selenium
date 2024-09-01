import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostText {

    @Test
    private void testPostmanEchoPostRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        // Выполнение POST-запроса
        Response response = RestAssured.given()
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when()
                .post("https://postman-echo.com/post");

        // Проверка кода ответа
        assertEquals(200, response.getStatusCode());

        // Проверка тела ответа
        response.then().body("data", equalTo(requestBody));
    }
}