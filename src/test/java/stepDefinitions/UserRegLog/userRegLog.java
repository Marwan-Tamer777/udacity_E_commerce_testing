package stepDefinitions.UserRegLog;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webPages.LoginPage;
import webPages.MyAccountPage;
import webPages.NavBars;
import webPages.RegisterPage;

import java.sql.Driver;

/*
    Testing using Assertion using Testng,selenium  with Cucumber as testing framework.
 */
public class userRegLog {
    WebDriver driver = null;
    static LoginPage loginPage = null;
    RegisterPage registerPage = null;
    NavBars navBars = null;

    MyAccountPage myAccount = null;

    @Before
    public void userOpensBrowser(){
        //sets the chrome driver to the exe driver downloaded from the chromium project.
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

        //create a new driver to control the browser from the selenium package.
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        navBars = new NavBars(driver);
        myAccount = new MyAccountPage(driver);
    }

    @After
    public void quitTest(){
        driver.quit();
    }


    @Given("user navigates to register page")
    public void user_navigates_to_register_page() {
        driver.navigate().to("https://demo.nopcommerce.com/register");

    }

    public static void userEntersValidEmailAndPassword(String email, String password, WebDriver driver) {
        LoginPage log = new LoginPage(driver);
        log.emailPOM().sendKeys(email);
        log.passwordPOM().sendKeys(password);
        log.passwordPOM().sendKeys(Keys.ENTER);
    }
    @And("user presses enter")
    public void userPressesEnter() {
        driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);
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

    @Given("user navigates to login page")
    public void userNavigatesToLoginPage() {
        driver.navigate().to("https://demo.nopcommerce.com/login");

    }

    @When("user enters valid email {string} and password {string}")
    public void userEntersValidEmailAndPassword(String email, String password) {
        loginPage.emailPOM().sendKeys(email);
        loginPage.passwordPOM().sendKeys(password);
        loginPage.passwordPOM().sendKeys(Keys.ENTER);
    }

    @Then("check if logged in")
    public void checkIfLoggedIn() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue("user is not logged in", navBars.navLoginPOM().getText().contains("Log out"));
    }


    @Given("logged user {string} {string} navigates to change password page")
    public void loggedUserNavigatesToChangePasswordPage(String email, String password) {
        driver.navigate().to("https://demo.nopcommerce.com/customer/changepassword");

        if(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/login")){
            userEntersValidEmailAndPassword(email,password);
        }

    }

    @When("user enters old password {string} and new password {string}")
    public void userEntersOldPasswordAndNewPassword(String oldPass, String newPass) {
        myAccount.oldPasswordPOM().sendKeys(oldPass);
        myAccount.newPasswordPOM().sendKeys(newPass);
        myAccount.confirmNewPasswordPOM().sendKeys(newPass);
        myAccount.confirmNewPasswordPOM().sendKeys(Keys.ENTER);
    }

    @Then("check for valid password change flash message")
    public void checkForValidPasswordChangeFlashMessage() {

        Assert.assertTrue("Password did not change",myAccount.responseMessagePOM().getText().contains("Password was changed"));
    }
}
