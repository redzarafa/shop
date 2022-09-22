package com.emag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesPage extends Page{

    public SalesPage(WebDriver driver) {
        super(driver);
    }


    public CartPage goToCartPage(){
        final String CART_XPATH = "//*[@id=\"my_cart\"]/i";
        WebElement cart = driver.findElement(By.xpath(CART_XPATH));
        cart.click();
        return new CartPage(driver);
    }
}
