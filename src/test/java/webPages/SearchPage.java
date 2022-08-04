package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/*
    Testing using Assertion using Testng,selenium  with Cucumber as testing framework.
 */
public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "q")
    WebElement searchIn;


    public WebElement searchInPOM() {
        return searchIn;
    }

    public List<WebElement> ResultsPOM(){
        return driver.findElements(By.cssSelector(".product-grid > .item-grid > .item-box"));
    }

    public WebElement searchResultsPOM(String name){
        List<WebElement> results = ResultsPOM();

        for(int i=0;i<results.size();i++){
            if(results.get(i).getText().contains(name)) {
                return results.get(i);
            }
        }
        return  null;
    }

    public WebElement searchResultsPOM(int index){
        try {
            return ResultsPOM().get(index);
        } catch (Exception e){
            return null;
        }
    }

    public String getFirstVisibleProductPriceTag(){
        return driver.findElement(By.cssSelector(".product-grid > .item-grid > .item-box:nth-child(1) .prices > span")).getText();
    }

    public List<WebElement> popularTagsPOM(){
        return driver.findElements(By.cssSelector(".block-popular-tags > .listbox > .tags > ul > li"));
    }

    public WebElement searchPopularTagsPOM(String tagName){
        List<WebElement> tags = popularTagsPOM();

        for(int i=0;i<tags.size();i++){
            if(tags.get(i).getText().contains(tagName)) {
                return tags.get(i);
            }
        }
        return  null;
    }

    public WebElement searchPopularTagsPOM(int index){
        return popularTagsPOM().get(index);
    }

    public WebElement searchResultGetShoppingCartButtonPOM(int index){
        System.out.print(
                "FSAFASFAFS " +
                driver.findElement(By.cssSelector(".product-grid > .item-grid > .item-box:nth-child("+(index+1)+") .details > div.add-info > div.buttons > button:nth-child(1)"))
                + "   " +
                driver.findElement(By.cssSelector(".product-grid > .item-grid > .item-box:nth-child("+(index+1)+") .details > div.add-info > div.buttons > button:nth-child(1)")).getText()
        );
        return driver.findElement(By.cssSelector(".product-grid > .item-grid > .item-box:nth-child("+(index+1)+") .details > div.add-info > div.buttons > button:nth-child(1)"));
    }

    public WebElement searchResultGetCompareListButtonPOM(int index){
        return driver.findElement(By.cssSelector(".product-grid > .item-grid > .item-box:nth-child("+ (index+1) +") .details > div.add-info > div.buttons > button:nth-child(2)"));
    }

    public WebElement searchResultGetWishListButtonPOM(int index){
        return driver.findElement(By.cssSelector(".product-grid > .item-grid > .item-box:nth-child("+ (index+1) +") .details > div.add-info > div.buttons > button:nth-child(3)"));
    }
}