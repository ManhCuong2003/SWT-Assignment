package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddProductToCart {
    WebDriver driver;
    By addButton = By.xpath("//li[1]//div[1]//div[3]//button[1]");

    By inputCoupon = By.id("coupon_code");

    By applyButton = By.xpath("//button[@title='Apply']");

    public AddProductToCart(WebDriver driver) {
        this.driver = driver;
    }

    public void inputCoupon(String coupon) {
        WebElement inputCouponCode = this.driver.findElement(inputCoupon);
        inputCouponCode.clear();
        inputCouponCode.sendKeys(coupon);
    }

    public void clickApply() {
        this.driver.findElement(applyButton).click();
    }

    public void addMobile() {
        this.driver.findElement(addButton).click();
    }

    public void verifyTheDiscount(String expected, String actual) {
        Assert.assertNotEquals(actual, expected);
    }
}
