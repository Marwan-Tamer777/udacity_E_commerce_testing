package stepDefinitions.ShoppingCart;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stepDefinitions.UserRegLog.userRegLog;
import webPages.*;

public class shoppingCart {
    WebDriver driver = null;
    ProductItemPage productItemPage = null;
    SearchPage searchPage = null;
    ShoppingCartPage shoppingCartPage = null;
    WishListPage wishListPage = null;
    CompareItemsPage compareItemsPage = null;
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
        wishListPage = new WishListPage(driver);
        compareItemsPage = new CompareItemsPage(driver);
    }

    @After
    public void quitTest(){
        driver.quit();
    }

    @Given("Logged User {string} {string} navigates to search page")
    public void loggedUserNavigatesToSearchPage(String email, String password) {

        driver.navigate().to("https://demo.nopcommerce.com/login");
        userRegLog.userEntersValidEmailAndPassword(email,password,driver);
        driver.navigate().to("https://demo.nopcommerce.com/search");
    }

    @When("user searches for {string} in search and enters")
    public void userSearchesForInSearchAndEnters(String searchWord) {
        searchPage.searchInPOM().sendKeys(searchWord);
        searchPage.searchInPOM().sendKeys(Keys.ENTER);
    }

    @And("user clicks on first item search option")
    public void userClicksOnFirstItemSearchOption() throws InterruptedException {
        Thread.sleep(1000);
        searchPage.searchResultsPOM(0).click();
    }

    @When("user clicks on add to shopping cart button")
    public void userClicksOnAddToShoppingCartButton() throws InterruptedException {
        productItemPage.addToCartButtonPOM().click();
        Thread.sleep(2000);
    }

    @And("user navigates to shopping cart page")
    public void userNavigatesToShoppingCartPage() {
        driver.navigate().to("https://demo.nopcommerce.com/cart");
    }

    @Then("checks last item {string} on shopping cart list")
    public void checksLastItemOnShoppingCartList(String itemName) {
        System.out.print("Assertion:" + shoppingCartPage.getLastAddedItemName().toLowerCase().trim() + " EXPECTED:" + itemName.toLowerCase().trim()
        + " BOOL:" + shoppingCartPage.getLastAddedItemName().toLowerCase().trim().contains(itemName.toLowerCase().trim()));
        Assert.assertTrue("the added item to the cart isn't the clicked item",
                shoppingCartPage.getLastAddedItemName().toLowerCase().trim().contains(itemName));
    }

    @When("user clicks on add to wish list button")
    public void userClicksOnAddToWishListButton() throws InterruptedException {
        productItemPage.addToWishListButtonPOM().click();
        Thread.sleep(2000);
    }

    @And("user navigates to wish list page")
    public void userNavigatesToWishListPage() {
        driver.navigate().to("https://demo.nopcommerce.com/wishlist");
    }

    @Then("checks last item {string} on wish list list")
    public void checksLastItemOnWishListList(String itemName) {
        Assert.assertTrue("the added item to the wish list isn't the clicked item",
                wishListPage.getLastAddedItemName().toLowerCase().trim().contains(itemName.toLowerCase().trim()));
    }

    @When("user clicks on add to compare list button")
    public void userClicksOnAddToCompareListButton() throws InterruptedException {
        productItemPage.addToCompareButtonPOM().click();
        Thread.sleep(2000);
    }

    @And("user navigates to compare list page")
    public void userNavigatesToCompareListPage() {
        driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
    }

    @Then("checks last item {string} on compare list list")
    public void checksLastItemOnCompareListList(String itemName) {
        Assert.assertTrue("the added item to the compare list isn't the clicked item",
                compareItemsPage.searchIfItemIsCompared(itemName));
    }
}
