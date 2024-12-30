package com.yaswanth.Gson;



import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;



public class APITesting_ResAssured_GSON {


    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void test_Create_Booking_Positive(){



        Booking booking = new Booking();
        booking.setFirstname("Pramod");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);


        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("lunch");


        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseBooking = response.asString();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);



        BookingResponse bookingResponse = gson.fromJson(jsonResponseBooking, BookingResponse.class);
//        System.out.println(bookingResponse.getBookingid());
//        System.out.println(bookingResponse.getBooking().getFirstname());
        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Pramod");






















    }



}
