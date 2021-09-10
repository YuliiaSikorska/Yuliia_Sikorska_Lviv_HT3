package AvicPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class BaseTest {
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

    public ProductListingPage getProductListingPage(){
        return new ProductListingPage(getDriver());
    }

    public ProductDetailsPage getProductDetailsPage(){
        return new ProductDetailsPage(getDriver());
    }

    public BasketPage getBasketPage(){
        return new BasketPage(getDriver());
    }

    public CheckoutPage getCheckoutPage(){
        return new CheckoutPage(getDriver());
    }

}
