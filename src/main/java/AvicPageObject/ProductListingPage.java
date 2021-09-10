package AvicPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListingPage extends BasePage {

    private static final String COLOR_SEARCH = "//p[contains(text(),'Колір')]";
    private static final String COLOR_BUTTON = "//label[contains(@for,'fltr-cvet-sinij')]";
    private static final String SEARCH_RESULTS_PRODUCTS_LIST_COLOR = "//span[@class='config__color active ']";
    private static final String AVIC_CATALOG_URL = "https://avic.ua/ua/%s";
    private static final String SHOW_MORE_BUTTON = "//a[contains(@class,'js_show_more')]";
    private static final String ELEMENT_AMOUNT_CATALOG_PAGE = "//div[contains(@class,'item-prod')]";


    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnShowMoreButton() {
        driver.findElement(By.xpath(SHOW_MORE_BUTTON)).click();
    }

    public List<WebElement> getElementAmountCatalogPage() {
        return driver.findElements(By.xpath(ELEMENT_AMOUNT_CATALOG_PAGE));
    }

    public int getElementCatalogCount() {
        return getElementAmountCatalogPage().size();
    }

    public void openCatalogPage(String category) {
        driver.get(String.format(AVIC_CATALOG_URL, category));
    }

    public void clickOnProductColorSearchButton() {
        driver.findElement(By.xpath(COLOR_SEARCH)).click();
    }

    public void clickOnColorButton() {
        driver.findElement(By.xpath(COLOR_BUTTON)).click();
    }

    public List<WebElement> getSearchResultProductsListColor() {
        return driver.findElements(By.xpath(SEARCH_RESULTS_PRODUCTS_LIST_COLOR));
    }
}
