package AvicPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private static final String TO_BUY_BUTTON = "//div[@class='about-prod__center']//a[@data-cart-add='show']";
    private static final String CREATE_ORDER_BUTTON = "//a[@href='https://avic.ua/checkout']";
    private static final String AVIC_HEADPHONE_SAMSUNG_URL
            = "https://avic.ua/ua/naushniki-samsung-galaxy-buds2-lavender-sm-r177nlva-item";

    public ProductDetailsPage(WebDriver driver){
        super(driver);
    }

    public void openDetailsPage(){
        driver.get(AVIC_HEADPHONE_SAMSUNG_URL);
    }

    public void clickOnBuyButton(){
        driver.findElement(By.xpath(TO_BUY_BUTTON)).click();
    }
    public void clickOnCreateOrderButton(){
        driver.findElement(By.xpath(CREATE_ORDER_BUTTON)).click();
    }




}
