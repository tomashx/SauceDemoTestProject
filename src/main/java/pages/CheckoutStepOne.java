package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testingData.TimeDelay;

public class CheckoutStepOne extends BasePageClass {

    private final By firstNameLocator = By.xpath("//*[@id='first-name']");

    private final By lastNameLocator = By.xpath("//*[@id='last-name']");

    private final By zipPostalCodeLocator = By.id("postal-code");

    private final By continueButtonLocator = By.id("continue");


    public CheckoutStepOne (WebDriver driver) {
        super(driver);
    }

    public CheckoutStepOne typeFirstName(String firstName){
        WebElement firstNameTextField = locatedElementVisibleWait(firstNameLocator, TimeDelay.DELAY_3_SEC);
        clearTypeTextInElement(firstNameTextField, firstName);
        return this;
    }

    public CheckoutStepOne typeLastName(String lastName){
        WebElement lastNameTextField = locatedElementVisibleWait(lastNameLocator, TimeDelay.DELAY_3_SEC);
        clearTypeTextInElement(lastNameTextField, lastName);
        return this;
    }

    public CheckoutStepOne typeZipPostalCode(String zipCode){
        WebElement zipPostalCodeTextField = locatedElementVisibleWait(zipPostalCodeLocator, TimeDelay.DELAY_3_SEC);
        clearTypeTextInElement(zipPostalCodeTextField, zipCode);
        return this;
    }

    public CheckoutStepOne clickOnContinue() {
        buttonClick(continueButtonLocator);
        return this;
    }
}
