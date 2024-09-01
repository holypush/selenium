import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Put {

    @Test
    public void testPostmanEchoPutRequest() {
        // Тело запроса в формате JSON
        String requestBody = "{\"message\":\"JUST DO IT!\"}";

        // Выполнение PUT-запроса
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("https://postman-echo.com/put");

        // Проверка кода ответа
        assertEquals(200, response.getStatusCode());

        // Проверка тела ответа
        response.then().body("data.message", equalTo("JUST DO IT!"));
    }
}