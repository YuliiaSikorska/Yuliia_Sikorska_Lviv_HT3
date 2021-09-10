package avic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AvicSmokeTest {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp(){
        System.setProperty("webdriver.chrome.driver" , "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/ua");
    }

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord(){
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("Iphone 11");
        driver.findElement(By.xpath("//button[contains(@class,'button-reset search')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertTrue(driver.getCurrentUrl().contains("query=Iphone"));
    }

    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage(){
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("Iphone 11");
        driver.findElement(By.xpath("//button[contains(@class,'button-reset search')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='item-prod col-lg-3']"));
        assertEquals(elementList.size(), 12);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
