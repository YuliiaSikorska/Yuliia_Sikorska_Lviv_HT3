package AvicPageFactory;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BasketPageTestFactory extends BaseTestFactory {

    private static final String BASKET_EMPTY = "Кошик порожній!";

    @Test
    public void checkEmptyBasket(){
        getBasketPageFactory().openHomePage();
        getBasketPageFactory().clickOnBasketButton();
        getBasketPageFactory().visibilityWait(20, getBasketPageFactory().getBasketPopup());
        assertEquals(getBasketPageFactory().getEmptyBasketText(), BASKET_EMPTY);
    }
}
