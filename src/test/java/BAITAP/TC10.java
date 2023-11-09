package BAITAP;

import POM.AdminPage;
import POM.LoginAdminPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TC10 {
    @Test
    public void testCase10() {
        String username = "user01";
        String password = "guru99com";
        String orderId = "100021268";
        String fromDate ="11/1/2023";
        String toDate = "11/8/2023";
        WebDriver driver = driverFactory.getChromeDriver();
        LoginAdminPage loginAdminPage = new LoginAdminPage(driver);
        AdminPage adminPage = new AdminPage(driver);
        try {
            //1. Go to http://live.techpanda.org/index.php/backendlogin
            driver.get("http://live.techpanda.org/index.php/backendlogin");
            //2. Login the credentials provided
            loginAdminPage.enterUsername(username);
            loginAdminPage.enterPassword(password);
            loginAdminPage.clickLogin();
            //3. Go to Sales-> Orders menu
            adminPage.closePopUp();
            Thread.sleep(2000);
            adminPage.clickSales();
            Thread.sleep(2000);
            adminPage.clickOrderMenu();
            Thread.sleep(2000);
            //4. Input OrderId and FromDate -> ToDate
            adminPage.enterOrderId(orderId);
            Thread.sleep(1000);
            adminPage.enterFromDate(fromDate);
            Thread.sleep(1000);
            adminPage.enterToDate(toDate);
            Thread.sleep(1000);
            //5. Click Search button
            adminPage.clickSearchButton();
            Thread.sleep(3000);
            //6. Screenshot capture.
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\FPT\\CN5\\SWT301\\baitap\\BT4\\selenium-webdriver-java\\src\\test\\java\\screenshotTestcase10.png"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
