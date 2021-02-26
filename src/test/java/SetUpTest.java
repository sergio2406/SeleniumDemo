import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import drivers.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.w3c.dom.Document;

import java.io.*;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.concurrent.TimeUnit;

public class SetUpTest {

    DriverManager driverManager;
    WebDriver driver;

    ExtentSparkReporter htmlReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeTest
    public void configureReport(){
        htmlReporter = new ExtentSparkReporter("../IPSDemo/report/ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        extentReports.setSystemInfo("Windows","Windows 10");
        extentReports.setSystemInfo("Environment","Production");
        extentReports.setSystemInfo("Username","Business User");


        htmlReporter.config().setReportName("IPS Website Sanity Testing");
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    @BeforeClass(alwaysRun = true)
    public void setup(){
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        this.driver = driverManager.getWebDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){

            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Script Passed", ExtentColor.GREEN));
     //       extentTest.addScreenCaptureFromBase64String("../screenshots/Main Page.png");

        }
        else if(result.getStatus() == ITestResult.FAILURE){
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Script Failed",ExtentColor.RED));
        }else {
            extentTest.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + "Test Sctipt Skipped",ExtentColor.AMBER));
        }
    }

    @AfterClass(alwaysRun = true)
    public void close(){
        this.driver.close();
    }


    @AfterTest
    public void clearReportandPDF() throws IOException{
        extentReports.flush();
    }





}
