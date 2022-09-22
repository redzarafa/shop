package com.emag;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import static java.lang.Thread.sleep;

/**
 * 1. Emag <a href="https://www.emag.ro/">...</a>
 * 2. Cauta aspiratoare
 * 3. Alege al 3-lea aspirator afisat
 * 4. Adauga-l in cos
 * 5. Vezi detalii cos - verifica daca a fost adaugat al 3-lea asiprator
 * 6. Sterge - verifica daca a fost sters
 * 7. Intoarce-te in magazin"
 */
public class Test {

    private static final Logger logger = Logger.getLogger(Test.class); //TODO


    public static void main(String[] args) {
        try {
            logger.setLevel(Level.INFO);
            System.out.println("Starting...");

//      * 1. Emag <a href="https://www.emag.ro/">...</a>
            final String SITE = "https://www.emag.ro/";
            HomePage homePage = new HomePage(setUpDriverFor(SITE));
            System.out.println("opened main page...");

//     * 2. Cauta aspiratoare
            final String SEARCH_TEXT = "aspirator";
            ResultsPage resultsPage = homePage.getSearchResults(SEARCH_TEXT);
            sleep(2500);
            System.out.println("searched for " + SEARCH_TEXT + "...");

//     * 3. Alege al 3-lea aspirator afisat TODO
            //get all  search result products (on the page (?))
//            final String searchResultProductsIdentifier = ".card-item.card-stander.js-product-data .card-v2-info";
//            List<WebElement> searchResultProducts = driver.findElements(By.cssSelector(searchResultProductsIdentifier));
//            //take the n-th/3rd
//            WebElement nthElement = searchResultProducts.get(3-1);


            ProductPage productPage = resultsPage.getItemPage(By.xpath("//*[@id=\"card_grid\"]/div[3]"));
            sleep(2500);
            System.out.println("selected the [shouldBe]third[idtItIsAtm] product...");


            //get item info for later

//     * 4. Adauga-l in cos
            productPage.addToCartRd();
            sleep(2500);
            System.out.println("added product to cart, a confirming pop-up should appear...");


            //could/should check if the pop-u appears
            CartPage cartPage = productPage.getCartDetails();
            sleep(2500);
            System.out.println("opened cart...");


//     * 5. Vezi detalii cos - verifica daca a fost adaugat al 3-lea asiprator TODO
//        This is on the same page, as pop-up window //check item info with above recorded info


//     * 6. Sterge - verifica daca a fost sters TODO
            cartPage.removeProduct();
            sleep(2500);

//     * 7. Intoarce-te in magazin"
            cartPage.goBackToStore();
            sleep(2500);
            System.out.println("went back to store.");


            //quit driver
            ProductPage.driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tearDown();
        }

    }


    public static WebDriver setUpDriverFor(String site) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(site);

        return driver;
    }

//    //maximize window and wait
//    public static void waitToCheckResults(WebDriver driver) {
//        driver.manage().window().maximize();
//        new WebDriverWait(driver, 15);
//    }


    @AfterMethod
    public static void tearDown() {
        Page.driver.quit();
    }
}
