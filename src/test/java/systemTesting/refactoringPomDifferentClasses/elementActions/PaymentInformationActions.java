package systemTesting.refactoringPomDifferentClasses.elementActions;

import org.openqa.selenium.WebDriver;
import systemTesting.refactoringPomDifferentClasses.pageObject.PaymentInformationElements;

public class PaymentInformationActions extends PaymentInformationElements {

    public PaymentInformationActions(WebDriver driver) {
        super(driver);
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

    public void fillPaymentInformation(){
        clickDebitCardOptn();
        sendsKeyCardName("Testing Card");
        sendsKeyCardNumber("1234567890");
        sendsKeyExpirationDate("07/2019");
        sendsKeySecurityCode("189");
        clickContinueBtn();
    }
}
