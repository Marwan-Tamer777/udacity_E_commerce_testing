package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillingPage {
    WebDriver driver;

    @FindBy(id="billing-address-select")
    WebElement selectPreviousAddress;
    @FindBy(id="BillingNewAddress_CountryId")
    WebElement countrySelectionDropDown;
    @FindBy(id="BillingNewAddress_City")
    WebElement cityIn;
    @FindBy(id="BillingNewAddress_Address1")
    WebElement address1In;
    @FindBy(id="BillingNewAddress_ZipPostalCode")
    WebElement zipCodeIn;
    @FindBy(id="BillingNewAddress_PhoneNumber")
    WebElement phoneNumberIn;

    @FindBy(css="#billing-buttons-container > button.new-address-next-step-button")
    WebElement step1ContinueButton;

    @FindBy(css="#shipping-method-buttons-container > button")
    WebElement step3ContinueButton;

    @FindBy(css="#payment-method-buttons-container > button")
    WebElement step4ContinueButton;

    @FindBy(css="#payment-info-buttons-container > button")
    WebElement step5ContinueButton;
    @FindBy(css="#confirm-order-buttons-container > button")
    WebElement step6ContinueButton;

    @FindBy(css="div.checkout-data .details > .order-number > strong")
    WebElement orderSuccessNumber;

    @FindBy(css="div.checkout-data .details .details-link > a")
    WebElement orderDetailsLink;

    @FindBy(css=".order-overview > .order-number > strong")
    WebElement orderDetailsOrderNumber;

    public BillingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement selectPreviousAddressPOM(){
        return selectPreviousAddress;
    }
    public Select countrySelectionPOM(){
        return new Select(countrySelectionDropDown);
    }

    public WebElement cityInPOM(){
        return cityIn;
    }

    public WebElement addressInPOM(){
        return address1In;
    }

    public WebElement zipCodeInPOM(){
        return zipCodeIn;
    }

    public WebElement phoneNumberInPOM(){
        return phoneNumberIn;
    }
    public WebElement step1ContinueButtonPOM(){
        return step1ContinueButton;
    }

    public WebElement step3ContinueButtonPOM(){
        return step3ContinueButton;
    }

    public WebElement step4ContinueButtonPOM(){
        return step4ContinueButton;
    }

    public WebElement step5ContinueButtonPOM(){
        return step5ContinueButton;
    }

    public WebElement step6ContinueButtonPOM(){
        return step6ContinueButton;
    }

    public String getOrderNumber(){
        String on = orderSuccessNumber.getText();
        return on.substring(on.length()-4,on.length());
    }

    public WebElement orderDetailsLinkPOM(){
        return orderDetailsLink;
    }

    public String getOrderDetailsPageOrderNumber(){
        String odpon = orderDetailsOrderNumber.getText();
        return odpon.substring(odpon.length()-4,odpon.length());
    }
}
