package com.emag;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;

public class HomePage extends SalesPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ResultsPage getSearchResults(String text) {
        WebElement search = driver.findElement(By.id("searchboxTrigger"));
//        new Actions(driver).moveToElement(search).perform(); //doesn't seam necessary atm
//        search.click(); //doesn't seam necessary atm
        search.sendKeys(text);
        search.sendKeys(Keys.ENTER);

        //intent: return search results page
        return new ResultsPage(driver);
    }



}
