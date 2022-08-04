package stepDefinitions.CheckOut;

import gherkin.lexer.Th;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import stepDefinitions.UserRegLog.userRegLog;
import webPages.BillingPage;
import webPages.ProductItemPage;
import webPages.SearchPage;
import webPages.ShoppingCartPage;

public class checkOut {

    WebDriver driver = null;
    ProductItemPage productItemPage = null;
    SearchPage searchPage = null;
    ShoppingCartPage shoppingCartPage = null;
    BillingPage billingPage = null;
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
        billingPage = new BillingPage(driver);
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

    @And("user clicks the policy checkbox and checkout button")
    public void userClicksThePolicyCheckboxAndCheckoutButton() {
        shoppingCartPage.TOScheckBoxPOM().click();
        shoppingCartPage.checkOutButtonPOM().click();
    }

    @And("user inputs billing personal info to checkout country: {string} city: {string} address: {string} zip code: {string} phone: {string}")
    public void userInputsBillingPersonalInfoToCheckout(String country,String city,String address,String zipCode,String phone) throws InterruptedException {
        Thread.sleep(2000);
        try{
            billingPage.selectPreviousAddressPOM().isDisplayed();
        } catch (Exception e){
            billingPage.countrySelectionPOM().selectByVisibleText(country);
            billingPage.cityInPOM().sendKeys(city);
            billingPage.addressInPOM().sendKeys(address);
            billingPage.zipCodeInPOM().sendKeys(zipCode);
            billingPage.phoneNumberInPOM().sendKeys(phone);
        }

        billingPage.step1ContinueButtonPOM().click();
        Thread.sleep(1000);
        billingPage.step3ContinueButtonPOM().click();
        Thread.sleep(1000);
        billingPage.step4ContinueButtonPOM().click();
        Thread.sleep(1000);
        billingPage.step5ContinueButtonPOM().click();
        Thread.sleep(1000);
        billingPage.step6ContinueButtonPOM().click();
        Thread.sleep(2000);
    }

    @Then("check if checkOut was successful")
    public void checkIfCheckOutWasSuccessful() {
        String orderExpectedNumber = billingPage.getOrderNumber();
        billingPage.orderDetailsLinkPOM().click();
        String orderActualNumber = billingPage.getOrderDetailsPageOrderNumber();

        Assert.assertEquals("The order num shown on checkout is diffrent than the one on the order details",
                orderExpectedNumber,orderActualNumber);
    }
}
