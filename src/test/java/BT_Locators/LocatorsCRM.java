package BT_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsCRM {
    // Login Screen https://crm.anhtester.com/
    String email = "//input[@id='email']";
    String password = "//input[@id='password']";
    String RememberMe = "//input[@id='remember']";
    String Login = "//button[normalize-space()='Login']";
    String ForgotPassword = "//a[normalize-space()='Forgot Password?']";

    // menu Customer screen
    String newCustomer="//a[normalize-space()='New Customer']";
    String importCustomer="//a[normalize-space()='Import Customers']";
    String Contacts="//a[@class='btn btn-default pull-left display-block mright5']";

    //New Customer screen
    String company="//input[@id='company']";
    String vatNumber="//input[@id='vat']";
    String phone="//input[@id='phonenumber']";
    String website="//input[@id='website']";
    String group="//div[@class='dropdown bootstrap-select show-tick input-group-btn _select_input_group bs3']//div[@class='filter-option-inner-inner'][normalize-space()='Nothing selected']";
    String currency="//button[@class='btn dropdown-toggle btn-default bs-placeholder']//div[@class='filter-option-inner-inner'][normalize-space()='System Default']";
    String defaultLanguage="//button[@class='btn dropdown-toggle btn-default']//div[@class='filter-option-inner-inner'][normalize-space()='System Default']";
    String address="//textarea[@id='address']";
    String city="//input[@id='city']";
    String state="//input[@id='state']";
    String zipcode="//input[@id='zip']";
    String country="//div[@class='dropdown bootstrap-select bs3 dropup open']//div[@class='filter-option-inner-inner'][normalize-space()='Nothing selected']";
    String saveCreate="//button[@class='btn btn-default save-and-add-contact customer-form-submiter']";
    String save="//button[@class='btn btn-primary only-save customer-form-submiter']";

    //Project screen
    String newProject="//a[normalize-space()='New Project']";
    String gratt="//a[@class='btn btn-default btn-with-tooltip']";

    //New Projects screen
    String projectName="//input[@id='name']";
    String customer="//button[@class='btn dropdown-toggle bs-placeholder btn-default']//div[@class='filter-option-inner-inner'][normalize-space()='Select and begin typing']";
    String billingType="//div[contains(text(),'Fixed Rate')]";
    String Status = "//div[contains(text(),'In Progress')]";
    String startDate = "//input[@id='start_date']";
    String Deadline = "//input[@id='deadline']";
    String Tags = "//input[@placeholder='Tag']";
    String Save = "//button[normalize-space()='Save']";
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver;


        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        webDriver.get("https://crm.anhtester.com/admin/authentication");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //email
        //webDriver.findElement(By.id("email")).sendKeys("admin@example.com");
        webDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");

        //password
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //webDriver.findElement(By.id("password")).sendKeys("123456");
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");

        webDriver.findElement(By.xpath("//input[@id='remember']")).click();

        webDriver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(3000);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.quit();

    }
}
