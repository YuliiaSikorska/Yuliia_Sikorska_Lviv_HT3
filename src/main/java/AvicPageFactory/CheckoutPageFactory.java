package AvicPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageFactory extends BasePageFactory {

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitOrderButton;

    @FindBy(xpath = "//input[@data-bind='name']/../parent::div")
    private WebElement fieldName;

    private static final String ATTRIBUTE = "class";

    public CheckoutPageFactory(WebDriver driver){
        super(driver);
    }

    public void clickOnSubmitOrderButton(){
        submitOrderButton.click();
    }

    public String getErrorMassage(){
        return fieldName.getAttribute(ATTRIBUTE);
    }
}
