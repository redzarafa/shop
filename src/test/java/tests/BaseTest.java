import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    final static Logger logger = Logger.getLogger(BaseTest.class);
    private static final int WAIT_SEC = 10;
    public static WebDriver driver;

    public static WebDriver setUpDriverFor(String site) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(site);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(WAIT_SEC, TimeUnit.SECONDS);

        return driver;
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
        logger.info("Test completed.");
    }

}
