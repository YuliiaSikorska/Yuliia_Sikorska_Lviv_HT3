package avic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class AvicTest {
    private WebDriver driver;
    private String baseUrl = "https://avic.ua/ua";
    private String driverPath = "src/main/resources/chromedriver.exe";


    @BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void checkElementsContainsBlueColor() {
        driver.get("https://avic.ua/ua/naushniki");
        driver.findElement(By.xpath("//p[contains(text(),'Колір')]")).click();
        driver.findElement(By.xpath("//label[contains(@for,'fltr-cvet-sinij')]")).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//span[@class='config__color active ']"));
        for (WebElement webElement : elementList) {
            assertTrue(webElement.getAttribute("style").contains("rgb(0, 0, 255)"));
        }
    }

    @Test(priority = 1)
    public void checkCorrectErrorHandlingForMandatoryFieldsOnCheckoutPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://avic.ua/ua/naushniki-samsung-galaxy-buds2-lavender-sm-r177nlva-item");
        driver.findElement(By.xpath("//div[@class='about-prod__center']//a[@data-cart-add='show']")).click();
        driver.findElement(By.xpath("//a[@href='https://avic.ua/checkout']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement nameField = driver.findElement(By.xpath("//input[@data-bind='name']/../parent::div"));
        assertTrue(nameField.getAttribute("class").contains("error"));
    }

    @Test(priority = 2)
    public void checkEmptyBasket() {
        driver.findElement(By.xpath("//div[contains(@class,'header-bottom__cart')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='js_cart']")));
        WebElement emptyCardText = driver.findElement(By.xpath("//div[@id='js_cart']//b"));
        assertEquals(emptyCardText.getText(), "Кошик порожній!");
    }

    @Test
    public void checkElementAmountCatalogPage() {
        driver.get("https://avic.ua/ua/kofevarki");
        driver.findElement(By.xpath("//a[contains(@class,'js_show_more')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-paginator='2' and contains(@class,'active')]")));
        List<WebElement> productItems = driver.findElements(By.xpath("//div[contains(@class,'item-prod')]"));
        assertEquals(productItems.size(), 24);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
