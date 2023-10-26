package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;

public class TC01 {

    @Test
    public void testCase1() {

        //Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //Step 2. Verify Title of the page
            String title = driver.findElement(By.cssSelector("h2")).getText();
            AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ",title);
            //Step 3. Click on -> MOBILE -> menu
            WebElement mobile = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobile.click();
            //Step 4. In the list of all mobile , select SORT BY -> dropdown as name
            WebElement sortByName = driver.findElement(By.cssSelector("select[title='Sort By']"));
            Select dropdown = new Select(sortByName);
            dropdown.selectByVisibleText("Name");
            //Step 5. Verify all products are sorted by name
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\FPT\\CN5\\SWT301\\baitap\\BT4\\selenium-webdriver-java\\src\\test\\java\\screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
