package com.genesys.web.saucedemo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver driver;
    protected static long defaultWaitSeconds = 3; 

    private By footerBy = By.tagName("footer");
    private By footerTextBy = By.xpath("//div[@data-test='footer-copy']");

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getFooterText() {
        if (driver.findElement(footerBy).isDisplayed()) {
            return driver.findElement(footerBy).findElement(footerTextBy).getText();
        } else {
            return "";
        }
    }
}
