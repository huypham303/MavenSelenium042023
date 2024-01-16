package seleniumMaven;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo extends BaseTest {

        @Test
        public void testIframe(){
            webDriver.get("https://vnexpress.net/");
            sleep(2);
            webDriver.findElement(By.id("google_ads_iframe_/27973503/Vnexpress/Desktop/Large1/Home_0")).click();
            //webDriver.switchTo().frame(webDriver.findElement(By.id("google_ads_iframe_/27973503/Vnexpress/Desktop/Large1/Home_0")));
            //sleep(1);
            //webDriver.findElement(By.xpath("(//div[contains(@id, 'genecy_ifr_')])")).click();
            sleep(2);
        }
}
