package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testingData.StandardData;
import testingData.TimeDelay;

public class InventoryItem extends BasePageClass {

    private final By inventoryDetailsNameLocator = By.xpath("//div[text()='Sauce Labs Backpack']");

    private final By inventoryDetailsDescriptionLocator = By.xpath("//div[contains(text(), '" + StandardData.SAUCE_LABS_BACKPACK_DESCRIPTION + "')]");

    private final By inventoryDetailsPriceLocator = By.className("inventory_details_price");

    private final By inventoryAddToCartLocator = By.id("add-to-cart-sauce-labs-backpack");

    private final By backToProductsLocator = By.id("back-to-products");

    public InventoryItem(WebDriver driver) {
        super(driver);
    }

    public String getItemNameText() {
        WebElement element = locatedElementVisibleWait(inventoryDetailsNameLocator, TimeDelay.DELAY_3_SEC);
        return element.getText();
    }

    public String getItemDescriptionText() {
        WebElement element = locatedElementVisibleWait(inventoryDetailsDescriptionLocator, TimeDelay.DELAY_3_SEC);
        return element.getText();
    }

    public String getItemPriceText() {
        WebElement element = locatedElementVisibleWait(inventoryDetailsPriceLocator, TimeDelay.DELAY_3_SEC);
        return element.getText();
    }

    public InventoryItem clickAddToCart() {
        buttonClick(inventoryAddToCartLocator);
        return this;
    }

    public InventoryItem clickBackToProducts() {
        buttonClick(backToProductsLocator);
        return this;
    }

}
