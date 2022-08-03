package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    Testing using Assertion using Testng,selenium  with Cucumber as testing framework.
 */
public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id="FirstName")
    WebElement firstNameIn;

    @FindBy(id="LastName")
    WebElement lastNameIn;

    @FindBy(id="Email")
    WebElement emailIn;

    @FindBy(id="Password")
    WebElement passwordIn;

    @FindBy(id="ConfirmPassword")
    WebElement confirmPasswordIn;

    @FindBy(id="register-button")
    WebElement registerButton;

    @FindBy(className = "result")
    WebElement registerResult;

    public WebElement firstNamePOM(){
        return firstNameIn;
    }

    public WebElement lastNamePOM(){
        return lastNameIn;
    }

    public WebElement emailPOM(){
        return emailIn;
    }

    public WebElement passwordPOM(){
        return passwordIn;
    }

    public WebElement confirmPasswordPOM(){return confirmPasswordIn;}

    public WebElement registerButtonPOM(){
        return registerButton;
    }

    public WebElement registerResultPOM() {return registerResult;}
}
