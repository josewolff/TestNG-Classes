package systemTesting.refactoringPom.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormElements {

    @FindBy(id = "firstName")
    protected WebElement firstName;

    @FindBy(id = "lastName")
    protected WebElement lastName;

    @FindBy(id = "username")
    protected WebElement username;

    @FindBy(id = "email")
    protected WebElement email;

    @FindBy(id = "address")
    protected WebElement address;

    @FindBy(id = "zip")
    protected WebElement zipCode;

    @FindBy(id = "country")
    protected WebElement country;

    @FindBy(id = "state")
    protected WebElement state;

    @FindBy(xpath = "//div[contains(@class,'custom-control')]/label[contains(@for,'same-address')]")
    protected WebElement shippingAddress;

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
    private WebDriverWait wait;

    public FormElements(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


}
