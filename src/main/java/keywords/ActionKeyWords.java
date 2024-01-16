package keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class ActionKeyWords {
    private static int EXPLICIT_WAIT_TIMEOUT = 10;
    private static int WAIT_PAGE_LEADED_TIMEOUT = 20;

    //khoi tao driver:
    private static WebDriver driver;

    //get Element By custom:
    public static WebElement getWebElement(By by){
        return driver.findElement(by);
    }
    public ActionKeyWords(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Wait for Page loaded
     * Chờ đợi trang tải xong (Javascript tải xong)
     */
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_PAGE_LEADED_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                //Assert.fail ("FAILED. Timeout waiting for page load.");
            }
        }
    }

    //get current url:
    public static String getCurrentUrl() {
        waitForPageLoaded();
        System.out.println("Current url: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    //Hàm Click
    public static void clickElement(By by) {
        waitForPageLoaded();
        System.out.println("Click on " + by);
        getWebElement(by).click();
    }

    //Hàm cho Sendkeys
    public static void setText(By by, String text) {
        waitForPageLoaded();
        System.out.println("Send keys: " + text + " into element: " + by);
        getWebElement(by).sendKeys(text);
    }

    //Clear Text
    public static void clearText(By by) {
        waitForPageLoaded();
        System.out.println("Clear text in element: " + by);
        getWebElement(by).clear();
    }

    public static String getText(By by){
        waitForPageLoaded();
        System.out.println("Get text from element: " + by + " is: " + getWebElement(by).getText());
        return getWebElement(by).getText();
    }
    // Get random number
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;  // Ensures inclusivity of both min and max
    }

    public static boolean verifyElementVisible(By by, int seconds){
        try{
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch(TimeoutException e){
            e.printStackTrace();
            return false;
        }
    }
}
