package com.genesys.web.saucedemo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends Page {
    private By checkoutInfoContainerBy = By.id("checkout_info_container");
    private By firstNameBy = By.id("first-name");
    private By lastNameBy = By.id("last-name");
    private By postalCodeBy = By.id("postal-code");
    private By continueBy = By.id("continue");

    public CheckoutPage(WebDriver driver){
        super(driver);
        new WebDriverWait(driver, defaultWaitSeconds)
            .until(d -> d.findElement(checkoutInfoContainerBy));
    }

    public void fillInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameBy).sendKeys(firstName);
        driver.findElement(lastNameBy).sendKeys(lastName);
        driver.findElement(postalCodeBy).sendKeys(postalCode);
    }

    public OrderOverviewPage clickContinue() {
        driver.findElement(continueBy).click();
        return new OrderOverviewPage(driver);
    }

    public OrderOverviewPage fillInformationAndContinue(String firstName, String lastName, String postalCode) {
        fillInformation(firstName, lastName, postalCode);
        return clickContinue();
    }
}
