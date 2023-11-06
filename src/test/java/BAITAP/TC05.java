package BAITAP;

import POM.RegisterPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TC05 {
    @Test
    public void Testcase05(){
        String firstName = "Cuong";
        String lastName = "Tran";
        String email = "TranManhCuongtest1234@gmail.com";
        String password = "123456";
        String confirmPassword = password;

        WebDriver driver = driverFactory.getChromeDriver();
        try{

            driver.get("http://live.techpanda.org/");
            RegisterPage registerPage = new RegisterPage(driver);

            registerPage.clickMyAccountLink();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            registerPage.clickCreateAccountLink();


            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            registerPage.enterFirtstName(firstName);
            registerPage.enterLastName(lastName);
            registerPage.enterEmail(email);
            registerPage.enterPassword(password);
            registerPage.enterConfirmPassword(confirmPassword);
            registerPage.clickRegisterButton();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            // Step 4: Verify Registration is done. Expected account registration done.
            WebElement successMessage = driver.findElement(By.cssSelector("li[class='success-msg'] ul li span"));
            Assert.assertEquals(successMessage.getText(),"Thank you for registering with Main Website Store.");

            // Step 5: Go to TV menu
            WebElement tvMenu = driver.findElement(By.xpath("//a[normalize-space()='TV']"));
            tvMenu.click();

            // Step 6: Add product in your wish list - use product - LG LCD
            WebElement lgLcdAddToWishlist = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]"));
            lgLcdAddToWishlist.click();

            // Step 7: Click SHARE WISHLIST
            WebElement shareWishlistLink = driver.findElement(By.cssSelector("button[title='Share Wishlist']"));
            shareWishlistLink.click();

            // Step 8: In next page enter Email and a message and click SHARE WISHLIST
            WebElement emailInputWishlist = driver.findElement(By.id("email_address"));
            emailInputWishlist.sendKeys("test@example.com");
            WebElement messageInput = driver.findElement(By.id("message"));
            messageInput.sendKeys("Check out my wishlist!");
            WebElement shareWishlistButton = driver.findElement(By.cssSelector("button[title='Share Wishlist'] span span"));
            shareWishlistButton.click();

            // Step 9: Check wishlist is shared. Expected wishlist shared successfully.
            WebElement wishlistSharedMessage = driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']"));
            Assert.assertEquals(wishlistSharedMessage.getText(),"Your Wishlist has been shared.");

            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\FPT\\CN5\\SWT301\\baitap\\BT4\\selenium-webdriver-java\\src\\test\\java\\screenshotTestcase05.png"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
