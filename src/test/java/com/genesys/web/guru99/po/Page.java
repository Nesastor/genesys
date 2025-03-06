package com.genesys.web.guru99.po;

import org.openqa.selenium.WebDriver;

public class Page {
    protected WebDriver driver;
    protected static long defaultWaitSeconds = 3;

    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
