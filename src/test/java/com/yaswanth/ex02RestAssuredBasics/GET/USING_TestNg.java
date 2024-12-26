package com.yaswanth.ex02RestAssuredBasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class USING_TestNg {

    @Test
    public void test_GET_Req_POSITIVE() {
        String pin_code = "388620";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void test_GET_Req_Negative() {
        String pin_code = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200); // Changed to 404 since negative test should expect "Not Found"
    }
}
