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

    public void send(By by, String text, Keys key) throws InterruptedException {
        waiter.waitTillDisplayed(by);
        WebElement webElement = driver.findElement(by);
        webElement.sendKeys(text);
        waiter.nap();
        webElement.sendKeys(key);
        waiter.nap();
    }

    public String getElementText(By by) {
        waiter.waitTillDisplayed(by);
        WebElement webElement = driver.findElement(by);
        return webElement.getText();
    }

    public ResultsPage getSearchResults(String text) {
        WebElement searchBox = driver.findElement(By.id("searchboxTrigger"));

        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);

        return new ResultsPage(driver);
    }

//
//    public CartPage goToCartPage(){
//        final String CART_XPATH = "//*[@id=\"my_cart\"]/i";
//        WebElement cart = driver.findElement(By.xpath(CART_XPATH));
//        cart.click();
//        return new CartPage(driver);
//    }
}
