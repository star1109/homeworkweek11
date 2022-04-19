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
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp()
    {
        openBrowser(baseUrl); //super class method to open the broswer

    }


    @Test
public void userShouldNavigateToLoginPageSuccessfully()
    {
        driver.findElement(By.linkText("Log in")).click();

        String expectedResult = "Welcome, Please Sign In!";
        WebElement actualResultElemt = driver.findElement(By.className("page-title"));
        String actualResult = actualResultElemt.getText();
        Assert.assertEquals("invalid",expectedResult,actualResult);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
        driver.findElement(By.className("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        String expectedResult = "Log out";
        WebElement element = driver.findElement(By.linkText("Log out"));
        String actualResult = element.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);


    }

    @Test
    public void verifyTheErrorMessage()
    {
        driver.findElement(By.linkText("Log in")).click();

        driver.findElement(By.id("Email")).sendKeys("riya@gmail.com");
        driver.findElement(By.className("password")).sendKeys("12345");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        WebElement actualelemt = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]"));
        String actualResult = actualelemt.getText();

        Assert.assertEquals("invalid",expectedResult,actualResult);
    }

    @After
    public void close()
    {
       closeBrowser();
    }










}


