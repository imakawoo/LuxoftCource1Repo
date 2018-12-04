package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Igor on 8/15/2018.
 */
public class Driver {

        private static WebDriver driver;

        public static WebDriver get() {
            return driver;
        }

        public static void set(WebDriver driverInput) {
            driver = driverInput;
        }

        public WebDriverWait wait = new WebDriverWait(driver, 200);


        public static void init() {
            WebDriver driverInput;
            switch (Config.getProperty("test.browser")) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
                    driverInput = new FirefoxDriver();
                    break;
                case "iexplore":
                    System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Driver\\IEDriverServer.exe");
                    driverInput = new InternetExplorerDriver();
                    break;
                case "chrome":
                    //System.setProperty("webdriver.chrome.driver", "../chromedriver");
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
                    driverInput = new ChromeDriver();
                    break;
                default:
                    throw new AssertionError("Unsupported browser: " + Config.getProperty("test.browser"));
            }

            driverInput.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            Driver.set(driverInput);
            get().manage().window().maximize();
        }



}
