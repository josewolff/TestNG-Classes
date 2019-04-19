package systemTesting.refactoringPomDifferentClasses.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountryAndShippingInfoElements {

    @FindBy(id = "zip")
    protected WebElement zipCode;

    @FindBy(id = "country")
    protected WebElement country;

    @FindBy(id = "state")
    protected WebElement state;

    @FindBy(xpath = "//div[contains(@class,'custom-control')]/label[contains(@for,'same-address')]")
    protected WebElement shippingAddress;

    private WebDriver driver;

    public CountryAndShippingInfoElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
