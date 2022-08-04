package stepDefinitions.CheckOut;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webPages.ProductItemPage;
import webPages.SearchPage;
import webPages.ShoppingCartPage;

public class checkOut {
    WebDriver driver = null;
    ProductItemPage productItemPage = null;
    SearchPage searchPage = null;
    ShoppingCartPage shoppingCartPage = null;
    @Before
    public void userOpensBrowser(){
        //sets the chrome driver to the exe driver downloaded from the chromium project.
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

        //create a new driver to control the browser from the selenium package.
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        productItemPage = new ProductItemPage(driver);
        searchPage = new SearchPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @After
    public void quitTest(){
        driver.quit();
    }

}
