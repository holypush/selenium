import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Patch {

    @Test
    public void testPatchRequest() {
        // Устанавливаем базовый URI
        RestAssured.baseURI = "https://postman-echo.com";

        // Данные для PATCH-запроса
        String requestBody = "{\"биткоин\":\"BTC\", \"Дуров\":\"Павел\"}";

        // Выполняем PATCH-запрос
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .extract()
                .response();

        // Проверяем код ответа
        response.then().statusCode(200);

        // Проверяем тело ответа
        response.then()
                .body("json.биткоин", equalTo("BTC"))
                .body("json.Дуров", equalTo("Павел"));
    }
}