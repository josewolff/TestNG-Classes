package integrationTests.users;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.testng.annotations.Test;
import utils.GlobalVariables;
import utils.RequestsMakers;
import static org.hamcrest.Matchers.*;

public class GetAllUsers {



    @Test(groups = {"all","getAllUsers"},
            description = "This test gets all the users")
    public void GetAllUsers(){
        String route = GlobalVariables.apiGetAllUsers;
        System.out.println("############################################# \n" +
                "Request: " + route + "\n#############################################");
        Response responseOfService = RequestsMakers.makeGetRequest(route)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .extract().response();
        JSONArray response = new JSONArray(responseOfService.getBody().asString());
        System.out.println(response.toString(10));
        responseOfService.then()
                .body("Id", notNullValue())
                .body("firstName", Matchers.everyItem(not(Matchers.isEmptyString())))
                .body("lastName", Matchers.everyItem(not(Matchers.isEmptyString())))
                .body("userName", Matchers.everyItem(not(Matchers.isEmptyString())));
    }
}
