package systemTesting.refactoringPomDifferentClasses.elementActions;

import org.openqa.selenium.WebDriver;
import systemTesting.refactoringPomDifferentClasses.pageObject.UserInformationElements;

public class UserInformationActions extends UserInformationElements {

    public UserInformationActions(WebDriver driver) {
        super(driver);
    }

    public void fillUserInformation(){
        sendsKeyFirstName("Testing");
        sendsKeyLastName("Class");
        sendsKeyUsername("User");
        sendsKeyEmail("email@yahoo.com");
        sendsKeyAddress("Address Test");
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


}
