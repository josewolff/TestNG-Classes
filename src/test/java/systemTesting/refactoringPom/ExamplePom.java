package systemTesting.refactoringPom;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import systemTesting.refactoringPom.elementActions.FormActions;
import systemTesting.refactoringPom.pageObject.FormElements;
import systemTesting.setUp.InitDriver;
import utils.GlobalVariables;

public class ExamplePom extends InitDriver {

    private FormActions formActions;

    @BeforeClass(alwaysRun = true)
    public void initPageFactories(){
        formActions =  new FormActions(driver, wait);
    }

    @BeforeMethod(alwaysRun = true)
    public void goToPage(){
        driver.get(GlobalVariables.seleniumHost);
    }


    @Test(groups = {"system","bootstrapExample","refactorPom"})
    public void bootstrapExample() throws InterruptedException {
        formActions.fillFormComplete();
        Thread.sleep(5000);
    }
}
