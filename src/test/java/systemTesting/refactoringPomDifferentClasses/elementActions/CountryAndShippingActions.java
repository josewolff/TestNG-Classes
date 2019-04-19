package systemTesting.refactoringPomDifferentClasses.elementActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import systemTesting.refactoringPomDifferentClasses.pageObject.CountryAndShippingInfoElements;

public class CountryAndShippingActions extends CountryAndShippingInfoElements {

    private WebDriverWait wait;

    public CountryAndShippingActions(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }

    public void fillShippingInfo(){
        sendsKeyZipCode("90210");
        selectCountry("United States");
        selectState("California");
        clickShippingAddressOptn();
    }


    private void selectCountry(String optionToSelect){
        selectOption(country,optionToSelect);
    }

    private void selectState(String optionToSelect){
        selectOption(state,optionToSelect);
    }

    private void sendsKeyZipCode(String zipcodeText){
        zipCode.sendKeys(zipcodeText);
    }

    private void clickShippingAddressOptn(){
        shippingAddress.click();
    }

    private void selectOption(WebElement element, String option){
        element = wait.until(ExpectedConditions.visibilityOf(element));
        Select countrySelect = new Select(element);
        countrySelect.selectByVisibleText(option);
    }
}
