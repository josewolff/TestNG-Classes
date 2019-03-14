package integrationTests.users;

import integrationTests.users.dataProviders.DataProviders;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import utils.GlobalVariables;
import utils.RequestsMakers;

import static org.hamcrest.Matchers.*;

public class CreateNewUser {

    @Test(groups = {"all","CreateNewUser","CreateUsersCorrect"},
            description = "This test creates a new user.",
            dataProviderClass = DataProviders.class, dataProvider = "createNewUserBody")
    public void CreateNewUser(JSONObject bodyData){
        String route = GlobalVariables.apiCreateNewUser;
        System.out.println("\n----------------------- Create User Request ---------------------\n");
        System.out.println("\t\t Request: " + route);
        System.out.println("\t\t Body: " + bodyData.toString());
        System.out.println("------------------------------------------------------------\n");
        Response responseOfService = RequestsMakers.makePostRequest(route, bodyData.toString())
                .then()
                .statusCode(200)
                .extract().response();
        JSONObject response = new JSONObject(responseOfService.getBody().asString());
        System.out.println("Response: \n\t"+ response.toString(10));
        responseOfService.then()
                .body("id", notNullValue())
                .body("firstName", equalTo(bodyData.getString("FirstName")))
                .body("lastName", equalTo(bodyData.getString("LastName")))
                .body("userName", equalTo(bodyData.getString("UserName")));
    }

    @Test(groups = {"all","CreateNewUserTests"},
            description = "This test tries to create users that already exists, the test expect a diffrent response.",
            dependsOnGroups = {"CreateUsersCorrect"},
            dataProviderClass = DataProviders.class, dataProvider = "createNewUserBody")
    public void CreateDuplicatedUser(JSONObject bodyData){
        String route = GlobalVariables.apiCreateNewUser;
        System.out.println("\n----------------------- Create Duplicated User Request ---------------------\n");
        System.out.println("\t\t Request: " + route);
        System.out.println("\t\t Body: " + bodyData.toString());
        System.out.println("------------------------------------------------------------\n");
        Response responseOfService = RequestsMakers.makePostRequest(route, bodyData.toString())
                .then()
                .statusCode(200)
                .extract().response();
        JSONObject response = new JSONObject(responseOfService.getBody().asString());
        System.out.println("Response: \n\t"+ response.toString(10));
        responseOfService.then()
                .body("status", equalTo(0))
                .body("Message", equalTo("The name " + bodyData.getString("UserName") + " already exists."));
    }
}
