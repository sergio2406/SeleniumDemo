package drivers;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType driverType){
        DriverManager driverManager;

        switch (driverType){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case BRAVE:
                driverManager = new BraveDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected browser type used.");
        }

        return driverManager;

    }
}
