package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAdminPage {
    WebDriver driver;

    By username = By.id("username");

    By password = By.id("login");

    By loginButton = By.xpath("//input[@title='Login']");

    public LoginAdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String inputUsername) {
        WebElement usernameField = this.driver.findElement(username);
        usernameField.clear();
        usernameField.sendKeys(inputUsername);
    }

    public void enterPassword(String inputPassword) {
        WebElement passwordField = this.driver.findElement(password);
        passwordField.clear();
        passwordField.sendKeys(inputPassword);
    }

    public void clickLogin() {
        this.driver.findElement(loginButton).click();
    }
}
