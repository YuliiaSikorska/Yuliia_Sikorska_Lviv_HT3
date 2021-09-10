package AvicPageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPageFactory extends BasePageFactory {

    private static final String AVIC_MAIN_URL = "https://avic.ua/ua";

    @FindBy(xpath = "//div[@id='js_cart']")
    private WebElement basketPopup;

    @FindBy(xpath = "//div[contains(@class,'header-bottom__cart')]")
    private WebElement basketButton;

    @FindBy(xpath = "//div[@id='js_cart']//b")
    private WebElement basketActuallyText;

    public WebElement getBasketPopup(){
        return basketPopup;
    }

    public BasketPageFactory(WebDriver driver){
        super(driver);
    }

    public void openHomePage(){
        driver.get(AVIC_MAIN_URL);
    }

    public void clickOnBasketButton(){
        basketButton.click();
    }

    public String getEmptyBasketText() {
        return basketActuallyText.getText();
    }
}

