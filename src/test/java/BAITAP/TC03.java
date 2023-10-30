package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TC03 {
    /*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile

4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed

"The requested quantity for "Sony Xperia" is not available.

5. Verify the error message

6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.

7. Verify cart is empty */
    //Init web-driver session
    @Test
    public void testCase03() {
        //Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
           // 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            // 2. Click on �MOBILE� menu
            WebElement mobile = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobile.click();
            // 3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
            WebElement addToCart = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[3]/div[1]/div[3]/button[1]"));
            addToCart.click();
            // 4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
            //"The requested quantity for "Sony Xperia" is not available.
            WebElement quantity = driver.findElement(By.cssSelector("input[title='Qty']"));
            quantity.clear();
            quantity.sendKeys("1000");
            WebElement updateButton = driver.findElement(By.cssSelector("button[title='Update']"));
            updateButton.click();
            String expectedError = "The requested quantity for \"Sony Xperia\" is not available.";
            String actualError = driver.findElement(By.cssSelector(".item-msg.error")).getText();
            //5. Verify the error message
            Assert.assertEquals(actualError,expectedError);
            // 6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
            WebElement emptyCart = driver.findElement(By.cssSelector("span[shub-ins='1']"));
            emptyCart.click();
            // 7. Verify cart is empty
            String actualEmpty = driver.findElement(By.cssSelector("h1[shub-ins='1']")).getText();
            String expectEmpty = "SHOPPING CART IS EMPTY";
            Assert.assertEquals(actualEmpty,expectEmpty);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
