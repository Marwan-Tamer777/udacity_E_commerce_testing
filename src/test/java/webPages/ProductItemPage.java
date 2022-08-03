package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductItemPage {
    WebDriver driver;

    public ProductItemPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> productsColourOptions(){
        return driver.findElements(By.cssSelector("#color-squares-10 > li span"));
    }

    public boolean checkForProductColorRadio(String color){

        for(WebElement itemColor : productsColourOptions()){
            if(itemColor.getAttribute("title").toLowerCase().trim().contains(color.toLowerCase().trim())){
                return true;
            }
        }

        return false;
    }
}
