package ru.netology.post;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostTest {
    @Test
    void shouldTestHeaders() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("")
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
//                .body('"/* --> ваша проверка здесь <-- */' ")
                        .body("headers", equalTo("{x-forwarded-proto=https, x-forwarded-port=443, host=postman-echo.com, x-amzn-trace-id=Root=1-627f7726-43ab021617561bf73f7708d7, content-length=3, accept=*/*, content-type=text/plain; charset=ISO-8859-1, user-agent=Apache-HttpClient/4.5.3 (Java/11.0.14.1), accept-encoding=gzip,deflate}"))
        ;
    }

    @Test
    void shouldTestUrl() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("text anything") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
//                .body('"/* --> ваша проверка здесь <-- */' ")
                .body("url", equalTo("https://postman-echo.com/post"))
        ;
    }

    @Test
    void shouldTestJson() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("text anything") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
//                .body('"/* --> ваша проверка здесь <-- */' ")
                .body("json", equalTo(null))
        ;
    }

    @Test
    void shouldTestForm() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("text anything") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
//                .body('"/* --> ваша проверка здесь <-- */' ")
                .body("form", equalTo("{}"))
        ;
    }

    @Test
    void shouldTestDataString() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("text anything") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
//                .body('"/* --> ваша проверка здесь <-- */' ")
                .body("data", equalTo("text anything"))
        ;
    }

    @Test
    void shouldTestDataInteger() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("0123456789") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
//                .body('"/* --> ваша проверка здесь <-- */' ")
                .body("data", equalTo("0123456789"))
        ;
    }

    @Test
    void shouldTestDataStrAndInt() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("NBA2K") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
//                .body('"/* --> ваша проверка здесь <-- */' ")
                .body("data", equalTo("NBA2K"))
        ;
    }

    @Test
    void shouldTestStringRus() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Тест на русском") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
//                .body('"/* --> ваша проверка здесь <-- */' ")
                .body("data", equalTo("Тест на русском"))
        ;
    }
}
