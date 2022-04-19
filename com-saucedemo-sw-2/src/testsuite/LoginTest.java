package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void open() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String expectedResult = "PRODUCTS";
        WebElement element = driver.findElement(By.xpath("//span[@class = 'title']"));
        String actualResult = element.getText();

        Assert.assertEquals("error occurs", expectedResult, actualResult);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        int expectedResult = 6;
        List<WebElement> item = driver.findElements(By.className("inventory_item"));
        int list = item.size();

        Assert.assertEquals("error occured", expectedResult, list);


    }
    @After
    public void close() {
        closeBrowser();
    }
}
