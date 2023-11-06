package BAITAP;

import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 {
    @Test
    public void testCase07() {
        String email = "TranManhCuongtest1234@gmail.com";
        String password = "123456";
        //Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        try {
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //2. Click on My Account link
            WebElement myaccountLink = driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']"));
            myaccountLink.click();
            //3. Login in application using previously created credential
            loginPage.enterEmailAddress(email);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
            //4. Click on 'My Orders'
            WebElement myOrders = driver.findElement(By.xpath("//a[normalize-space()='My Orders']"));
            myOrders.click();
            //5. Click on 'View Order'
            WebElement viewOrder = driver.findElement(By.xpath("//a[normalize-space()='View Order']"));
            viewOrder.click();
            //6. Click on 'Print Order' link
            WebElement printOrder = driver.findElement(By.xpath("//a[normalize-space()='Print Order']"));
            printOrder.click();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
