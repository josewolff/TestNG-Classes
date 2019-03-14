package integrationTests.users.dataProviders;

import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import utils.GlobalVariables;
import utils.ManageFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DataProviders {

    @DataProvider(name = "createNewUserBody")
    public static Iterator<Object[]> createNewUserBody() throws IOException {
        Collection<Object[]> dpInfo = new ArrayList<Object[]>();
        String bodyFormat = ManageFiles.readFile("src/test/resources/createNewUser/CreateNewUserBody.json");
        for (int i = 0; i < GlobalVariables.dataProviderTimes; i++){
            String userName = "UserName"+i;
            String firstName = "FirstName"+i;
            String lastName = "lastName"+i;
            String body = String.format(bodyFormat,userName,firstName, lastName);
            dpInfo.add(new Object[]{new JSONObject(body)});
        }
        return dpInfo.iterator();
    }
}

