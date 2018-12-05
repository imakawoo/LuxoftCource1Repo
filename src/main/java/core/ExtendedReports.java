package core;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * Created by IMakarchuk on 05.04.2016.
 */
public class ExtendedReports {

    private static String name;
    private static String description;
    private static ExtentTest test;
    private static ExtentReports report;
    private static ExtentTest logger;

    public ExtendedReports(String testName, String testDescription) {
        name = testName;
        description = testDescription;
    }


    public static ExtentReports extent = new ExtentReports(System.getProperty("user.dir") + "\\HTML_report\\report" + (System.currentTimeMillis()/1000) + ".html", true);

    public static void launchTest(String name, String description) {
        logger = extent.startTest(name, description);
        getReport();
        //return logger;
    }

    public static void getReport() {
        report = extent;
        //return report;
    }

    public static  void logInfo(String log){
        logger.log(LogStatus.INFO, log);
        //return log;
    }
    public static void failTest(){
        logger.log(LogStatus.FAIL, "TEST FAILED");
        report.endTest(logger);
        report.flush();
    }

    public static void passTest(){
        logger.log(LogStatus.PASS, "TEST PASSED");
        report.endTest(logger);
        report.flush();
    }

    public static void skipTest(){
        logger.log(LogStatus.SKIP, "TEST SKIPPED");
        report.endTest(logger);
        report.flush();
    }

    public static void doScreenshot(String imagePath){
        logger.log(LogStatus.INFO, "Snapshot: " + logger.addScreenCapture(imagePath));
        //logger.addScreenCapture(imagePath);
        //logger.addScreencast(imagePath);

    }
    public static void logException(Throwable e){
        logger.log(LogStatus.ERROR, ExceptionUtils.getStackTrace(e));
    }






}