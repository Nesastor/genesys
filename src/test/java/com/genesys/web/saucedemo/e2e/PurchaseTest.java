package com.genesys.web.saucedemo.e2e;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.genesys.web.common.BaseWebTest;
import com.genesys.web.saucedemo.po.CartPage;
import com.genesys.web.saucedemo.po.CheckoutCompletePage;
import com.genesys.web.saucedemo.po.CheckoutPage;
import com.genesys.web.saucedemo.po.InventoryPage;
import com.genesys.web.saucedemo.po.LoginPage;
import com.genesys.web.saucedemo.po.OrderOverviewPage;
import com.genesys.web.saucedemo.utils.Defaults;
import com.genesys.web.saucedemo.utils.User;
import com.genesys.web.saucedemo.utils.Utils;

public class PurchaseTest extends BaseWebTest {
    protected static final Logger LOGGER = LogManager.getLogger(); // TODO Add logging to test steps

    public PurchaseTest() {
        super(Defaults.DEFAULT_WEBDRIVER, Defaults.SAUCE_URL);
    }

    @Test
    @DisplayName("Complete succesful purchase test")
    public void simplePurchaseTest() throws FileNotFoundException {
        User user = Utils.readUser(Defaults.PERF_GLICH_USER_CREDENTIAL_PATH);
        String firstItemToBuy = "Sauce Labs Backpack";
        String secondItemToBuy = "Sauce Labs Fleece Jacket";

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.loginUser(user.username, user.password);
        inventoryPage.findInventoryItemByName(firstItemToBuy).addToCart();
        inventoryPage.findInventoryItemByName(secondItemToBuy).addToCart();
        Assertions.assertEquals(
            2,
            inventoryPage.getShoppingCartNumber(),
            "The number on the shopping cart does not equal the expected."
        );
        CartPage cartPage = inventoryPage.clickShoppingCart();
        CheckoutPage checkoutPage = cartPage.clickCheckout();
        OrderOverviewPage orderOverviewPage = checkoutPage.fillInformationAndContinue(user.firstName, user.lastName, user.postalCode);
        CheckoutCompletePage checkoutCompletePage = orderOverviewPage.clickFinish();
        Assertions.assertEquals(
            CheckoutCompletePage.MESSAGE_GOOD,
            checkoutCompletePage.getCompletionMessage(),
            "Expected message does not appear after finishing checkout process."
        );
    }

    @Test
    @DisplayName("Empty credentials than successful login and footer validation")
    public void emptyCredentialsAndFooterValidationTest() throws FileNotFoundException {
        User user = Utils.readUser(Defaults.STANDARD_USER_CREDENTIAL_PATH);
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        Assert.assertTrue(
            "Expected error message does not appear after login attempt with empty fields",
            loginPage.getErrorMessage().contains(LoginPage.EMPTY_USER_ERROR_MESSAGE)
        );
        InventoryPage inventoryPage = loginPage.loginUser(user.username, user.password);
        Assert.assertTrue(
            "Footer does not contain current year",
            inventoryPage.getFooterText().contains("2025")
        );
        Assert.assertTrue(
            "Footer does not contain the text \"Terms of Service\"",
            inventoryPage.getFooterText().contains("Terms of Service")
        );
    }
}
