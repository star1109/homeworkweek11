package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setup()
    {
        openBrowser(baseUrl);
    }



    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials()
    {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        String expectedResult = "Welcome";
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]"));
        String actualResult = element.getText();
        String mainResult = actualResult.substring(0,7);

        Assert.assertEquals("invalid",expectedResult,mainResult);



    }



    @After
    public void close()
    {
       closeBrowser();
    }




}
