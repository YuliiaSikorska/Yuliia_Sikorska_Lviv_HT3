package AvicPageObject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BasketPageTest extends BaseTest{

    private static final String BASKET_POPUP = "//div[@id='js_cart']";
    private static final String BASKET_EMPTY = "Кошик порожній!";


    @Test
    public void checkEmptyBasket(){
        getBasketPage().openHomePage();
        getBasketPage().clickOnBasketButton();
        getBasketPage().visibilityWait(20, By.xpath(BASKET_POPUP));
        assertEquals(getBasketPage().getEmptyBasketText(), BASKET_EMPTY);
    }
}
