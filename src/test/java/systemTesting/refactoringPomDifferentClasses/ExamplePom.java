package systemTesting.refactoringPomDifferentClasses;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import systemTesting.refactoringPomDifferentClasses.elementActions.CountryAndShippingActions;
import systemTesting.refactoringPomDifferentClasses.elementActions.PaymentInformationActions;
import systemTesting.refactoringPomDifferentClasses.elementActions.UserInformationActions;
import systemTesting.setUp.InitDriver;
import utils.GlobalVariables;

public class ExamplePom extends InitDriver {

    private UserInformationActions userInfoActions;
    private CountryAndShippingActions countryAndShippingActions;
    private PaymentInformationActions paymentInformationActions;

    @BeforeClass(alwaysRun = true)
    public void initPageFactories(){
        userInfoActions =  new UserInformationActions(driver);
        countryAndShippingActions =  new CountryAndShippingActions(driver,wait);
        paymentInformationActions = new PaymentInformationActions(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void goToPage(){
        driver.get(GlobalVariables.seleniumHost);
    }


    @Test(groups = {"system","bootstrapExample","refactorPomClasses"})
    public void bootstrapExample() throws InterruptedException {
        userInfoActions.fillUserInformation();
        countryAndShippingActions.fillShippingInfo();
        paymentInformationActions.fillPaymentInformation();
        Thread.sleep(5000);
    }
}
