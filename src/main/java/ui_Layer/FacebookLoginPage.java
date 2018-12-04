package ui_Layer;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
        emailAddressFld.sendKeys(email);
        passwordFld.sendKeys(pass);
        loginBtn.click();

    }

    public void verifyErrorMessage(String messageField,  String errorMessage){
        if(messageField == "email"){
            System.out.println(loginErrorMsg.getText());
            Assert.assertEquals(loginErrorMsg.getText(), errorMessage);
        }else if(messageField == "password"){
            System.out.println(passwordErrorMsg.getText());
            Assert.assertEquals(passwordErrorMsg.getText(), errorMessage);
        }else {
            throw new AssertionError("No such field");
        }

    }




}
