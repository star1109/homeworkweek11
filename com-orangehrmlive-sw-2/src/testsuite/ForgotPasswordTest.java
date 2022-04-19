package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl= "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setup()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully()
    {

        driver.findElement(By.linkText("Forgot your password?")).click();
        String expectedResult = "Forgot Your Password?";
        WebElement element = driver.findElement(By.xpath("//div/div[2]/h1"));
        String actualResult = element.getText();

        Assert.assertEquals("Error occured",expectedResult,actualResult);
    }





    @After
    public void close()
    {
        closeBrowser();
    }

}
