import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Get {

    private static final String BASE_URL = "https://postman-echo.com/get";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testGetRequest() {
        // Параметры для запроса
        String key1 = "foo1";
        String value1 = "bar1";
        String key2 = "foo2";
        String value2 = "bar2";

        // Выполнение GET-запроса с параметрами
        Response response = given()
                .queryParam(key1, value1)
                .queryParam(key2, value2)
                .when()
                .get();

        // Проверка кода ответа
        assertEquals(200, response.getStatusCode(), "Response code should be 200");

        // Проверка тела ответа
        assertEquals(value1, response.jsonPath().getString("args.foo1"), "Field foo1 value does not match.");
        assertEquals(value2, response.jsonPath().getString("args.foo2"), "Field foo2 value does not match.");
    }
}