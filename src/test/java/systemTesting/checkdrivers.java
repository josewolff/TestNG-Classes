package systemTesting;

import org.testng.annotations.Test;
import systemTestUtils.BrowserActions;
import systemTesting.setUp.InitDriver;
import utils.GlobalVariables;

public class checkdrivers extends InitDriver {

    @Test(groups = {"system"})
    public void f() throws InterruptedException {
        driver.get(GlobalVariables.seleniumHost);
        Thread.sleep(2000);
        BrowserActions actions =  new BrowserActions(driver,wait);
        actions.takeScreenShot("test.png");
    }
}
