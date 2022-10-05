package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class CartPage extends BasePage {

    final By productListIdentifier = By.cssSelector(".line-item.line-item-main");//TOCHECK
    final By cartProductTitle = By.cssSelector(".line-item-title.main-product-title");
    final By removeProductButtonXpath = By.xpath("//*[@id=\"vendorsContainer\"]/div/div[1]/div/div[2]/div[1]/div[3]/a[1]");
    final By backToStoreButtonXpath = By.xpath("//*[@id=\"empty-cart\"]/div[3]/a[1]");


    //    @FindBy(xpath = backToStoreButtonXpath)//TODO check see CarBase in PageObjectModel
    List<WebElement> cartProducts;

    public CartPage(WebDriver driver) {
        super(driver);
        setCartProducts();
    }

    public CartPage removeProduct() throws InterruptedException {
        click(removeProductButtonXpath);
        waiter.nap();
        setCartProducts();
        return this;
    }

    public HomePage goBackToStore() {
        click(backToStoreButtonXpath);
        return new HomePage(driver);
    }


    private void setCartProducts() {
//        if (driver.findElement(backToStoreButtonXpath).isDisplayed()) {
        if (isPresent(backToStoreButtonXpath)) {
            cartProducts = Collections.emptyList();
        } else {
            waiter.waitTillDisplayed(productListIdentifier);
            cartProducts = driver.findElements(productListIdentifier);
        }
    }


    /**
     * @param productTitle
     * @return true if there is a product (atm only*) with the same title in the cart
     */
    public boolean inCart(String productTitle) {
        boolean found = false;
        if (cartProducts.isEmpty()) {
            return false;
        }
        for (WebElement cartProduct : cartProducts) {
            WebElement titleElement = cartProduct.findElement(cartProductTitle);
            String title = titleElement.getText();
            if (productTitle.contains(title)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
