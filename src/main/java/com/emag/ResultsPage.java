package com.emag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends SalesPage {
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage getItemPage(By identifier) {
        driver.findElement(identifier);

        return new ProductPage(driver);
    }
}
