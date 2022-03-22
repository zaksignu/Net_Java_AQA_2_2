package ru.netology;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class PostmanEchoTests {

    private static String requestBody = "{\n" +
            "  \"data\": \"some_value\"\n}";

    @Test
    void postTest() {
        given()
                .baseUri("https://postman-echo.com")
                .header("Content-type", "application/json")
                .body(requestBody) // отправляемые данные (заголовки и query можно выставлять аналогично)
                .when()
                .post("/post")
                .then()
                .body("data.data", equalTo("some_value"));
    }
}
