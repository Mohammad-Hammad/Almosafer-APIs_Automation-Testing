package com.almosafer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Activity_APIs {
    private static final String BASE_URI = "https://www.almosafer.com/api/ignite";
    private static final String ACTIVITIES_ENDPOINT = "/activities";

    // Performing a GET request and return the response
    // Get the all the activities titles
    public Response getActivities(String categories, int pageNo, int pageSize, String token) {
        RestAssured.baseURI = BASE_URI;

        // Send GET request with dynamic query parameters and headers
        return given()
                .baseUri(BASE_URI)
                .queryParam("categories", categories)
                .queryParam("pageNo", pageNo)
                .queryParam("pageSize", pageSize)
                .header("x-authorization", "Bearer " + token)
                .header("x-platform", "web")
                .header("x-locale", "en")
                .header("x-currency", "SAR")
                .when()
                .get(ACTIVITIES_ENDPOINT)
                .then()
                .extract()
                .response();  // Return the response for further use
    }

}

