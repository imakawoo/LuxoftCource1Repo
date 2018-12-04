package core;


import org.testng.annotations.*;

import java.io.IOException;

import static core.Config.getBaseURL;
import static core.Config.getProperty;

@Listeners(ScreenshotListener.class)
public class BaseTest {


    @BeforeSuite
    public void init() {
        Driver.init();
        //System.out.println(Config.getBaseURL());
        //Driver.get().get(Config.getBaseURL());



    }

    /*@BeforeMethod
    public void beforeMethodOpenUrl(){
        Driver.get().get(getBaseURL());
    }*/

    @BeforeClass
    public void openURL() {



        Driver.get().get(getBaseURL());
       /// waitSleep(3000);

    }


    @AfterSuite
    public void cleanup() {

        Driver.get().close();
       /* switch (Config.getProperty("test.browser")) {
            case "iexplore":

            {
                try {
                    Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
            Driver.tearDown();
            break;

            default:
                Driver.tearDown();
        }*/


    }
}
