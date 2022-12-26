package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testingData.TimeDelay;

public class CheckoutComplete extends BasePageClass {

    private final By checkOutThankYouLocator = By.className("complete-header");
    private final By logoutBMLocator = By.id("logout_sidebar_link");
    private final By buttonBurgerMenu = By.id("react-burger-menu-btn");


    public CheckoutComplete (WebDriver driver) {super(driver);}

    public String getThankYouMessageCheckout() {
        WebElement element = locatedElementVisibleWait(checkOutThankYouLocator, TimeDelay.DELAY_3_SEC);
        return element.getText();
    }

    public CheckoutComplete logoutClick() {
        buttonClick(logoutBMLocator);
        return this;
    }

    public CheckoutComplete clickButtonBurgerMenu() {
        buttonClick(buttonBurgerMenu);
        return this;
    }
}
