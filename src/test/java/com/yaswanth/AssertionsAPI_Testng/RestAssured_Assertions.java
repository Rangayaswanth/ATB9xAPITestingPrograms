package com.yaswanth.AssertionsAPI_Testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.requestSpecification;

public class RestAssured_Assertions {



    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;


    @Test
    public void test_restAssured_Assertions_Post(){

        String payload_POST = "{\n" +
                "    \"firstname\": \"Pramod\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        Response response = requestSpecification.when().post();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);





        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("Pramod"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
        validatableResponse.body("bookingid",Matchers.notNullValue());






        }

    }




