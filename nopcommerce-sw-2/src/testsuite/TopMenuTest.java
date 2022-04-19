package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        driver.findElement(By.linkText("Computers")).click();
        String expectedResult = "Computers";
        WebElement actualResultElement = driver.findElement(By.className("page-title"));
        String actualResult = actualResultElement.getText();
        Assert.assertEquals("invalid element", expectedResult, actualResult);
    }


    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully()
    {
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]")).click();

        String expectedResult = "Electronics";
        WebElement actualElement = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1"));
        String actualResult = actualElement.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);
    }

    @Test

    public void userShouldNavigateToApparelPageSuccessfully()
    {
        driver.findElement(By.linkText("Apparel")).click();

        String expectedResult = "Apparel";
        WebElement actualElement = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1"));
        String actualResult = actualElement.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully()
    {
        driver.findElement(By.linkText("Digital downloads")).click();

        String expectedResult = "Digital downloads";
        WebElement actualElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[4]/a"));
        String actualResult = actualElement.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);
    }
    @Test
 public void userShouldNavigateToBooksPageSuccessfully()
    {
        driver.findElement(By.linkText("Books")).click();

        String expectedResult = "Books";
        WebElement actualElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a"));
        String actualResult = actualElement.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);
    }
    @Test
 public void Jewelry()
    {
        driver.findElement(By.linkText("Jewelry")).click();

        String expectedResult = "Jewelry";
        WebElement actualElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a"));
        String actualResult = actualElement.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);
    }
    @Test
 public void GiftCards()
    {
        driver.findElement(By.linkText("Gift Cards")).click();

        String expectedResult = "Gift Cards";
        WebElement actualElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[7]/a"));
        String actualResult = actualElement.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);
    }


    @After
    public void close() {
           closeBrowser();
    }
}
