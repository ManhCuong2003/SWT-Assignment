package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 {

    @Test
    public void Testcase04(){

        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // TC04: Verify that you are able to compare two products
            // Step 1: Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            // Step 2: Click on "MOBILE" menu
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            // Step 3: Click on "Add To Compare" for 2 mobiles (Sony Xperia & iPhone)
            WebElement sonyXperiaCompare = driver.findElement(By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
            sonyXperiaCompare.click();
            WebElement iPhoneCompare = driver.findElement(By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
            iPhoneCompare.click();

            String nameProduct1 = driver.findElement(By.cssSelector("a[title='Sony Xperia']")).getText();
            String nameProduct2 = driver.findElement(By.cssSelector("h2[class='product-name'] a[title='IPhone']")).getText();

            // Step 4: Click on "COMPARE" button
            WebElement compareButton = driver.findElement(By.cssSelector("button[title='Compare']"));
            compareButton.click();
            String mainWindowHandle = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // Step 5: Verify the pop-up window and check that the products are reflected in it
            WebElement compareHeading = driver.findElement(By.cssSelector("div[class='page-title title-buttons'] h1"));
            Assert.assertEquals(compareHeading.getText(),"COMPARE PRODUCTS");

            WebElement compareProduct1 = driver.findElement(By.cssSelector("h2[class='product-name'] a[title='Sony Xperia']"));
            WebElement compareProduct2 = driver.findElement(By.cssSelector("h2[class='product-name'] a[title='IPhone']"));
            Assert.assertEquals(compareProduct1.getText(), nameProduct1);
            Assert.assertEquals(compareProduct2.getText(), nameProduct2);
            // Step 6: Close the Popup Windows
            driver.close();
            driver.switchTo().window(mainWindowHandle);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
