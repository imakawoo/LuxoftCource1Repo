package ui_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor on 9/5/2018.
 */
public class LoginPage extends BasePage {


    @FindBy(xpath = "//*[@title='Facebook']")
    private WebElement facebookLoginBtn;


    public FacebookLoginPage loginWithFacebook(){
        facebookLoginBtn.click();
        return new FacebookLoginPage();
    }


}
