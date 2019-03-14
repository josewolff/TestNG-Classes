package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

/**
 * Created by josea.wolff on 8/11/18.
 */
public class RequestsMakers {

    public static Response makePostRequest(String route, String bodyData){
        Response responseOfService = given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .body(bodyData.toString())
                .post(route);
        return responseOfService;
    }

    public static Response makeDeleteRequest(String route){
        Response responseOfService = given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .delete(route);
        return responseOfService;
    }

    public static Response makeGetRequest(String route){
        Response responseOfService = given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .when()
                .get(route);
        return responseOfService;
    }
}
