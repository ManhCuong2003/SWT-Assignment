package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    WebDriver driver;

    By countryField = By.id("country");

    By stateOrProvinceField = By.id("region_id");

    By zipField = By.id("postcode");

    By estimateButton = By.cssSelector("button[title='Estimate']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCountry() {
        WebElement country = driver.findElement(countryField);
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("United States");
    }

    public void enterStateOrProvince() {
        WebElement province = driver.findElement(stateOrProvinceField);
        Select provinceSelect = new Select(province);
        provinceSelect.selectByVisibleText("Alabama");
    }

    public void enterZipCode(String zip) {
        WebElement zipCode = driver.findElement(zipField);
        zipCode.clear();
        zipCode.sendKeys(zip);
    }

    public void clickEstimateButton() {
        driver.findElement(estimateButton).click();
    }
}
