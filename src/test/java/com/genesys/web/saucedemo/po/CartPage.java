package com.genesys.web.saucedemo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends Page {
    private By cartContetContainerBy = By.id("cart_contents_container");
    private By checkoutBy = By.id("checkout");

    public CartPage(WebDriver driver){
        super(driver);
        new WebDriverWait(driver, defaultWaitSeconds)
            .until(d -> d.findElement(cartContetContainerBy));
    }

    public CheckoutPage clickCheckout() {
        driver.findElement(checkoutBy).click();
        return new CheckoutPage(driver);
    }
}
