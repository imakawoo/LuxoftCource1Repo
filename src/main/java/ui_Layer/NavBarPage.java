package ui_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor on 9/5/2018.
 */
public class NavBarPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement loginBtn;


    public LoginPage clickLogin(){
        loginBtn.click();
        return new LoginPage();
    }







}
