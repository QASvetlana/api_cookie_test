package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class cookieHomeworkTest {
    @Test
    public void testCookie() {
        Map<String, String> authData = new HashMap<>();
        authData.put("email", "vinkotov@example.com");
        authData.put("password", "1234");

        Response response = RestAssured
                .given()
                .body(authData)
                .when()
                .post("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        Map<String, String> cookies = response.getCookies();
        System.out.println("/nCookies:");
        System.out.println(cookies);

        assertTrue(cookies.containsKey("auth_sid"), "Response doesn't have 'auth_sid' cookie");
    }
}
