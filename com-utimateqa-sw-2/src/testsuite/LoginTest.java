package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

    public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void open() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully()
    {

        driver.findElement(By.linkText("Sign In")).click();
        String expectedResult = "Welcome Back!";
       WebElement element =  driver.findElement(By.cssSelector("h1.page__heading"));
       String actualResult = element.getText();

        Assert.assertEquals("error occured",expectedResult,actualResult);

    }

    @Test
    public void verifyTheErrorMessage()
    {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("user[email]")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("123456");
        driver.findElement(By.cssSelector("input.button.button-primary.g-recaptcha")).click();

        String expectedresult = "Invalid email or password.";
        WebElement element  = driver.findElement(By.xpath("//li[text() ='Invalid email or password.' ]"));

        String actualResult = element.getText();
        Assert.assertEquals("Error occured",expectedresult,actualResult);

    }


    @After
    public void close() {
       closeBrowser();
    }


}
