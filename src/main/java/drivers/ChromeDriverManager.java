package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager{


    protected void createWebDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }
}
