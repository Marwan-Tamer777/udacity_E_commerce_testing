package webPages;

import org.openqa.selenium.By;
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

    @FindBy(className="ico-wishlist")
    WebElement navBarWishlist;

    @FindBy(className="ico-cart")
    WebElement navBarCart;

    public WebElement navRegisterPOM(){
        return driver.findElements(By.cssSelector("div.header-links li a")).get(1);}
    public WebElement navLoginPOM(){
        return driver.findElements(By.cssSelector("div.header-links li a")).get(1); }
    public WebElement navWishlistPOM(){return navBarWishlist;}
    public WebElement navCartPOM(){return navBarCart;}
}
