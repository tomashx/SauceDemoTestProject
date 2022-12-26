package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends BasePageClass {

    private final By CheckoutInCartLocator = By.xpath("//*[@id='checkout']");

    public Cart (WebDriver driver) {
        super(driver);
    }

    public Cart clickOnCheckout() {
        buttonClick(CheckoutInCartLocator);
        return this;
    }



}
