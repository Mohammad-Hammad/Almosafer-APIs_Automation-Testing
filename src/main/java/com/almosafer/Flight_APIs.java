package com.almosafer;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Flight_APIs {
    private static final String BASE_URI = "https://www.almosafer.com";
    private static final String GET_FARES_CALENDAR_ENDPOINT = "/api/v3/flights/flight/get-fares-calender";
    private static final String GET_CURRENCY_LIST_ENDPOINT = "/api/system/currency/list";

    // Performing a POST request and return the response
    // Post dates and origin and destination to see the fares calendar
    public Response postFaresCalendar(String originId, String destinationId) {
        RestAssured.baseURI = BASE_URI;

        // Get today's date as FromDate and plus 6 days as a ToDate to make the FaresCalender shows from today's date and 6 days ahead
        LocalDate today = LocalDate.now();
        LocalDate departureFromDate = today;
        LocalDate departureToDate = today.plusDays(6);

        // Create the JSON body dynamically - extracted from the API payload
        String requestBody = String.format(
                "{\"leg\":[{\"originId\":\"%s\",\"destinationId\":\"%s\",\"departureFrom\":\"%s\",\"departureTo\":\"%s\"}]," +
                        "\"cabin\":\"Economy\",\"pax\":{\"adult\":1,\"child\":0,\"infant\":0},\"stops\":[],\"airline\":[],\"timeSlots\":{},\"airports\":{}}",
                originId, destinationId, departureFromDate, departureToDate);

        // Send POST request with headers
        return given()
                .contentType(ContentType.JSON)
                .headers(getCommonHeaders())
                .body(requestBody)
                .when()
                .post(GET_FARES_CALENDAR_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    public Response getCurrencyList() {
        return RestAssured.given()
                .baseUri(BASE_URI)
                .basePath(GET_CURRENCY_LIST_ENDPOINT)
                .headers(getCommonHeaders())
                .get();
    }
    // A method that store all the common header information to pass them on the headers
    private Map<String, String> getCommonHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("x-platform", "web");
        headers.put("x-locale", "en");
        headers.put("x-currency", "SAR");
        return headers;
    }
}
