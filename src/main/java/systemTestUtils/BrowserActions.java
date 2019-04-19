package systemTestUtils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BrowserActions {

    private WebDriver driver;
    private WebDriverWait wait;

    public BrowserActions(WebDriver driver,WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void takeScreenShot(String fileName){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/resources/screenshots/" + fileName));
        } catch (IOException e) {
            System.out.println("################ fail: BrowserActions.takeScreenShot #######################");
            e.printStackTrace();
        }
    }
}
