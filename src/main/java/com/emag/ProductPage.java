package com.emag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends SalesPage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCartRd(){
        final String addToCartButtonSelector = ".btn.btn-primary.btn-emag.btn-block.yeahIWantThisProduct";

        WebElement addToCartButton = driver.findElement(By.cssSelector(addToCartButtonSelector));
        addToCartButton.click();
    }

    public CartPage getCartDetails(){
        final String  cartDetailsButtonSelector = "body > div.ph-modal.modal.fade.product-purchased-modal.modal-version-.in > div > div > div.modal-body.modal-content-extra-padding.pad-sep-xs.hidden-xs > div > div.table-cell.col-xs-12.col-sm-2.col-md-2.hidden-xs.hidden-sm > a";
        WebElement cartDetailsButton = driver.findElement(By.cssSelector(cartDetailsButtonSelector));

        cartDetailsButton.click();

        return new CartPage(driver);
    }

}
