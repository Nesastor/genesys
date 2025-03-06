package com.genesys.web.saucedemo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderOverviewPage extends Page {
    private By checkoutSummaryContainerBy = By.id("checkout_summary_container");
    private By finishBy = By.id("finish");

    public OrderOverviewPage(WebDriver driver){
        super(driver);
        new WebDriverWait(driver, defaultWaitSeconds)
            .until(d -> d.findElement(checkoutSummaryContainerBy));
    }

    public CheckoutCompletePage clickFinish() {
        driver.findElement(finishBy).click();
        return new CheckoutCompletePage(driver);
    }
}
