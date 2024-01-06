package BT1_2_3;

import common.BaseTest;
import common.LocatorCMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;


public class addCategory extends BaseTest{
    SoftAssert softAssert = new SoftAssert();
    @Test(priority = 1, description = "Test Login ")
    public void loginSuccess() throws InterruptedException {


        webDriver.get("https://cms.anhtester.com/login");


        //Login Page
        WebElement welcomeloginPageText = webDriver.findElement(By.xpath(LocatorCMS.welcomeLoginText));
        System.out.println("Titile: " + welcomeloginPageText.getText());
        Assert.assertTrue(welcomeloginPageText.isDisplayed(), "Not Found the title yet! Try again");

        // input Email and Password
        setText(LocatorCMS.inputEmail, "admin@example.com");
        setText(LocatorCMS.inputPassword, "123456");

        clickElement(LocatorCMS.loginButton);

        //Dashboard page
        WebElement logoAnhTester = webDriver.findElement(By.xpath(LocatorCMS.logoAnhTester));
        Assert.assertTrue(logoAnhTester.isDisplayed(), "Login Success");

        //softAssert.assertAll();
    }

    @Test(priority = 2, description = "Test add Category")
    public void addCategory() throws InterruptedException {
        loginSuccess();

        clickElement(LocatorCMS.sidebarProducts);
        clickElement(LocatorCMS.categoryList);
        clickElement(LocatorCMS.addNewCategoryButton);

        // add new category information
        setText(LocatorCMS.nameTxtCategory, "testH" + getRandomInt(1,100));
        String newCategoryname = webDriver.findElement(By.xpath(LocatorCMS.nameTxtCategory)).getAttribute("value");
        System.out.println("The New Category is " + newCategoryname);

        clickElement(LocatorCMS.saveButtonCategory);

        //search the new category name
        setText(LocatorCMS.searchCategory , newCategoryname);

        sleep(2);

        WebElement getNewCategoryname = webDriver.findElement(By.xpath(LocatorCMS.getNameCategory));
        getNewCategoryname.getText();
        Assert.assertTrue(webDriver.findElement(By.xpath(LocatorCMS.getNameCategory)).isDisplayed(),
                "Not Found The New Category");
        System.out.println("search category name after add" + getNewCategoryname);

        //softAssert.assertAll();
    }

    @Test(priority = 3, description = "Test edit Category")
    public void editCategory() throws InterruptedException {
        loginSuccess();

        clickElement(LocatorCMS.sidebarProducts);
        clickElement(LocatorCMS.categoryList);

        // update new category name
        setText(LocatorCMS.searchCategory, "TestH" + Keys.ENTER);
        sleep(2);
        clickElement(LocatorCMS.editCategoryButton);
        WebElement updatedCategoryName = webDriver.findElement(By.xpath(LocatorCMS.nameTxtCategory));
        updatedCategoryName.clear();

        setText(LocatorCMS.nameTxtCategory, "testH" + getRandomInt(1,100));
        WebElement updatedCategoryNameString = webDriver.findElement(By.xpath(LocatorCMS.nameTxtCategory));
        String updateName = updatedCategoryNameString.getText();
        System.out.println("Update the category name: " + updatedCategoryNameString);

        Assert.assertTrue(updatedCategoryName.isDisplayed(), "Not Found the category name! try Again");

        clickElement(LocatorCMS.saveButtonCategory);
        clickElement(LocatorCMS.categoryList);

        //search the updated category name
        setText(LocatorCMS.searchCategory , updateName);

        sleep(2);

        WebElement getNewCategoryname = webDriver.findElement(By.xpath(LocatorCMS.getNameCategory));
        getNewCategoryname.getText();
        Assert.assertTrue(getNewCategoryname.isDisplayed(),
                "Not Found The New Category");
        System.out.println("search category name after edit" + getNewCategoryname);

        //softAssert.assertAll();
    }

    @Test(priority = 4, description = "Test delete Category")
    public void deleteCategory() throws InterruptedException {
        loginSuccess();

        clickElement(LocatorCMS.sidebarProducts);
        clickElement(LocatorCMS.categoryList);

        setText(LocatorCMS.searchCategory,  "TestH" + Keys.ENTER);

        sleep(2);

        WebElement getNameCategory = webDriver.findElement(By.xpath(LocatorCMS.getNameCategory));
        String nameCategory = getNameCategory.getText();
        System.out.println("The category want to delete is " + getNameCategory.getText());

        clickElement(LocatorCMS.deleteCategoryButtonOut);

        //Delete Popup
        WebElement deletePopupTitle = webDriver.findElement(By.xpath(LocatorCMS.deleteCategoryPopupTitle));

        sleep(2);

        Assert.assertEquals(deletePopupTitle.getText(), "Delete Confirmation", "Not Found Delete Popup");

        clickElement(LocatorCMS.deleteCategoryButtonIn);

        // search the category name after delete
        setText(LocatorCMS.searchCategory,  nameCategory + Keys.ENTER);

        sleep(2);

        WebElement nothingFoundCategoryMess = webDriver.findElement(By.xpath(LocatorCMS.nothingFoundCategoryMess));
        nothingFoundCategoryMess.getText();
        Assert.assertTrue(nothingFoundCategoryMess.isDisplayed(), "Delete Fail");

        //softAssert.assertAll();
    }


    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;  // Ensures inclusivity of both min and max
    }
}
