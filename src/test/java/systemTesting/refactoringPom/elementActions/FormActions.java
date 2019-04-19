package systemTesting.refactoringPom.elementActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import systemTesting.refactoringPom.pageObject.FormElements;

public class FormActions extends FormElements {

    private WebDriverWait wait;

    public FormActions(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        this.wait = wait;
    }

    public void fillFormComplete(){
        sendsKeyFirstName("Testing");
        sendsKeyLastName("Class");
        sendsKeyUsername("User");
        sendsKeyEmail("email@yahoo.com");
        sendsKeyAddress("Address Test");
        sendsKeyZipCode("90210");
        selectCountry("United States");
        selectState("California");
        clickShippingAddressOptn();
        clickDebitCardOptn();
        sendsKeyCardName("Testing Card");
        sendsKeyCardNumber("1234567890");
        sendsKeyExpirationDate("07/2019");
        sendsKeySecurityCode("189");
        clickContinueBtn();
    }

    private void sendsKeyFirstName(String firstNameText){
        firstName.sendKeys(firstNameText);
    }

    private void sendsKeyLastName(String lastNameText){
        lastName.sendKeys(lastNameText);
    }

    private void sendsKeyUsername(String userNameText){
        username.sendKeys(userNameText);
    }

    private void sendsKeyEmail(String emailText){
        email.sendKeys(emailText);
    }

    private void sendsKeyAddress(String addressText){
        address.sendKeys(addressText);
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

    private void clickDebitCardOptn(){
        debitCardOption.click();
    }

    private void sendsKeyCardName(String nameCardOpt){
        creditCardName.sendKeys(nameCardOpt);
    }

    private void sendsKeyCardNumber(String numberCreditCard){
        creditCardNumber.sendKeys(numberCreditCard);
    }

    private void sendsKeyExpirationDate(String expirationDate){
        creditCardExpirationDate.sendKeys(expirationDate);
    }

    private void sendsKeySecurityCode(String securityCode){
        securityCodeCreditCard.sendKeys(securityCode);
    }

    private void clickContinueBtn(){
        continueBtn.click();
    }

    private void selectOption(WebElement element, String option){
        element = wait.until(ExpectedConditions.visibilityOf(element));
        Select countrySelect = new Select(element);
        countrySelect.selectByVisibleText(option);
    }
}
