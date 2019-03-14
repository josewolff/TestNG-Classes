package integrationTests.users;

import integrationTests.users.dataProviders.DataProviders;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import utils.GlobalVariables;
import utils.RequestsMakers;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUsers {

    @Test(groups = {"all","DeleteUsers"},
            description = "This test Delete the users a new user.",
            dataProviderClass = DataProviders.class, dataProvider = "createNewUserBody")
    public void DeleteUsers(JSONObject bodyData){
        String route = GlobalVariables.apiDeleteUsers + bodyData.getString("UserName");
        System.out.println("\n----------------------- Delete Users Request ---------------------\n");
        System.out.println("\t\t Request: " + route);
        System.out.println("------------------------------------------------------------\n");
        Response responseOfService = RequestsMakers.makeDeleteRequest(route)
                .then()
                .statusCode(200)
                .extract().response();
        JSONObject response = new JSONObject(responseOfService.getBody().asString());
        System.out.println("Response: \n\t"+ response.toString(10));
        responseOfService.then()
                .body("status", equalTo(1))
                .body("Message", equalTo("UserName: "+ bodyData.getString("UserName") + " deleted."));
    }

    @Test(groups = {"all","DeleteUsers"},
            description = "This test try to delete a user that doesn't exists.")
    public void DeleteNonExistingUser(){
        String nonExistingUserName = "Non-Existing-User";
       // String nonExistingUserName = "lisd";
        String route = GlobalVariables.apiDeleteUsers + nonExistingUserName;
        System.out.println("\n----------------------- Delete Users Request (Non Existing username)---------------------\n");
        System.out.println("\t\t Request: " + route);
        System.out.println("------------------------------------------------------------\n");
        Response responseOfService = RequestsMakers.makeDeleteRequest(route)
                .then()
                .statusCode(200)
                .extract().response();
        JSONObject response = new JSONObject(responseOfService.getBody().asString());
        System.out.println("Response: \n\t"+ response.toString(10));
        responseOfService.then()
                .body("status", equalTo(0))
                .body("Message", equalTo("The UserName: "+ nonExistingUserName + " doesnt exists."));
    }

}
