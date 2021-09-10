package AvicPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTestFactory {
    private WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public ProductListingPageFactory getProductListingPageFactory(){
        return new ProductListingPageFactory(getDriver());
    }

    public ProductDetailsPageFactory getProductDetailsPageFactory(){
        return new ProductDetailsPageFactory(getDriver());
    }

    public BasketPageFactory getBasketPageFactory(){
        return new BasketPageFactory(getDriver());
    }

    public CheckoutPageFactory getCheckoutPageFactory(){
        return new CheckoutPageFactory(getDriver());
    }
}
