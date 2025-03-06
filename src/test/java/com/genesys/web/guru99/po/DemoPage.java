package com.genesys.web.guru99.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoPage extends Page {
    private By pageSurroundBy = By.id("rt-page-surround");

    private By jMeterAdFrameBy = By.id("a077aa5e");
    private By jMeterAdImageBy = By.xpath("//a[img[@src='Jmeter720.png']]");

    // TODO Finish PO

    public DemoPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, defaultWaitSeconds)
            .until(d -> d.findElement(pageSurroundBy));
    }

    public void clickJMeterAd() {
        WebElement jMeterAddFrame = driver.findElement(jMeterAdFrameBy);
        driver.switchTo().frame(jMeterAddFrame);
        driver.findElement(jMeterAdImageBy).click();
        // driver.switchTo().defaultContent();
    }
}
