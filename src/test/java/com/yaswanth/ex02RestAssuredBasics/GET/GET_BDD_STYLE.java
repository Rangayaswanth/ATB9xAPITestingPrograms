package com.yaswanth.ex02RestAssuredBasics.GET;

import io.restassured.RestAssured;

import java.nio.file.Path;

public class GET_BDD_STYLE {

    public static void main(String[] args) {

        String pincode="570001";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);


        pincode="-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);


    }
}