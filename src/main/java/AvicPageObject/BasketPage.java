package AvicPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {

    private static final String AVIC_MAIN_URL = "https://avic.ua/ua";
    private static final String BASKET_BUTTON = "//div[contains(@class,'header-bottom__cart')]";
    private static final String BASKET_ACTUALLY_TEXT = "//div[@id='js_cart']//b";

    public BasketPage(WebDriver driver){
        super(driver);
    }

    public void openHomePage(){
        driver.get(AVIC_MAIN_URL);
    }

    public void clickOnBasketButton(){
        driver.findElement(By.xpath(BASKET_BUTTON)).click();
    }

    public String getEmptyBasketText() {
       return driver.findElement(By.xpath(BASKET_ACTUALLY_TEXT)).getText();
    }
}
