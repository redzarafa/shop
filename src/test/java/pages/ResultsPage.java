package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage extends BasePage {//extends SalesPage
    private static final By searchResultProductsSelector = By.cssSelector("#card_grid .card-item .card-v2-info");
    private static List<WebElement> searchResultProducts;

    public ResultsPage(WebDriver driver) {
        super(driver);
        searchResultProducts = driver.findElements(searchResultProductsSelector);
    }

    public String getProductTitle(int resultsIndex) {
        return searchResultProducts.get(resultsIndex).getText();
    }

    public ProductPage goToProduct(int positionInResults) {
        if (positionInResults > 3) {
            System.out.println("Results index is >3. Product might not be visible. Try scroll before clicking.");
        }
        WebElement product = searchResultProducts.get(positionInResults);
        product.click();
        return new ProductPage(driver);
    }
}
