package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class navBar {
    WebDriver driver;

    public navBar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="ico-register")
    WebElement navBarRegister;

    @FindBy(id="ico-login")
    WebElement navBarLogin;

    @FindBy(id="ico-wishlist")
    WebElement navBarWishlist;

    @FindBy(id="ico-cart")
    WebElement navBarCart;

    public WebElement navRegisterPOM(){return navBarRegister;}
    public WebElement navLoginPOM(){return navBarLogin;}
    public WebElement navWishlistPOM(){return navBarWishlist;}
    public WebElement navCartPOM(){return navBarCart;}
}
