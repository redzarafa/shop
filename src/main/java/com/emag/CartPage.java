package com.emag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends SalesPage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

//    get cart item

    public void removeProduct() {
        final String removeProductButtonXpath = "//*[@id=\"vendorsContainer\"]/div/div[1]/div/div[2]/div[1]/div[3]/a[1]" ;
        WebElement removeProductButton = driver.findElement(By.xpath(removeProductButtonXpath));
        removeProductButton.click();
    }

    public HomePage goBackToStore(){
        final String backToStoreButtonXpath = "//*[@id=\"empty-cart\"]/div[3]/a[1]";
        WebElement backToStoreButton = driver.findElement(By.xpath(backToStoreButtonXpath));
        backToStoreButton.click();

        return new HomePage(driver);
    }
}
