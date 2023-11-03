package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsCRM {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver;


        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        webDriver.get("https://crm.anhtester.com/admin/authentication");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //email
        //webDriver.findElement(By.id("email")).sendKeys("admin@example.com");
        webDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");

        //password
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //webDriver.findElement(By.id("password")).sendKeys("123456");
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");

        webDriver.findElement(By.xpath("//input[@id='remember']")).click();

        webDriver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(3000);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.quit();

    }
}
