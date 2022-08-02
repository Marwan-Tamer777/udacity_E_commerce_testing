package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    Testing using Assertion using Testng,selenium  with Cucumber as testing framework.
 */
public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="Email")
    WebElement email;

    @FindBy(id="Password")
    WebElement password;

    @FindBy(className="login-button")
    WebElement loginButton;


    public WebElement emailPOM(){return email;}
    public WebElement passwordPOM(){return password;}
    public WebElement loginButtonPOM(){return loginButton;}
}
