package com.genesys.web.saucedemo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage extends Page {
    public static final String MESSAGE_GOOD = "Thank you for your order!";

    private By checkoutCompleteContainerBy = By.id("checkout_complete_container");
    private By completeHeaderBy = By.className("complete-header");

    CheckoutCompletePage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, defaultWaitSeconds)
            .until(d -> d.findElement(checkoutCompleteContainerBy));
    }

    public String getCompletionMessage() {
        return driver.findElement(completeHeaderBy).getText();
    }
}
