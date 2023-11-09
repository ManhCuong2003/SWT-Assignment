package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
    WebDriver driver;

    By closePopUpButton = By.xpath("//a[@title='close']");

    By sales = By.xpath("//body/div[contains(@class,'wrapper')]/div[contains(@class,'header')]/div[contains(@class,'nav-bar')]/ul[@id='nav']/li[1]/a[1]");

    By orderMenu = By.xpath("//body/div[contains(@class,'wrapper')]/div[contains(@class,'header')]/div[contains(@class,'nav-bar')]/ul[@id='nav']/li[1]/ul[1]/li[1]");

    By orderIdElement = By.id("sales_order_grid_filter_real_order_id");

    By fromDateElement = By.name("created_at[from]");

    By toDateElement = By.name("created_at[to]");

    By searchButton = By.xpath("//span[contains(text(),'Search')]");
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopUp() {
        this.driver.findElement(closePopUpButton).click();
    }

    public void clickSales() {
        this.driver.findElement(sales).click();
    }
    public void clickOrderMenu() {
        this.driver.findElement(orderMenu).click();
    }

    public void enterOrderId(String orderId) {
        WebElement orderIdField = this.driver.findElement(orderIdElement);
        orderIdField.clear();
        orderIdField.sendKeys(orderId);
    }

    public void enterFromDate(String fromDate) {
        WebElement orderIdField = this.driver.findElement(fromDateElement);
        orderIdField.clear();
        orderIdField.sendKeys(fromDate);
    }

    public void enterToDate(String toDate) {
        WebElement orderIdField = this.driver.findElement(toDateElement);
        orderIdField.clear();
        orderIdField.sendKeys(toDate);
    }

    public void clickSearchButton() {
        this.driver.findElement(searchButton).click();
    }
}
