package emag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class Waiter {

    private static final int BASE_WAIT_SEC = 3;
    private static final int STANDARD_MILLIES = 2500;
    private WebDriverWait wait;

    public Waiter(WebDriver webDriver) {
        wait = new WebDriverWait(webDriver, BASE_WAIT_SEC);
    }

    public static void nap() throws InterruptedException {
        sleep(STANDARD_MILLIES);
    }

    public void waitTillDisplayed(By selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    public void waitTillClickable(By selector) {
        wait.until(ExpectedConditions.elementToBeClickable(selector));
    }
}
