package AvicPageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPageFactory extends BasePageFactory {

    private static final String AVIC_HEADPHONE_SAMSUNG_URL
            = "https://avic.ua/ua/naushniki-samsung-galaxy-buds2-lavender-sm-r177nlva-item";

    @FindBy(xpath = "//div[@class='about-prod__center']//a[@data-cart-add='show']")
    private WebElement toBuyButton;

    @FindBy(xpath = "//a[@href='https://avic.ua/checkout']")
    private WebElement createOrderButton;

    public ProductDetailsPageFactory(WebDriver driver){
        super(driver);
    }

    public void openDetailsPage(){
        driver.get(AVIC_HEADPHONE_SAMSUNG_URL);
    }

    public void clickOnBuyButton(){
        toBuyButton.click();
    }
    public void clickOnCreateOrderButton(){
        createOrderButton.click();
    }

}
