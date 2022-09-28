package emag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    final By addToCartButtonSelector = By.cssSelector(".flex-item .yeahIWantThisProduct");
    final By cartDetailsButtonSelector = By.cssSelector("body > div.ph-modal.modal.fade.product-purchased-modal.modal-version-.in > div > div > div.modal-body.modal-content-extra-padding.pad-sep-xs.hidden-xs > div > div.table-cell.col-xs-12.col-sm-2.col-md-2.hidden-xs.hidden-sm > a");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addToCartRd() {
        click(addToCartButtonSelector);
        return this;
    }

    public CartPage getCartDetails() {
        click(cartDetailsButtonSelector);
        return new CartPage(driver);
    }

    public String getProductName() {
        return driver.getTitle();
    }
}
