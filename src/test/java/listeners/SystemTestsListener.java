package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import utils.GlobalVariables;
import utils.SetUpUrls;

public class SystemTestsListener  implements ISuiteListener {

    public void onStart(ISuite iSuite) {
        GlobalVariables.env = iSuite.getParameter("env");
        GlobalVariables.seleniumHost = iSuite.getParameter("seleniumHost");
        System.out.println("############################### System Tests - Changing Global Variables ######################################\n");
        System.out.println("\t\t\tEnv: " + GlobalVariables.env);
        System.out.println("\t\t\tHost: " + GlobalVariables.seleniumHost);
        System.out.println("\n################################################################################################\n");
        SetUpUrls.initUrlS();
    }

    public void onFinish(ISuite iSuite) {
    }
}
