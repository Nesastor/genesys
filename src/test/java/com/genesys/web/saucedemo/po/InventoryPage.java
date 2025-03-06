package com.genesys.web.saucedemo.po;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends Page {
    public class InventoryItem {
        private WebElement root;

        private By inventoryItemNameBy = By.className("inventory_item_name");
        private By addToCartBy = By.tagName("button");

        public InventoryItem(WebElement root) {
            this.root = root;
        }

        public String getName() {
            return root.findElement(inventoryItemNameBy).getText();
        }

        public void addToCart() {
            root.findElement(addToCartBy).click();
        }
    }

    private By inventotyContainerBy = By.id("inventory_container");
    private By inventoryItemBy = By.className("inventory_item");
    private By shoppingCartBy = By.id("shopping_cart_container");
    private By shoppingCartBadgeBy = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, defaultWaitSeconds)
            .until(d -> d.findElement(inventotyContainerBy));
    }

    public List<InventoryPage.InventoryItem> getInventoryItems() {
        return driver.findElements(inventoryItemBy)
            .stream()
            .map(e -> new InventoryItem(e))
            .collect(Collectors.toList());
    }

    public InventoryItem findInventoryItemByName(String name) {
        return getInventoryItems()
            .stream()
            .filter(i -> i.getName().equals(name))
            .findFirst()
            .orElseThrow();
    }

    public int getShoppingCartNumber() {
        WebElement cartBadge = driver.findElement(shoppingCartBy).findElement(shoppingCartBadgeBy);
        return Integer.parseInt(cartBadge.getText());
    }

    public CartPage clickShoppingCart() {
        driver.findElement(shoppingCartBy).click();;
        return new CartPage(driver);
    }
}
