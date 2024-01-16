package Practice.testcase;

import Practice.pages.CustomerPage;
import Practice.pages.DashboardPage;
import Practice.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage(){
        //Login
        loginPage = new LoginPage(webDriver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456"); //Xảy ra chuyển trang

        dashboardPage.clickMenuDashboard();

        //Click menu Customer
        customerPage = dashboardPage.clickMenuCustomers(); //Xảy ra chuyển trang

        //Chuyển sang trang Customer
        customerPage.clickButtonAddNew();
    }
}
