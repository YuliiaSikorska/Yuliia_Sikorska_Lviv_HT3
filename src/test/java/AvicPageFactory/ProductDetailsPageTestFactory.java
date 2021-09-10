package AvicPageFactory;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductDetailsPageTestFactory extends BaseTestFactory{
    private static final String EXPECTED_ERROR = "error";

    @Test
    public void checkCorrectErrorHandlingForMandatoryFieldsOnCheckoutPage() {
        getProductDetailsPageFactory().implicitWait(20);
        getProductDetailsPageFactory().openDetailsPage();
        getProductDetailsPageFactory().clickOnBuyButton();
        getProductDetailsPageFactory().clickOnCreateOrderButton();
        getCheckoutPageFactory().clickOnSubmitOrderButton();
        assertTrue(getCheckoutPageFactory().getErrorMassage().contains(EXPECTED_ERROR));
    }
}
