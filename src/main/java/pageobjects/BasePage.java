package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }

    public void navigate(){
        driver.get("https://www.ipointsystems.com/");
    }


    void click(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    void getText(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.getText();
    }

    void enterText(WebElement webElement,String text){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    void isDisplayedElement(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.isDisplayed();
    }

}
