package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utils.GlobalVariables;
import utils.SetUpUrls;

public class IntegrationTestsListener implements ISuiteListener {
    public void onStart(ISuite iSuite) {
        GlobalVariables.env = iSuite.getParameter("env");
        GlobalVariables.host = iSuite.getParameter("host");
        System.out.println("############################### Changing Global Variables ######################################\n");
        System.out.println("\t\t\tEnv: " + GlobalVariables.env);
        System.out.println("\t\t\tHost: " + GlobalVariables.host);
        System.out.println("\n################################################################################################\n");
        SetUpUrls.initUrlS();
    }

    public void onFinish(ISuite iSuite) {
    }
}
