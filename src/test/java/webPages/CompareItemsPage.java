package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CompareItemsPage {

    WebDriver driver;

    public CompareItemsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public List<String> getAllAddedItemName(){;
        List<String> names = new ArrayList<>();
        List<WebElement> items = new ArrayList<>();
        items = driver.findElements(By.cssSelector("table.compare-products-table > tbody tr.product-name > td a"));

        for(WebElement item: items){
            names.add(item.getText());
        }
        return names;
    }

    public boolean searchIfItemIsCompared(String checkName){

        List<String> itemNames = getAllAddedItemName();
        for(String itemName : itemNames){
            if(itemName.toLowerCase().trim().contains(checkName.toLowerCase().trim())){
                return true;
            }
        }

        return false;
    }
}
