package com.genesys.web.common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import com.genesys.web.saucedemo.utils.Utils;

public abstract class BaseWebTest {
    protected WebDriver driver;
    protected final String url;
    protected final WebdriverEnum webdriver;

    public BaseWebTest(WebdriverEnum webdriver, String url) {
        this.webdriver = webdriver;
        this.url = url;
    }

    @BeforeEach
    protected void setUp() {
        driver = Utils.getDriver(webdriver);
        driver.get(url);
    }

    @AfterEach
    protected void tearDown() {
        driver.quit();
    }
}
