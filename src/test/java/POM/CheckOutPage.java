package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

    WebDriver driver;

    By addressField = By.id("billing:street1");

    By cityField = By.id("billing:city");

    By zipCodeField = By.id("billing:postcode");

    By provinceField = By.id("billing:region_id");

    By countryField = By.id("billing:country_id");

    By phoneField = By.id("billing:telephone");

    By continueBillButton = By.cssSelector("button[onclick='billing.save()']");

    By continueShipMethodButton = By.xpath("//button[@onclick='shippingMethod.save()']");

    By checkPaymentInformation = By.xpath("//input[@id='p_method_checkmo']");

    By continuePaymentInforButton = By.cssSelector("button[onclick='payment.save()']");

    By placeOrderButton = By.cssSelector("button[title='Place Order']");

    By addressSelectField = By.id("billing-address-select");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectNewAddress() {
        WebElement addressSelect = driver.findElement(addressSelectField);
        Select addressSelected = new Select(addressSelect);
        addressSelected.selectByVisibleText("New Address");
    }

    public void enterAddress(String address) {
        WebElement addressInput = driver.findElement(addressField);
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void enterCity(String city) {
        WebElement inputCity = driver.findElement(cityField);
        inputCity.clear();
        inputCity.sendKeys(city);
    }

    public void enterZip(String zip) {
        WebElement inputZipCode = driver.findElement(zipCodeField);
        inputZipCode.clear();
        inputZipCode.sendKeys(zip);
    }

    public void enterCounty() {
        WebElement country = driver.findElement(countryField);
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("United States");
    }

    public void enterProvince() {
        WebElement province = driver.findElement(provinceField);
        Select provinceSelect = new Select(province);
        provinceSelect.selectByVisibleText("Alabama");
    }

    public void enterTelephone(String telephone) {
        WebElement inputTelephone = driver.findElement(phoneField);
        inputTelephone.clear();
        inputTelephone.sendKeys(telephone);
    }

    public void clickBillingContinueButton() {
        driver.findElement(continueBillButton).click();
    }

    public void clickShipMethodContinueButton() {
        driver.findElement(continueShipMethodButton).click();
    }

    public void clickCheckPaymentInfor() {
        driver.findElement(checkPaymentInformation).click();
    }

    public void clickContinuePaymentInfor() {
        driver.findElement(continuePaymentInforButton).click();
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }
}
