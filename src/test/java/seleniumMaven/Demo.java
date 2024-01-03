package seleniumMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver;

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//        webDriver.get("https://anhtester.com");
        webDriver.get("https://brightlab.web.app");

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        webDriver.findElement(By.xpath("//a[@id='btn-login']")).click();

        webDriver.findElement(By.xpath("//a[@class='btn btn-sm btn-danger px-4']")).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("saothenhoc1");

        webDriver.findElement(By.xpath("//input[@id='inputPassword5']")).sendKeys("Taotenlahuy@123");

        webDriver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();


        Thread.sleep(10000);
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.quit();
    }
}
