package com.almosafer;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class APIs_Test {
    private com.almosafer.Activity_APIs activityAPIs;
    private com.almosafer.Flight_APIs flightAPIs;
    private com.almosafer.Hotel_APIs hotelAPIs;
    private String token;

    // always run to make sure the TestNG run is based on the groups
    @BeforeClass(alwaysRun = true)
    public void setup() {
        // Initialize the Flights, Hotels, and Activities classes
        flightAPIs = new com.almosafer.Flight_APIs();
        hotelAPIs = new com.almosafer.Hotel_APIs();
        activityAPIs = new com.almosafer.Activity_APIs();
        // This token value is taken from my device from the network tap by a POST API, You may need to change it if you want to run this code on another device
        // Also, this token is passed as a request header parameter for the APIs that validate the token
        token = "skdjfh73273$7268u2j89s";
    }

    @Test(groups = "FlightAPIs")
    public void testGetCurrencyList() {
        // Call the getCurrencyList API
        Response response = flightAPIs.getCurrencyList();

        // Assertion and validation on the API response
        Assert.assertEquals(response.statusCode(), 200, "The Expected status code is 200 but the Actual is " + response.getStatusCode());
        Assert.assertNotNull(response.jsonPath().get("base"), "Currency list is empty or null");

        //Print the response if the assertions are passed
        response.prettyPrint();
    }

    @Test(groups = "FlightAPIs")
    public void testPostFaresCalendar() {
        // Setting the Origin & Destination
        String originId = "AMM";
        String destinationId = "DXB";

        // Send the POST request and get the response
        Response response = flightAPIs.postFaresCalendar(originId, destinationId);

        // Assertion and validation on the API response
        assertEquals(response.getStatusCode(), 200, "The Expected status code is 200 but the Actual is " + response.getStatusCode());

        //Print the response if the assertions are passed
        response.prettyPrint();
    }

    @Test(groups = "HotelAPIs")
    public void testGetHotelSummaries() {
        String placeId = "ChIJya-ah6j_kT4RLKd5DW2HU9s"; // Muscat place ID
        int pageSize = 207;
        String segmentId = "1";

        // Call the getCurrencyList API
        Response response = hotelAPIs.getHotelSummaries(placeId, pageSize, segmentId, token);

        // Assertion and validation on the API response
        Assert.assertEquals(response.statusCode(), 200, "The Expected status code is 200 but the Actual is " + response.getStatusCode());
        Assert.assertNotNull(response.jsonPath().get("hotels"), "Hotels list is empty or null");

        //Print the response if the assertions are passed
        response.prettyPrint();
    }

    @Test(groups = "HotelAPIs")
    public void testPostCarousel() {
        // cityID is "Dubai" ID and could be changed to another cityID
        int cityId = 76;
        int adultsCount = 2;

        // Send the POST request and get the response
        Response response = hotelAPIs.postCarousel(cityId, adultsCount, token);

        // Assertion and validation on the API response
        Assert.assertEquals(response.getStatusCode(), 200);  // Check if the status code is 200
        Assert.assertNotNull(response.jsonPath().get("carousels"), "Carousels list is empty or null");

        //Print the response if the assertions are passed
        response.prettyPrint();
    }

    @Test(groups = "ActivityAPIs")
    public void testGetActivities() {
        // Call the getActivities API
        Response response = activityAPIs.getActivities("60", 1, 24, token);

        // Assertion and validation on the API response
        assertEquals(response.getStatusCode(), 200, "The Expected status code is 200 but the Actual is " + response.getStatusCode());
        Assert.assertNotNull(response.jsonPath().get("activities"), "Activities list is empty or null");

        //Print the response if the assertions are passed
        response.prettyPrint();
    }
}