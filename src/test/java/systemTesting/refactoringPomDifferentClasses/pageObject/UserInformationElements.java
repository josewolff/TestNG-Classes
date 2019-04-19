package systemTesting.refactoringPomDifferentClasses.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformationElements {

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

    private WebDriver driver;

    public UserInformationElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
