package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NavBars {
    WebDriver driver;

    public NavBars(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className="ico-wishlist")
    WebElement navBarWishlist;

    @FindBy(className="ico-cart")
    WebElement navBarCart;

    @FindBy(id="customerCurrency")
    WebElement currencySelectDropDown;

    public WebElement navRegisterPOM(){
        return driver.findElements(By.cssSelector("div.header-links li a")).get(0);}
    public WebElement navLoginPOM(){
        return driver.findElements(By.cssSelector("div.header-links li a")).get(1); }
    public WebElement navWishlistPOM(){return navBarWishlist;}
    public WebElement navCartPOM(){return navBarCart;}

    public Select currencySelectPOM(){return new Select(currencySelectDropDown);}
    public List<WebElement> categoriesPOM(){
        return driver.findElements(By.cssSelector(".header-menu > ul.top-menu > li"));
    }

    public WebElement searchCategoriesPOM(String category){
        List<WebElement> categories = categoriesPOM();

        for(int i=0;i<categories.size();i++){
            if(categories.get(i).getText().toLowerCase().trim().contains(category.toLowerCase().trim())) {
                return categories.get(i);
            }
        }
        return  null;
    }

    public WebElement searchCategoriesPOM(int index){
        return categoriesPOM().get(index);
    }


    public List<WebElement> subCategoriesPOM(){
        return driver.findElements(By.cssSelector(".header-menu > ul.top-menu.notmobile > li > ul > li > a"));
    }

    public WebElement searchSubCategoriesPOM(String subCategory){
        List<WebElement> subCategories = subCategoriesPOM();

        for(int i=0;i<subCategories.size();i++){
            if(subCategories.get(i).getText().toLowerCase().trim().contains(subCategory.toLowerCase().trim())) {
                return subCategories.get(i);
            }
        }
        return  null;
    }

    public WebElement searchSubCategoriesPOM(int index){
        return subCategoriesPOM().get(index);
    }
}
