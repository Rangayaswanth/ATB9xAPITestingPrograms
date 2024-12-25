package com.yaswanth.ex_Sample_Check;

import io.restassured.RestAssured;

import java.nio.file.Path;

public class APITesting_002 {
    public static void main(String[] args) {


        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/570001")
                .when()
                    .get()
                .then().log().all().statusCode(200);





    }
}
