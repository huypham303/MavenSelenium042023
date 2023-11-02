package seleniumMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Demo {
    public static void main(String[] args) {
        WebDriver webDriver;

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        webDriver.get("https://anhtester.com");

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.findElement(By.xpath("//a[@id='btn-login']")).click();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.quit();
    }
}
