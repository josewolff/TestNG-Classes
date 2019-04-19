package systemTesting.refactoringPomDifferentClasses.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInformationElements {

    @FindBy(xpath = "//input[contains(@name,'paymentMethod')]/parent::div/label[@for='debit']")
    protected WebElement debitCardOption;

    @FindBy(id = "cc-name")
    protected WebElement creditCardName;

    @FindBy(id = "cc-number")
    protected WebElement creditCardNumber;

    @FindBy(id = "cc-expiration")
    protected WebElement creditCardExpirationDate;

    @FindBy(css = "label + input[id=cc-cvv]")
    protected WebElement securityCodeCreditCard;

    @FindBy(xpath = "//button[contains(text(),'Continue to checkout')]")
    protected WebElement continueBtn;

    private WebDriver driver;

    public PaymentInformationElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
