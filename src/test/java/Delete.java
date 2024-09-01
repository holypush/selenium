import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Delete {

    @Test
    public void testDeleteRequest() {
        // Устанавливаем базовый URI
        RestAssured.baseURI = "https://postman-echo.com";

        // Данные для DELETE-запроса
        String requestBody = "{\"foo1\":\"bar1\", \"foo2\":\"bar2\"}";

        // Выполняем DELETE-запрос
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .extract()
                .response();

        // Проверяем код ответа
        response.then().statusCode(200);

        // Проверяем тело ответа
        response.then()
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }
}