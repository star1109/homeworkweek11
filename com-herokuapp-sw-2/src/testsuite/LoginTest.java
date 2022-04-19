package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void open()
    {
        openBrowser(baseUrl);

    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedResult ="Secure Area";
        WebElement element = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        String actualResult = element.getText();
        Assert.assertEquals("Error occur",expectedResult,actualResult);
    }
    @Test
    public void verifyTheUsernameErrorMessage()
    {
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        ////div[contains(text(),'Your username is invalid!')]
        String expectedResult = "Your username is invalid!";
        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Your username is invalid!')]"));
        String actualResult = element.getText();
        String mainResult = actualResult.substring(0,25);
        //System.out.println(main);

        Assert.assertEquals("error occur",expectedResult,mainResult);
    }

    @Test
    public void verifyThePasswordErrorMessage()
    {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedResult = "Your password is invalid!";
        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Your password is invalid!')]"));
        String actualResult = element.getText();
        String mainResult = actualResult.substring(0,25);


        Assert.assertEquals("error occur",expectedResult,mainResult);
    }






    @After
    public void close()
    {
     closeBrowser();
    }
}
