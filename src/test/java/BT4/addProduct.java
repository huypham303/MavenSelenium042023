package BT4;

import common.BaseTest;
import common.LocatorCMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class addProduct extends BaseTest {

    @Test(priority = 1, description = "Test Login ")
    public void loginSuccess() {
        //SoftAssert softAssert = new SoftAssert();

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
        Assert.assertTrue(logoAnhTester.isDisplayed(), "Not Dashboard Page");

        //softAssert.assertAll();
    }

    @Test
    public void addNewProduct(){
        loginSuccess();

        clickElement(LocatorCMS.sidebarProducts);
        clickElement(LocatorCMS.addNewProductSidebar);

        Assert.assertEquals(webDriver.findElement(By.xpath(LocatorCMS.addNewProductTitle)).getText(), "Product Information", "Not Found Add New Product Page!");

        // add new Product Information
        String newProductName = "TestProductName" + getRandomInt(1,100);
        setText(LocatorCMS.addNewProductName, newProductName);
        System.out.println("Product Name: " + newProductName);

        clickElement(LocatorCMS.categoryType);

        setText(LocatorCMS.categoryTypeSearch, "testH"
                + Keys.ARROW_DOWN
                + Keys.ARROW_DOWN
                + Keys.ENTER);

        String getCategoryTypeName = webDriver.findElement(By.xpath(LocatorCMS.categoryType)).getAttribute("title");
        System.out.println("Category: " + getCategoryTypeName);


        setText(LocatorCMS.unit, "KG");
        String getUnityName = webDriver.findElement(By.xpath(LocatorCMS.unit)).getAttribute("value");
        System.out.println("Unit: " + getUnityName);

        String getQuantityName = webDriver.findElement(By.xpath(LocatorCMS.quantity)).getAttribute("value");
        System.out.println("Quantity: " + getQuantityName);

        setText(LocatorCMS.categoryTag, "Tagname");

        sleep(4);

        //Product Images
        clickElement(LocatorCMS.thumbnailImages);
        String getTagName = webDriver.findElement(By.xpath(LocatorCMS.categoryTagName)).getText();
        System.out.println("Tags: " + getTagName);
        sleep(2);
        setText(LocatorCMS.seachImages, "cosy");
        sleep(2);
        clickElement(LocatorCMS.itemImages);
        clickElement(LocatorCMS.addFileImages);
        //String getgalleryImagesName = webDriver.findElement(By.xpath(LocatorCMS.thumbnailImages)).getText();
        //System.out.println("Thumbnail Images: " + getgalleryImagesName);

        sleep(4);

        //Product Variation color
        clickElement(LocatorCMS.activeColor);
        sleep(2);
        clickElement(LocatorCMS.colorList);
        setText(LocatorCMS.colorSearch, ""
                + Keys.ARROW_DOWN
                + Keys.ARROW_DOWN
                + Keys.ENTER
                + Keys.ARROW_DOWN
                + Keys.ARROW_DOWN
                + Keys.ARROW_DOWN
                + Keys.ENTER
                + Keys.ARROW_DOWN
                + Keys.ARROW_DOWN
                + Keys.ARROW_DOWN
                + Keys.ARROW_DOWN
                + Keys.ENTER); // 3 items selected
        //String getColorsName = webDriver.findElement(By.xpath(LocatorCMS.colorList)).getAttribute("title");
        //System.out.println("Colors: " + getColorsName);

        //Product price + stock
        clearText(LocatorCMS.unitPrice);
        setText(LocatorCMS.unitPrice, "10000");
        String getUnitPriceName = webDriver.findElement(By.xpath(LocatorCMS.unitPrice)).getAttribute("value");
        System.out.println("Unit Price: " + getUnitPriceName);

        clearText(LocatorCMS.discount);
        setText(LocatorCMS.discount, "5000");
        String getDiscountName = webDriver.findElement(By.xpath(LocatorCMS.discount)).getAttribute("value");
        System.out.println("Discount: " + getDiscountName);

        sleep(2);

        clickElement(LocatorCMS.saveAndPublishButton);



    }
}
