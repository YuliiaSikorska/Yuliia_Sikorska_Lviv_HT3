package AvicPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductDetailsPageTest extends BaseTest{

    private static final String EXPECTED_ERROR = "error";

    @Test
    public void checkCorrectErrorHandlingForMandatoryFieldsOnCheckoutPage() {
        getProductDetailsPage().implicitWait(20);
        getProductDetailsPage().openDetailsPage();
        getProductDetailsPage().clickOnBuyButton();
        getProductDetailsPage().clickOnCreateOrderButton();
        getCheckoutPage().clickOnSubmitOrderButton();
        assertTrue(getCheckoutPage().getErrorMassage().contains(EXPECTED_ERROR));
    }
}
