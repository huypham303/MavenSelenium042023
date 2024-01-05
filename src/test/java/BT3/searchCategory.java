package BT3;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class searchCategory extends BaseTest{

    @Test(priority = 1)
    public void loginSuccess() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        webDriver.get("https://cms.anhtester.com/login");

        WebElement inputLogin = webDriver.findElement(By.xpath("//input[@id='email']"));
        inputLogin.sendKeys("admin@example.com");

        WebElement inputPass = webDriver.findElement(By.xpath("//input[@id='password']"));
        inputPass.sendKeys("123456");

        WebElement loginButton = webDriver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();

        Thread.sleep(2000);

        WebElement accAdmin = webDriver.findElement(By.xpath("//span[@class='d-block fw-500']"));
        softAssert.assertEquals(accAdmin.getText(), "Admin Example");

        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Test")
    public void searchCategory() throws InterruptedException {

        loginSuccess();

        SoftAssert softAssert = new SoftAssert();
        WebElement products = webDriver.findElement(By.xpath("//span[normalize-space()='Products']"));
        products.click();

        WebElement category = webDriver.findElement(By.xpath("//span[normalize-space()='Category']"));
        category.click();
        WebElement categoryList = webDriver.findElement(By.xpath("//h5[normalize-space()='Categories']"));
        softAssert.assertEquals(categoryList.getText(), "Categories");

        Thread.sleep(2000);

        WebElement search = webDriver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("testH" + Keys.ENTER);

        Thread.sleep(2000);



        WebElement gettext = webDriver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        System.out.println("The Result is " + gettext.getText());
        softAssert.assertEquals(gettext.getText(), "testH");

        softAssert.assertAll();
    }
}
