package com.yaswanth.ex02RestAssuredBasics.PayLoad;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;



public class APITesting_POJO_PayLoad {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;



    @Test
    public void test_POST(){

        booking Booking = new booking();
        Booking.setFirstname("Pramod");
        Booking.setLastname("Brown");
        Booking.setTotalprice(111);
        Booking.setDepositpaid(true);


        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        Booking.setBookingdates(bookingdates);
        Booking.setAdditionalneeds("Lunch");
        System.out.println(Booking);



        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(Booking).log().all();

        Response response = requestSpecification.when().post();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        validatableResponse.body("booking.firstname",Matchers.equalTo("Pramod"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));






















    }






}
