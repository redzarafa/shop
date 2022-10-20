package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    static final String SITE = "https://www.emag.ro/";
    final static Logger logger = Logger.getLogger(BaseTest.class);
    private static final int WAIT_SEC = 10;
    public static WebDriver driver;

    @BeforeTest
    public static void setUpDriverFor() {
        BasicConfigurator.configure();

        logger.info("Setting up Driver configuration...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(SITE);
        logger.info("maximizing browser window...");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_SEC, TimeUnit.SECONDS);
    }

    @AfterTest(alwaysRun = true)
    public static void tearDown() {
        logger.info("quitting the browser...");
        driver.quit();
        logger.info("Test completed.");
    }

}
