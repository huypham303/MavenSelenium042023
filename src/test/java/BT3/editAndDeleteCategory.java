package BT3;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class editAndDeleteCategory extends BaseTest {

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

        Thread.sleep(2000);
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void editCategory() throws InterruptedException {
        searchCategory();

        SoftAssert softAssert = new SoftAssert();

        WebElement editButton = webDriver.findElement(By.xpath("(//i[@class='las la-edit'])[1]"));
        editButton.click();
        sleep(2);

        WebElement editpage = webDriver.findElement(By.xpath("//h5[normalize-space()='Category Information']"));
        softAssert.assertEquals(editpage.getText(), "Category Information");

        WebElement editName = webDriver.findElement(By.xpath("//input[@id='name']"));
        editName.clear();
        editName.sendKeys("testH" + getRandomInt(1,100));

        WebElement saveEditButton = webDriver.findElement(By.xpath("//button[normalize-space()='Save']"));
        saveEditButton.click();

        Thread.sleep(2000);
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void deleteCategory() throws InterruptedException {
        searchCategory();
        SoftAssert softAssert = new SoftAssert();

        WebElement deleteButton = webDriver.findElement(By.xpath("(//i[@class='las la-trash'])[1]"));
        deleteButton.click();

        WebElement deleteConfirmButton = webDriver.findElement(By.xpath("//a[@id='delete-link']"));
        deleteConfirmButton.click();

        Thread.sleep(2000);
        softAssert.assertAll();
    }




    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;  // Ensures inclusivity of both min and max
    }
}
