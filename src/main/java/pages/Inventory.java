package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 import testingData.TimeDelay;

public class Inventory extends BasePageClass{

    private final By productsHeaderLocator = By.className("title");
    private final By shoppingCartLocator = By.className("shopping_cart_link");

    private final By burgerMenuLocator = By.xpath("//*[@id=\"react-burger-menu-btn\"]");

    private final By twitterLinkLocator = By.linkText("Twitter");

    private final By facebookLinkLocator = By.linkText("Facebook");

    private final By linkedinLinkLocator = By.linkText("LinkedIn");

    private final By logoutLocator = By.id("logout_sidebar_link");

    private final By buttonBurgerMenu = By.id("react-burger-menu-btn");

    private final By sauceLabsBackpackLocator = By.linkText("Sauce Labs Backpack");

    private final By addToCartSauceLabsFleeceJacketLocator = By.id("add-to-cart-sauce-labs-fleece-jacket");


    public Inventory(WebDriver driver) {
        super(driver);
    }


    public String getProductHeaderText() {
        WebElement element = locatedElementVisibleWait(productsHeaderLocator, TimeDelay.DELAY_3_SEC);
        return element.getText();
    }
    public boolean getShoppingCartPresent() {
        WebElement element = locatedElementVisibleWait(shoppingCartLocator, TimeDelay.DELAY_3_SEC);
        return element.isDisplayed();
    }

    public boolean getBurgerMenuPresent() {
        WebElement element = locatedElementVisibleWait(burgerMenuLocator, TimeDelay.DELAY_3_SEC);
        return element.isDisplayed();
    }

    public String getTweeterLinkPresent() {
        WebElement element = locatedElementVisibleWait(twitterLinkLocator, TimeDelay.DELAY_3_SEC);
        return element.getAttribute("href");
    }

    public String getLinkedinLinkPresent() {
        WebElement element = locatedElementVisibleWait(linkedinLinkLocator, TimeDelay.DELAY_3_SEC);
        return element.getAttribute("href");
    }

    public String getFacebookLinkPresent() {
        WebElement element = locatedElementVisibleWait(facebookLinkLocator, TimeDelay.DELAY_3_SEC);
        return element.getAttribute("href");
    }
    public boolean getLogoutPresent() {
        WebElement element = locatedElementVisibleWait(logoutLocator, TimeDelay.DELAY_3_SEC);
        return element.isDisplayed();
    }

    public Inventory clickButtonBurgerMenu() {
        buttonClick(buttonBurgerMenu);
        return this;
    }

    public Inventory clickItemSauceLabsBackpack() {
        buttonClick(sauceLabsBackpackLocator);
        return this;
    }

    public Inventory clickShoppingCart() {
        buttonClick(shoppingCartLocator);
        return this;
    }

    public Inventory clickAddToCartFleeceJacket() {
        buttonClick(addToCartSauceLabsFleeceJacketLocator);
        return this;
    }
}
