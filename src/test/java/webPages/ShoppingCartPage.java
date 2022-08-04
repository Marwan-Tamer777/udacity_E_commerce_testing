package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/*
    Testing using Assertion using Testng,selenium  with Cucumber as testing framework.
 */
public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLastAddedItemName(){
        return driver.findElement(By.cssSelector("table.cart tbody tr:last-child td.product > a")).getText();
    }

}
