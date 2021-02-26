package pageobjects;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Dictionary;
import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {



    @FindBy(xpath = "//img[@class='desktop-logo']")
    private WebElement logo_button;



    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void validateLogo(){
        click(logo_button);
        String URL = driver.getCurrentUrl();
        if (URL.equals("https://www.ipointsystems.com/")){
            System.out.println("URL direction is correct");
        }else {
            throw new IllegalStateException("URL not working correctly");
        }
    }


    public WebElement getLogo_button() {
        return logo_button;
    }



}
