package BAITAP;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import POM.WishListPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TC06 {
    @Test
    public void testCase06() {
        String email = "TranManhCuongtest12345@gmail.com";
        String password = "123456";
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
            // Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            // click on my account link
            WebElement myaccountLink = driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']"));
            myaccountLink.click();
            // Login in application using previously created credential
            loginPage.enterEmailAddress(email);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
            // click my wishlist
            WebElement wishlist = driver.findElement(By.xpath("//div[@class='block-content']//a[normalize-space()='My Wishlist']"));
            wishlist.click();
            Thread.sleep(3000);
            //In next page, Click ADD TO CART link
            WebElement addToCart = driver.findElement(By.cssSelector("button[title='Add to Cart'][type='button']"));
            addToCart.click();
            cartPage.enterCountry();
            cartPage.enterStateOrProvince();
            cartPage.enterZipCode(zipCode);
            cartPage.clickEstimateButton();
            Thread.sleep(2000);
            // Verify Shipping cost generated
            String shipMethodExpected = "Flat Rate";
            String priceExpected = "$5.00";
            String actualShipMethod = driver.findElement(By.cssSelector("dl[class='sp-methods'] dt")).getText();
            String actualPrice = driver.findElement(By.cssSelector("label[for='s_method_flatrate_flatrate'] span[class='price']")).getText();
            Assert.assertEquals(actualShipMethod, shipMethodExpected);
            Assert.assertEquals(actualPrice, priceExpected);
            // Select Shipping Cost, Update Total
            WebElement shippingCost = driver.findElement(By.xpath("//input[@id='s_method_flatrate_flatrate']"));
            shippingCost.click();
            WebElement updateTotal = driver.findElement(By.cssSelector("button[title='Update Total']"));
            updateTotal.click();
            Thread.sleep(2000);
            // Verify shipping cost is added to total
            String totalPriceExpected = "$620.00";
            String actualTotalPrice = driver.findElement(By.cssSelector("strong span[class='price']")).getText();
            Assert.assertEquals(actualTotalPrice, totalPriceExpected);
            // Click "Proceed to Checkout"
            WebElement checkOutButton = driver.findElement(By.cssSelector("li[class='method-checkout-cart-methods-onepage-bottom'] button[title='Proceed to Checkout']"));
            checkOutButton.click();
            // Enter Billing Information, and click Continue
            checkOutPage.enterAddress(address);
            checkOutPage.enterCity(city);
            checkOutPage.enterProvince();
            checkOutPage.enterCounty();
            checkOutPage.enterZip(zipCode);
            checkOutPage.enterTelephone(telephone);
            checkOutPage.clickBillingContinueButton();
            Thread.sleep(3000);
            checkOutPage.clickShipMethodContinueButton();
            Thread.sleep(3000);
            checkOutPage.clickCheckPaymentInfor();
            Thread.sleep(3000);
            checkOutPage.clickContinuePaymentInfor();
            Thread.sleep(3000);
            checkOutPage.clickPlaceOrder();
            Thread.sleep(3000);
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\FPT\\CN5\\SWT301\\baitap\\BT4\\selenium-webdriver-java\\src\\test\\java\\screenshotTestcase06.png"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            // close browser
            driver.quit();
        }
    }
}
