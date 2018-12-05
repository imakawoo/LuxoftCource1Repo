package ui_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.ExtendedReports.logInfo;

/**
 * Created by Igor on 9/5/2018.
 */
public class NavBarPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement loginBtn;


    public LoginPage clickLogin(){
        loginBtn.click();
        logInfo("Login button is clicked");
        return new LoginPage();
    }







}
