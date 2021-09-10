package AvicPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ProductListingPageTest extends BaseTest {

    private static final String ATTRIBUTE = "style";
    private static final String COLOR_NUMBER = "rgb(0, 0, 255)";
    private static final String ACTIVE_BUTTON = "//li[@data-paginator='2' and contains(@class,'active')]";
    private static final String AVIC_HEADPHONE_RELATIVE_URL = "naushniki";
    private static final String AVIC_KOFEVARKI_RELATIVE_URL = "kofevarki";

    @Test
    public void checkThatElementsContainsBlueColor() {
        getProductListingPage().openCatalogPage(AVIC_HEADPHONE_RELATIVE_URL);
        getProductListingPage().clickOnProductColorSearchButton();
        getProductListingPage().implicitWait(20);
        getProductListingPage().clickOnColorButton();
        for (WebElement webElement : getProductListingPage().getSearchResultProductsListColor()) {
            assertTrue(webElement.getAttribute(ATTRIBUTE).contains(COLOR_NUMBER));
        }
    }

    @Test
    public void checkElementAmountCatalogPage() {
        getProductListingPage().openCatalogPage(AVIC_KOFEVARKI_RELATIVE_URL);
        getProductListingPage().clickOnShowMoreButton();
        getProductListingPage().visibilityWait(20, By.xpath(ACTIVE_BUTTON));
        assertEquals(getProductListingPage().getElementCatalogCount(), 24);
    }
}
