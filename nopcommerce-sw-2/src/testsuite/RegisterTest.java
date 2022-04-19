package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest
{
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp()
    {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully()
    {
        driver.findElement(By.xpath("//a[@class ='ico-register']")).click();
        String expectedResult = "Register";
        WebElement element = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualResult = element.getText();
        Assert.assertEquals("Invalid result",expectedResult,actualResult);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully()
    {
        driver.findElement(By.xpath("//a[@class ='ico-register']")).click();

        driver.findElement(By.xpath("//span[@class='female']")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Riya");
        driver.findElement(By.id("LastName")).sendKeys("Talati");
//        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).click();
//        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]/option[12]")).click();
        //==== both ways are working for selection of date
        Select DOB = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
       DOB.selectByVisibleText("11");

        Select month = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        month.selectByIndex(9);

        Select year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        year.selectByVisibleText("1998");

        driver.findElement(By.id("Email")).sendKeys("abcqp123@gmail.com");

        driver.findElement(By.id("Password")).sendKeys("12345678");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("12345678");
        driver.findElement(By.id("register-button")).click();

        String expectedResult = "Your registration completed";
        WebElement element = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
        String actualResult  =element.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);

    }
    @After
    public void close()
    {
         closeBrowser();
    }

}
