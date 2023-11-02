package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage {
    WebDriver driver;

    By tvMenu = By.xpath("//a[normalize-space()='TV']");

    By addToWishListButton = By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]");

    By myAccount = By.cssSelector("div[class='footer'] a[title='My Account']");
    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTvMenu() {
        driver.findElement(tvMenu).click();
    }

    public void addToWishList() {
        driver.findElement(addToWishListButton).click();
    }
    public void clickMyAccount() {
        driver.findElement(myAccount).click();
    }
}
