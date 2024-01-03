package LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
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

    @Test (priority = 1)
    public void testSeleniumeasy() throws InterruptedException {
        webDriver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        webDriver.findElement(By.xpath("//li[@class='tree-branch']//a[@href='#'][normalize-space()='Input Forms']")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 3)
    public void testSeleniumeasy_Click() throws InterruptedException {
        webDriver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        webDriver.findElement(By.xpath("//li[@class='tree-branch']//a[@href='#'][normalize-space()='Input Forms']")).click();
        webDriver.findElement(By.xpath("//li[@class='tree-branch']//ul//li//a[normalize-space()='Simple Form Demo']")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    public void testSeleniumeasy_Click2() throws InterruptedException {
        webDriver.get("https://www.google.com.vn/?hl=vi");
        //webDriver.findElement(By.xpath("//li[@class='tree-branch']//ul//li//a[normalize-space()='Simple Form Demo']")).click();
        Thread.sleep(2000);
    }
}
