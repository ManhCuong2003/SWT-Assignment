package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    WebDriver driver;

    By countryField = By.id("country");

    By stateOrProvinceField = By.id("region");

    By zipField = By.id("postcode");

    By estimateButton = By.cssSelector("button[title='Estimate']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCountry() {
        WebElement country = driver.findElement(countryField);
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("Vietnam");
    }

    public void enterStateOrProvince(String provinceOrState) {
        WebElement province = driver.findElement(stateOrProvinceField);
        province.clear();
        province.sendKeys(provinceOrState);
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
