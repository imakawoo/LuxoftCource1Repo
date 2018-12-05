package TestData;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor on 10/17/2018.
 */
public class TestDataProvider {

    @DataProvider(name = "LoginFacebook", parallel = false)
    public static Iterator<Object[]> createDataLoginFacebook() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{"igor@gmal.com", "anypassword", "password",  "The password you’ve entered is incorrect. Forgot Password?!"});
        data.add(new Object[]{"igormakarchuk@ukr.net", "password", "email", "The email you’ve entered doesn’t match any account. Sign up for an account.!"});
        return data.iterator();
    }


}
