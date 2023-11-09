package BAITAP;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class TC08 {
    @Test
    public void testCase08() {
        String email = "TranManhCuongtest12345@gmail.com";
        String password = "123456";
        String testData = "10";
        String city = "Florence";
        String zipCode = "35211";
        String address = "01 S Pine St";
        String telephone = "0912345678";
        //Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);
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
            //4. Click on 'REORDER' link , change QTY & click Update
            WebElement reOrder = driver.findElement(By.xpath("//a[normalize-space()='Reorder']"));
            reOrder.click();
            //5. Verify Grand Total is changed
            WebElement quantity = driver.findElement(By.xpath("//input[@title='Qty']"));
            String beforeGrandTotal = driver.findElement(By.cssSelector("strong span[class='price']")).getText();
            quantity.clear();
            quantity.sendKeys(testData);
            Thread.sleep(3000);
            WebElement updateButton = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/table[1]/tfoot[1]/tr[1]/td[1]/button[3]"));
            updateButton.click();
            Thread.sleep(5000);
            String afterGrandTotal = driver.findElement(By.cssSelector("strong span[class='price']")).getText();
            Assert.assertNotEquals( afterGrandTotal, beforeGrandTotal);
            //6. Complete Billing & Shipping Information
            cartPage.enterCountry();
            cartPage.enterStateOrProvince();
            cartPage.enterZipCode(zipCode);
            cartPage.clickEstimateButton();
            Thread.sleep(2000);
            WebElement shippingCost = driver.findElement(By.xpath("//input[@id='s_method_flatrate_flatrate']"));
            shippingCost.click();
            WebElement updateTotal = driver.findElement(By.cssSelector("button[title='Update Total']"));
            updateTotal.click();
            Thread.sleep(2000);
            WebElement checkOutButton = driver.findElement(By.cssSelector("li[class='method-checkout-cart-methods-onepage-bottom'] button[title='Proceed to Checkout']"));
            checkOutButton.click();
            checkOutPage.selectNewAddress();
            checkOutPage.enterAddress(address);
            checkOutPage.enterCity(city);
            checkOutPage.enterProvince();
            checkOutPage.enterCounty();
            checkOutPage.enterZip(zipCode);
            checkOutPage.enterTelephone(telephone);
            checkOutPage.clickBillingContinueButton();
            Thread.sleep(2000);
            checkOutPage.clickShipMethodContinueButton();
            Thread.sleep(2000);
            checkOutPage.clickCheckPaymentInfor();
            Thread.sleep(2000);
            checkOutPage.clickContinuePaymentInfor();
            Thread.sleep(2000);
            checkOutPage.clickPlaceOrder();
            Thread.sleep(2000);
            //7. Verify order is generated and note the order number
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            for(WebElement link:allLinks){
                if(link.getText().startsWith("1000")){
                    System.out.println("Created order Id: " + link.getText());
                }
            }
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\FPT\\CN5\\SWT301\\baitap\\BT4\\selenium-webdriver-java\\src\\test\\java\\screenshotTestcase08.png"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("fail roi");
        } finally {
            driver.quit();
        }
    }
}
