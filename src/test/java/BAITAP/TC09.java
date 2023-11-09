package BAITAP;

import POM.AddProductToCart;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 {
    @Test
    public void testCase09(){
        String couponCode = "GURU50";
        WebDriver driver = driverFactory.getChromeDriver();
        AddProductToCart addProductToCart = new AddProductToCart(driver);
        try {
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //2. Go to Mobile and add IPHONE to cart
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();
            addProductToCart.addMobile();
            String beforGrandTotal = driver.findElement(By.cssSelector("strong span[class='price']")).getText();
            //3. Enter Coupon Code
            addProductToCart.inputCoupon(couponCode);
            addProductToCart.clickApply();
            Thread.sleep(3000);
            String afterGrandTotal = driver.findElement(By.cssSelector("strong span[class='price']")).getText();
            //4. Verify the discount generated
            System.out.println("Before Grand Total: " + beforGrandTotal);
            System.out.println("After Grand Total: " + afterGrandTotal);
            addProductToCart.verifyTheDiscount(afterGrandTotal, beforGrandTotal);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
