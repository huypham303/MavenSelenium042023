package BT1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class addcategory {
    WebDriver webDriver;
    @BeforeMethod
    public void createDriver(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void closeDriver(){
        webDriver.quit();
    }

    public void login() throws InterruptedException {
        webDriver.get("https://cms.anhtester.com/login");

        WebElement inputLogin = webDriver.findElement(By.xpath("//input[@id='email']"));
        inputLogin.sendKeys("admin@example.com");

        WebElement inputPass = webDriver.findElement(By.xpath("//input[@id='password']"));
        inputPass.sendKeys("123456");

        WebElement loginButton = webDriver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();

        Thread.sleep(2000);
    }

    @Test
    public void addCategory() throws InterruptedException {
        login();

        WebElement products = webDriver.findElement(By.xpath("//span[normalize-space()='Products']"));
        products.click();

        WebElement categoryList = webDriver.findElement(By.xpath("//span[normalize-space()='Category']"));
        categoryList.click();

        Thread.sleep(2000);

        WebElement search = webDriver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("testH" + Keys.ENTER);

        Thread.sleep(2000);



        WebElement gettext = webDriver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        System.out.println("The Result is " + gettext.getText());
        Assert.assertEquals(gettext.getText(), "testH");
    }

}
