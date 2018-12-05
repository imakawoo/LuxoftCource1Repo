package ui_Layer;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static core.ExtendedReports.logInfo;

/**
 * Created by Igor on 9/19/2018.
 */
public class FacebookLoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailAddressFld;

    @FindBy(id = "pass")
    private WebElement passwordFld;

    @FindBy(id = "loginbutton")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[@class='_4rbf _53ij']")
    private WebElement loginErrorMsg;

    @FindBy(xpath = "//*[a[contains(@href, 'login_pw_error')]]")
    private WebElement passwordErrorMsg;

    public void setCredentialsAndLogin(String email, String pass){
        logInfo("Send credentials. Email: " + email + " Password: " + pass);
        emailAddressFld.sendKeys(email);
        passwordFld.sendKeys(pass);
        loginBtn.click();
        logInfo("Login button is clicked");

    }

    public void verifyErrorMessage(String messageField,  String errorMessage){
        logInfo("Verifying that field " + messageField + " should have this error" + errorMessage);
        if(messageField == "email"){
            System.out.println(loginErrorMsg.getText());
            logInfo("Expected error: " + errorMessage + "\n Actual errror: " + loginErrorMsg.getText());
            Assert.assertEquals(loginErrorMsg.getText(), errorMessage);
        }else if(messageField == "password"){
            System.out.println(passwordErrorMsg.getText());
            logInfo("Expected error: " + errorMessage + "\n Actual errror: " + loginErrorMsg.getText());
            Assert.assertEquals(passwordErrorMsg.getText(), errorMessage);
        }else {
            throw new AssertionError("No such field");
        }

    }




}
