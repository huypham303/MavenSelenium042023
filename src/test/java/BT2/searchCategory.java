package BT2;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class searchCategory extends BaseTest{

    @Test
    public void loginSuccess() throws InterruptedException {
        webDriver.get("https://cms.anhtester.com/login");

        WebElement inputLogin = webDriver.findElement(By.xpath("//input[@id='email']"));
        inputLogin.sendKeys("admin@example.com");

        WebElement inputPass = webDriver.findElement(By.xpath("//input[@id='password']"));
        inputPass.sendKeys("123456");

        WebElement loginButton = webDriver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();

        Thread.sleep(2000);
    }

    @Test(description = "Test")
    public void addCategory() throws InterruptedException {
        loginSuccess();

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

    }

}
