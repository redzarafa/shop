package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.Waiter;

public class BasePage {
    public static WebDriver driver;
    public static Waiter waiter;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waiter = new Waiter(driver);
    }

    public boolean isPresent(By by){
        return !driver.findElements(by).isEmpty();
    }

    public void click(By by) {
        waiter.waitTillDisplayed(by);
        WebElement webElement = driver.findElement(by);
        webElement.click();
    }

    public void send(By by, String key) {
        waiter.waitTillDisplayed(by);
        WebElement webElement = driver.findElement(by);
        webElement.sendKeys(key);
    }


    public ResultsPage getSearchResults(String text) {
        WebElement searchBox = driver.findElement(By.id("searchboxTrigger"));

        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);

        return new ResultsPage(driver);
    }

}
