package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="OldPassword")
    WebElement oldPasswordIn;

    @FindBy(id="NewPassword")
    WebElement newPasswordIn;

    @FindBy(id="ConfirmNewPassword")
    WebElement confirmNewPasswordIn;

    @FindBy(css="#bar-notification > div > p")
    WebElement successMessage;

    @FindBy(css="div.message-error.validation-summary-errors > ul > li")
    WebElement errorOldPasswordMessage;

    public WebElement oldPasswordPOM(){return oldPasswordIn;}
    public WebElement newPasswordPOM(){return newPasswordIn;}
    public WebElement confirmNewPasswordPOM(){return confirmNewPasswordIn;}
    public WebElement responseMessagePOM(){return successMessage;}

    public  WebElement ErrorOldPasswordMessagePOM(){return errorOldPasswordMessage;}
}
