import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.annotations.*;
import pageobjects.MainPage;
import utils.MyScreenRecorder;

import java.util.concurrent.TimeUnit;

public class IPSTest extends SetUpTest{



    @Test(description = "IPS testing logo button",groups = {"MainPage"},priority = 1)
    public void IPS_Testing_Logo_Button() throws Exception {
        MyScreenRecorder.startRecording("IPS_Testing_Logo_Button");
        extentTest = extentReports.createTest("IPS Logo Button","Validate that logo button redirects to main page");
        MainPage mainPage = new MainPage(driver);
        extentTest.log(Status.INFO,"Navigate to IPS Webiste");
        mainPage.navigate();
        extentTest.log(Status.INFO,"Clck on logo button and validate URL");
        try {
            mainPage.validateLogo();

        }catch (AssertionError error){
            error.getStackTrace();
        }
        extentTest.pass(MediaEntityBuilder.createScreenCaptureFromPath("Main Page.png").build());
        Shutterbug.shootPage(driver).highlight(mainPage.getLogo_button()).withName("Logo Button Screenshot").save("../IPSDemo/screenshots/");
        Shutterbug.shootPage(driver, Capture.FULL).withName("Main Page").save();
        MyScreenRecorder.stopRecording();
    }






}

