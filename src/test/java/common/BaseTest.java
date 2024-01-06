package common;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class BaseTest {
    public WebDriver webDriver;

    //@BeforeMethod
    public void createBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(@Optional("chrome") String browserName) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        if (browserName.equals("chrome")) {
            webDriver = new ChromeDriver();
        }
        if (browserName.equals("edge")) {
            webDriver = new EdgeDriver();
        }
        if (browserName.equals("firefox")) {
            webDriver = new FirefoxDriver();
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    //Hàm Click
    public void clickElement(String locator) {
        webDriver.findElement(By.xpath(locator)).click();
    }

    //Hàm cho Sendkeys
    public void setText(String locator, String text) {
        webDriver.findElement(By.xpath(locator)).sendKeys(text);
    }


    @AfterMethod
    public void closeBrowser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriver.quit();
    }

    public void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
