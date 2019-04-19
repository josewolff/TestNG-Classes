package systemTesting.exampleWithPom;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import systemTesting.exampleWithPom.pageObject.FormElements;
import systemTesting.setUp.InitDriver;
import utils.GlobalVariables;

public class ExamplePom extends InitDriver {

    private FormElements formElements;

    @BeforeClass(alwaysRun = true)
    public void initPageFactories(){
       formElements =  new FormElements(driver, wait);
    }

    @BeforeMethod(alwaysRun = true)
    public void goToPage(){
        driver.get(GlobalVariables.seleniumHost);
    }


    @Test(groups = {"system","bootstrapExample","Pom"})
    public void bootstrapExample() throws InterruptedException {
        formElements.fillFormComplete();
        Thread.sleep(5000);
    }
}
