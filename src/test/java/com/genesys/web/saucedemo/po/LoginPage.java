package com.genesys.web.saucedemo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {
    public static final String EMPTY_USER_ERROR_MESSAGE = "Username is required";

    private By loginContainerBy = By.className("login_container");
    private By usernameBy = By.id("user-name");
    private By passwordBy = By.id("password");
    private By loginButtonBy = By.id("login-button");
    private By errorMessageContainerBy = By.className("error-message-container");
    private By errorMessageBy = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver){
        super(driver);
        new WebDriverWait(driver, defaultWaitSeconds)
            .until(d -> d.findElement(loginContainerBy));
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonBy).click();
    }

    public String getErrorMessage() {
        if (driver.findElement(errorMessageContainerBy).isDisplayed()) {
            return driver.findElement(errorMessageContainerBy).findElement(errorMessageBy).getText();
        } else {
            return "";
        }
    }

    public InventoryPage loginUser(String userName, String password) {
        driver.findElement(usernameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginButtonBy).click();
        return new InventoryPage(driver);
    }
}
