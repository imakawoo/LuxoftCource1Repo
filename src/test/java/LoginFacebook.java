import TestData.TestDataProvider;
import core.BaseTest;
import core.Driver;
import org.testng.annotations.Test;
import ui_Layer.FacebookLoginPage;
import ui_Layer.LoginPage;
import ui_Layer.NavBarPage;

import static core.Config.getBaseURL;
import static core.ExtendedReports.launchTest;

/**
 * Created by Igor on 9/19/2018.
 */
public class LoginFacebook extends BaseTest {

    private NavBarPage navBarPage;

    @Test(dataProvider = "LoginFacebook", dataProviderClass = TestDataProvider.class)
    public void verifyLogin(String email, String password,String errorField, String errorMessage){

        navBarPage = new NavBarPage();


        launchTest("Login Facebook Negative", "Login Facebook verification errors");

        Driver.get().get(getBaseURL());

        LoginPage loginPage = navBarPage.clickLogin();

        FacebookLoginPage facebookLoginPage = loginPage.loginWithFacebook();

        facebookLoginPage.setCredentialsAndLogin(email, password);

        facebookLoginPage.verifyErrorMessage(errorField, errorMessage);




    }



}
