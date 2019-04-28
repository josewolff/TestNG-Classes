package systemTesting.exampleWithoutPom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import systemTestUtils.BrowserActions;
import systemTesting.setUp.InitDriver;
import utils.GlobalVariables;

public class ExampleNoPom extends InitDriver {

    @BeforeMethod(alwaysRun = true)
    public void goToPage(){
        driver.get(GlobalVariables.seleniumHost);
    }

    @Test(groups = {"system","bootstrapExample","noPom"})
    public void bootstrapExample() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Testing");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys("Class");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("UserName");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("testing@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address"))).sendKeys("address");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zip"))).sendKeys("90210");
        WebElement country = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("country")));
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("United States");
        WebElement state = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("state")));
        Select stateSelect = new Select(state);
        stateSelect.selectByVisibleText("California");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'custom-control')]/label[contains(@for,'same-address')]")))
                .click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name,'paymentMethod')]/parent::div/label[@for='debit']")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cc-name"))).sendKeys("DevOpsClass");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cc-number"))).sendKeys("123412341234");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cc-expiration"))).sendKeys("07/2019");
        BrowserActions br = new BrowserActions(driver,wait);
        br.takeScreenShot("testing.png");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label + input[id=cc-cvv]"))).sendKeys("123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Continue to checkout')]"))).click();
        String f = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).getText();
        //Assert.assertEquals(f,"Testing");
    }
}
