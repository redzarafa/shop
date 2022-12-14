package tests;

import org.testng.annotations.Test;
import pages.*;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * 1. Emag <a href="https://www.emag.ro/">...</a>
 * 2. Cauta aspiratoare
 * 3. Alege al 3-lea aspirator afisat
 * 4. Adauga-l in cos
 * 5. Vezi detalii cos - verifica daca a fost adaugat al 3-lea asiprator
 * 6. Sterge - verifica daca a fost sters
 * 7. Intoarce-te in magazin"
 */
public class EmagTest extends BaseTest {

    static final String SEARCH_TEXT = "aspirator";
    static final int resultsIndex = 2;

    @Test
    public void addRemoveReturn() throws InterruptedException {
        System.out.println("Starting...");

        logger.info("opening main page...");
        HomePage homePage = new HomePage(driver);

        logger.info("searching for " + SEARCH_TEXT + "...");
        ResultsPage resultsPage = homePage.getSearchResults(SEARCH_TEXT);
        //keep info for later
        String productTitle = resultsPage.getProductTitle(resultsIndex);

        logger.info("opening product found on position:" + resultsIndex + "...");
        ProductPage productPage = resultsPage.goToProduct(resultsIndex);

        logger.info("adding product to cart, a confirming pop-up should appear...");
        productPage.addToCartRd();

        logger.info("opening cart...");
        CartPage cartPage = productPage.getCartDetails();
        assertTrue(cartPage.inCart(productTitle));

        logger.info("removing item...");
        cartPage.removeProduct();
        assertFalse(cartPage.inCart(productTitle));

        logger.info("going back to store.");
        cartPage.goBackToStore();

        BasePage.driver.quit();
    }

}
