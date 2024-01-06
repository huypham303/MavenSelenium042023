package BT1_2_3;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
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
    public void addAndSearchCategory() throws InterruptedException {

        loginSuccess();

        SoftAssert softAssert = new SoftAssert();
        WebElement products = webDriver.findElement(By.xpath("//span[normalize-space()='Products']"));
        products.click();

        WebElement category = webDriver.findElement(By.xpath("//span[normalize-space()='Category']"));
        category.click();
        WebElement categoryList = webDriver.findElement(By.xpath("//h5[normalize-space()='Categories']"));
        softAssert.assertEquals(categoryList.getText(), "Categories");


        WebElement addCategoryButton = webDriver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        addCategoryButton.click();

        Thread.sleep(2000);

        WebElement addName = webDriver.findElement(By.xpath("//input[@id='name']"));
        addName.sendKeys("testH" + getRandomInt(1,100));
        System.out.println("New Category Name is " + addName.getAttribute("value"));


        WebElement saveNewCategoryButton = webDriver.findElement(By.xpath("//button[normalize-space()='Save']"));
        saveNewCategoryButton.click();

        Thread.sleep(2000);

        WebElement search = webDriver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("testH" + Keys.ENTER);

        Thread.sleep(2000);



        WebElement gettext = webDriver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        System.out.println("The First Name is " + gettext.getText());

        Thread.sleep(2000);
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void editCategory() throws InterruptedException {
        addAndSearchCategory();

        SoftAssert softAssert = new SoftAssert();

        WebElement editButton = webDriver.findElement(By.xpath("(//i[@class='las la-edit'])[1]"));
        editButton.click();
        sleep(2);

        WebElement editpage = webDriver.findElement(By.xpath("//h5[normalize-space()='Category Information']"));
        softAssert.assertEquals(editpage.getText(), "Category Information");

        WebElement editName = webDriver.findElement(By.xpath("//input[@id='name']"));
        editName.clear();
        editName.sendKeys("testH" + getRandomInt(1,100));
        String editedname = editName.getAttribute("value");
        System.out.println("Edited name: " + editedname);

        WebElement saveEditButton = webDriver.findElement(By.xpath("//button[normalize-space()='Save']"));
        saveEditButton.click();

        // sau khi edit thi quay lai search xem con ko
        WebElement category = webDriver.findElement(By.xpath("//span[normalize-space()='Category']"));
        category.click();

        WebElement search = webDriver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys(editedname + Keys.ENTER);

        int timeoutInSeconds = 10;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(webDriver, timeout);
        WebElement nothing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='Nothing found']")));
        System.out.println(nothing.getText());
        softAssert.assertEquals(nothing.getText(), "Nothing found");

        Thread.sleep(2000);
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void deleteCategory() throws InterruptedException {
        addAndSearchCategory();
        SoftAssert softAssert = new SoftAssert();

        WebElement deleteButton = webDriver.findElement(By.xpath("(//i[@class='las la-trash'])[1]"));
        deleteButton.click();

        int timeoutInSeconds = 10;
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(webDriver, timeout);
        WebElement deleteMess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Delete Confirmation']")));
        System.out.println("Delete Mess: " + deleteMess.getText());
        softAssert.assertEquals(deleteMess.getText(), "Delete Confirmation");

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
