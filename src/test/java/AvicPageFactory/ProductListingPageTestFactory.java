package AvicPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductListingPageTestFactory extends BaseTestFactory{
    private static final String ATTRIBUTE = "style";
    private static final String COLOR_NUMBER = "rgb(0, 0, 255)";
    private static final String AVIC_HEADPHONE_RELATIVE_URL = "naushniki";
    private static final String AVIC_KOFEVARKI_RELATIVE_URL = "kofevarki";

    @Test
    public void checkThatElementsContainsBlueColor() {
        getProductListingPageFactory().openCatalogPage(AVIC_HEADPHONE_RELATIVE_URL);
        getProductListingPageFactory().clickOnProductColorSearchButton();
        getProductListingPageFactory().implicitWait(20);
        getProductListingPageFactory().clickOnColorButton();
        for (WebElement webElement : getProductListingPageFactory().getSearchResultProductsListColor()) {
            assertTrue(webElement.getAttribute(ATTRIBUTE).contains(COLOR_NUMBER));
        }
    }

    @Test
    public void checkElementAmountCatalogPage() {
        getProductListingPageFactory().openCatalogPage(AVIC_KOFEVARKI_RELATIVE_URL);
        getProductListingPageFactory().clickOnShowMoreButton();
        getProductListingPageFactory().visibilityWait(20, getProductListingPageFactory().getActiveButton());
        assertEquals(getProductListingPageFactory().getElementCatalogCount(), 24);
    }

}
