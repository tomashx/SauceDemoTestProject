package pages;

import testingData.StandardData;
import testingData.TimeDelay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Login extends BasePageClass {
    private final String indexURL = StandardData.INDEX_URL;

    private final By usernameField = By.id("user-name");

    private final By passwordField = By.name("password");

    private final By buttonLogin = By.id("login-button");


    public Login (WebDriver driver) {
        super(driver);
    }

    public Login open(){
        openUrl(indexURL);
        return this;
    }

    public Login typeUsername(String username){
        WebElement usernameTextField = locatedElementVisibleWait(usernameField, TimeDelay.DELAY_3_SEC);
        clearTypeTextInElement(usernameTextField, username);
        return this;
    }

    public Login typePassword(String password){
        WebElement passwordTextField = locatedElementVisibleWait(passwordField, TimeDelay.DELAY_3_SEC);
        clearTypeTextInElement(passwordTextField, password);
        return this;
    }

    public Login buttonLogin(){
        buttonClick(buttonLogin);
        return this;
    }

}
