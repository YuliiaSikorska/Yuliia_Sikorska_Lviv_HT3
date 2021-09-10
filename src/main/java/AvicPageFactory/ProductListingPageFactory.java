package AvicPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListingPageFactory extends BasePageFactory {

    @FindBy(xpath = "//li[@data-paginator='2' and contains(@class,'active')]")
    private WebElement activeButton;

    @FindBy(xpath = "//p[contains(text(),'Колір')]")
    private WebElement colorSearch;

    @FindBy(xpath = "//label[contains(@for,'fltr-cvet-sinij')]")
    private WebElement colorButton;

    @FindBy(xpath = "//span[@class='config__color active ']")
    private List<WebElement> searchResultsProductsListColor;

    @FindBy(xpath = "//a[contains(@class,'js_show_more')]")
    private WebElement showMoreButton;

    @FindBy(xpath = "//div[contains(@class,'item-prod')]")
    private List<WebElement> elementAmountCatalogPage;

    private static final String AVIC_CATALOG_URL = "https://avic.ua/ua/%s";

    public WebElement getActiveButton(){
        return activeButton;
    }

    public ProductListingPageFactory(WebDriver driver) {
        super(driver);
    }

    public void clickOnShowMoreButton() {
        showMoreButton.click();
    }

    public List<WebElement> getElementAmountCatalogPage() {
        return elementAmountCatalogPage;
    }

    public int getElementCatalogCount() {
        return getElementAmountCatalogPage().size();
    }

    public void openCatalogPage(String category) {
        driver.get(String.format(AVIC_CATALOG_URL, category));
    }

    public void clickOnProductColorSearchButton() {
        colorSearch.click();
    }

    public void clickOnColorButton() {
        colorButton.click();
    }

    public List<WebElement> getSearchResultProductsListColor() {
        return searchResultsProductsListColor;
    }
}
