package Practice.testcase;

import Practice.pages.DashboardPage;
import Practice.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

import static keywords.ActionKeyWords.waitForPageLoaded;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testLoginSuccess() {
        loginPage = new LoginPage(webDriver);

        dashboardPage = loginPage.loginCRM("admin@example.com", "123456"); //Xảy ra chuyển trang

        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginSuccess();

        //Logout từ trang Dashboard
        dashboardPage.logOut();
    }
}
