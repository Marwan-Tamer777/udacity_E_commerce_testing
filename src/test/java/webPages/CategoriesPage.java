package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoriesPage {
    WebDriver driver;

    public CategoriesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".page-title > h1")
    WebElement categoryName;

    public WebElement categoryNamePOM(){return categoryName;}

    public List<WebElement> shoesColorsListItems(){
        return driver.findElements(By.cssSelector(".product-filters  .product-spec-color > li.item"));
    }

    public WebElement searchShoeColorsListItem(String color){
        for(WebElement colorListItem : shoesColorsListItems()){
            if(colorListItem.getText().toLowerCase().trim().contains(color.toLowerCase().trim())) {
                return colorListItem;
            }
        }
        return null;
    }

}
