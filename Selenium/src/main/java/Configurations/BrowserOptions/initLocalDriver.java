package Configurations.BrowserOptions;

import Configurations.BrowserType;
import Configurations.ConfigProperties;
import Configurations.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Properties;


public class initLocalDriver {

    private BrowserType browserType;
    public static WebDriver driver;

    public static void setUpProperties(){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties properties = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigProperties.setProperties(properties);
    }

    public initLocalDriver(BrowserType browserType) {
        this.browserType = browserType;
    }

    public static BrowserType getTypeOfBrowser(){
        setUpProperties();

        return BrowserType
                .valueOf(ConfigProperties
                        .getProperties()
                        .getProperty("browser"));
    }


    public WebDriver getBrowser() {

        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", getBrowserLocation("chrome"));
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", getBrowserLocation("firefox"));
                driver = new FirefoxDriver();
                break;
            case IE:
                System.setProperty("webdriver.ie.driver", getBrowserLocation("ie"));
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalStateException("Nieobsługiwana Przeglądarka!");
        }
        return driver;
    }

    private String getBrowserLocation(String browser){
        return ConfigProperties
                .getProperties()
                .getProperty(browser + ".driver.location");
    }

    public BrowserType getBrowserType(){
        return browserType;
    }



}
