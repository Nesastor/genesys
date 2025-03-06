package com.genesys.web.onlinehtmleditor.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditorPage {
    private WebDriver driver;
    protected static long defaultWaitSeconds = 3;

    private By toolbarBy = By.xpath("//div[@role='toolbar']");
    private By boldButtonBy = By.xpath("//button[span='Bold']");
    private By underlineButtonBy = By.xpath("//button[span='Underline']");

    private By textBoxBy = By.xpath("//div[@role='textbox']");

    public EditorPage(WebDriver driver) {
        this.driver = driver;
        System.out.println("DRIVER : " + driver == null ? "NULL DRIVER" : driver.getCurrentUrl());
        new WebDriverWait(driver, defaultWaitSeconds)
            .until(d -> d.findElement(textBoxBy));
    }

    public WebElement getToolbar() {
        return driver.findElement(toolbarBy);
    }

    public void clickBoldButton() {
        driver.findElement(toolbarBy).findElement(boldButtonBy).click();
    }

    public void clickUnderlineButton() {
        driver.findElement(toolbarBy).findElement(underlineButtonBy).click();
    }

    public void writeTextToTextbox(String text) {
        driver.findElement(textBoxBy).sendKeys(text);
    }

    public String getTextFromTextbox() {
        return driver.findElement(textBoxBy).getText().replace("\u2060", ""); // TODO Solve U+2060 issue
    }
}
