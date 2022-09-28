import com.emag.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
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

    static final String SITE = "https://www.emag.ro/";
    static final String SEARCH_TEXT = "aspirator";
    static final int resultsIndex = 2;
    static final int millisToWait = 2500;// sleep is temporary, maybe it helps with captcha request prevention


    @Test
    public void addRemoveReturn() {
        try {
            System.out.println("Starting...");

//      * 1. Emag <a href="https://www.emag.ro/">...</a>
            WebDriver driver = setUpDriverFor(SITE);
            HomePage homePage = new HomePage(driver);
            logger.info("opened main page...");
//            sleep(millisToWait);

//     * 2. Cauta aspiratoare
            ResultsPage resultsPage = homePage.getSearchResults(SEARCH_TEXT);
            logger.info("searched for " + SEARCH_TEXT + "...");
//            sleep(millisToWait);

            //keep info for later
            String productTitle = resultsPage.getProductTitle(resultsIndex);

//     * 3. Alege al 3-lea aspirator afisat
            ProductPage productPage = resultsPage.goToProduct(resultsIndex);
            logger.info("opened product found on position:" + resultsIndex + "...");
//            sleep(millisToWait);


//     * 4. Adauga-l in cos
            productPage.addToCartRd();
            logger.info("added product to cart, a confirming pop-up should appear...");
//            sleep(millisToWait);


//     * 5. Vezi detalii cos - verifica daca a fost adaugat al 3-lea asiprator
//        This is on the same page, as pop-up window
            CartPage cartPage = productPage.getCartDetails();
            assertTrue(cartPage.inCart(productTitle));
            logger.info("opened cart...");
//            sleep(millisToWait);


//     * 6. Sterge - verifica daca a fost sters
            cartPage.removeProduct();
            assertFalse (cartPage.inCart(productTitle));
            logger.info("removed item...");
//            sleep(millisToWait);


//     * 7. Intoarce-te in magazin"
            cartPage.goBackToStore();
            logger.info("went back to store.");
//            sleep(millisToWait);

            //quit driver
            Page.driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tearDown();
        }

    }

}
