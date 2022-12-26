package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwo extends BasePageClass{

    private final By finishLocator = By.xpath("//*[@id='finish']");

    public CheckoutStepTwo (WebDriver driver) {
        super(driver);
    }

    public CheckoutStepTwo clickOnFinish() {
        buttonClick(finishLocator);
        return this;
    }
}
