package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.AllianzCalculatorMethods;

import java.util.concurrent.TimeUnit;

public class Base {
    protected WebDriver driver;
    Logger logger = LoggerFactory.getLogger(AllianzCalculatorMethods.class);
    @BeforeMethod
    public void setup() {

        String browser = System.getProperty("browser", "chrome").toLowerCase();
        logger.info("setting up {}", browser);
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            // Add cases for other browsers if needed
            default:
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
