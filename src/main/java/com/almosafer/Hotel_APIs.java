package com.almosafer;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class Hotel_APIs {
    private static String BASE_URI = "https://www.almosafer.com";
    private static String Carousel_ENDPOINT = "/api/enigma/carousel";
    private static String HotelSummaries_ENDPOINT = "/api/enigma/content/hotels/summaries";

    // Performing a GET request and return the response
    // Get the all the hotels
    public Response getHotelSummaries(String placeId, int pageSize, String segmentId, String token) {
        return given()
                .baseUri(BASE_URI)
                .basePath(HotelSummaries_ENDPOINT)
                .queryParam("placeId", placeId)
                .queryParam("pageSize", pageSize)
                .queryParam("segmentId", segmentId)
                .headers(getCommonHeaders(token))
                .get();
    }
    // Performing a POST request
    // Post cityId and adultsCount to see the hotels carousel
    public Response postCarousel(int cityId, int adultsCount, String token) {
        //Set checkIn and checkOut Dates - (e.x.): CheckIn date is today's date and checkOut date is after 5 days
        LocalDate today = LocalDate.now();
        LocalDate checkInDate = today;
        LocalDate checkOutDate = today.plusDays(5);

        // Create the JSON body dynamically - extracted from the API payload
        String requestBody = "{\n" + "\"cityId\":" + cityId + ",\n" + "\"checkIn\":\"" + checkInDate + "\",\n" + "\"checkOut\": \"" + checkOutDate
                + "\",\n" + "   \"roomsInfo\": [\n" + "{\n" + "\"adultsCount\": " + adultsCount + ",\n" + "\"kidsAges\": []\n" + "}\n" + "]\n" + "}";
        return given()
                .headers(getCommonHeaders(token))
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(BASE_URI + Carousel_ENDPOINT);
    }
    // A method that store all the common header information to pass them on the headers.
    private Map<String, String> getCommonHeaders(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Token", token);
        headers.put("X-Currency", "SAR");
        headers.put("X-Locale", "en");
        headers.put("X-Api-Key", "apikey-hotel");
        headers.put("X-App-Name", "ct-web-hotels-desktop");
        headers.put("X-Platform", "web");
        return headers;
    }
}

