package AvicPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasketPage{
    private static final String SUBMIT_ORDER_BUTTON = "//button[@type='submit']";
    private static final String FIELD_NAME = "//input[@data-bind='name']/../parent::div";
    private static final String ATTRIBUTE = "class";


    public CheckoutPage (WebDriver driver){
        super(driver);
    }

    public void clickOnSubmitOrderButton(){
        driver.findElement(By.xpath(SUBMIT_ORDER_BUTTON)).click();
    }

    public String getErrorMassage(){
        return driver.findElement(By.xpath(FIELD_NAME)).getAttribute(ATTRIBUTE);
    }


}
