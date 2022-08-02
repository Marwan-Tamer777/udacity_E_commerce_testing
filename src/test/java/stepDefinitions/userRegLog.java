package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webPages.loginPage;
import webPages.navBar;
import webPages.registerPage;

import java.util.Locale;

/*
    Testing using Assertion using Testng,selenium  with Cucumber as testing framework.
 */
public class userRegLog {
    WebDriver driver = null;
    webPages.loginPage loginPage = null;
    webPages.registerPage registerPage = null;
    webPages.navBar navBar = null;

    @Before
    public void userOpensBrowser(){
        //sets the chrome driver to the exe driver downaloded from the chromium porject.
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

        //create a new driver to control the browser from the selenium package.
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new loginPage(driver);
        registerPage = new registerPage(driver);
        navBar = new navBar(driver);
    }


    @Given("user navigates to register page")
    public void user_navigates_to_register_page() {
        driver.navigate().to("https://demo.nopcommerce.com/register");

    }


    @When("user enters valid name, email and password")
    public void userEntersValidNameEmailAndPassword() {

    }

    @And("user presses enter")
    public void userPressesEnter() {
    }

    @Then("check for valid register message")
    public void checkForValidRegisterMessage() throws InterruptedException {

        Assert.assertTrue("Register failed",registerPage.registerResultPOM().getText().contains("Your registration completed"));
        registerPage.registerResultPOM().getText();
    }

    @And("user clicks enter button")
    public void userClicksEnterButton() {
        registerPage.registerButtonPOM().click();
    }

    @When("user enters {string}, {string}, {string}, {string} in register inputs")
    public void userEntersInRegisterInputs(String firstName, String lastName, String email, String password) {
        registerPage.firstNamePOM().sendKeys(firstName);
        registerPage.lastNamePOM().sendKeys(lastName);
        registerPage.emailPOM().sendKeys(email);
        registerPage.passwordPOM().sendKeys(password);
        registerPage.confirmPasswordPOM().sendKeys(password);
    }

    @After
    public void quitTest(){
        driver.quit();
    }
}
