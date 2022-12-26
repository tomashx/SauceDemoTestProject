import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import testingData.StandardData;

public class TestCase02SauceDemo extends BaseTestClass {

    private WebDriver driver;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String zipCode;
    private String thankYouMessageCheckout;

    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
        username = StandardData.STANDARD_USER_USERNAME;
        password = StandardData.STANDARD_USER_PASSWORD;
        firstName = StandardData.FIRST_NAME_CHECKOUT;
        lastName = StandardData.LAST_NAME_CHECKOUT;
        zipCode = StandardData.ZIP_CODE_CHECKOUT;
        thankYouMessageCheckout = StandardData.CHECKOUT_THANK_YOU_MESSAGE;

    }

    @Test
    public void TC_02() throws InterruptedException {

        Login login = new Login(driver).open();

        //Type Username
        Login loginUsername = login.typeUsername(username);
        //Type password
        Login loginPass = login.typePassword(password);
        //Login button click
        Login buttonLogin = login.buttonLogin();


        Inventory inventory = new Inventory(driver);

        InventoryItem inventoryItem = new InventoryItem(driver);

        Cart cart = new Cart(driver);

        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);

        CheckoutStepTwo checkoutStepTwo = new CheckoutStepTwo(driver);

        CheckoutComplete checkoutComplete = new CheckoutComplete(driver);


        //Click on item
        Inventory sauceLabsBackpackItemClick = inventory.clickItemSauceLabsBackpack();
        Thread.sleep(3000);

        //Verify Item Name
        String sauceLabsBackpackVerifyName = inventoryItem.getItemNameText();
        System.out.println("Find item name Sauce Labs Backpack. Found element is: "
                            + sauceLabsBackpackVerifyName);
        Assert.assertEquals
                ("Sauce Labs Backpack", sauceLabsBackpackVerifyName,
                        "ERROR - Item with name \"Sauce Labs Backpack\" not found");

        //Verify Item Description
        String sauceLabsBackpackVerifyDescription = inventoryItem.getItemDescriptionText();
        System.out.println("Find item description for "
                            + StandardData.SAUCE_LABS_BACKPACK_NAME +
                            ". Found element is: " + sauceLabsBackpackVerifyDescription);
        Assert.assertEquals
                (StandardData.SAUCE_LABS_BACKPACK_DESCRIPTION, sauceLabsBackpackVerifyDescription,
                        "ERROR - Item with details" + sauceLabsBackpackVerifyDescription + "not found");

        //Verify Item Price
        String sauceLabsBackpackVerifyPrice = inventoryItem.getItemPriceText();
        System.out.println("Find item price for "
                + StandardData.SAUCE_LABS_BACKPACK_PRICE +
                ". Found element price is: " + sauceLabsBackpackVerifyPrice);
        Assert.assertEquals
                (StandardData.SAUCE_LABS_BACKPACK_PRICE, sauceLabsBackpackVerifyPrice,
                        "ERROR - Item price " + sauceLabsBackpackVerifyPrice + " not found");

        //ADD TO CART
        InventoryItem addToCartClick = inventoryItem.clickAddToCart();
        Thread.sleep(1000);

        //BACK TO PRODUCTS
        InventoryItem backToProductsClick = inventoryItem.clickBackToProducts();

        //ADD TO CART FLEECE JACKET
        Inventory addToCartFleeceJacketClick = inventory.clickAddToCartFleeceJacket();
        Thread.sleep(1000);

        //SHOPPING CART CLICK
        Inventory shoppingCartClick = inventory.clickShoppingCart();
        Thread.sleep(1000);

        //CHECKOUT CLICK
        Cart checkoutClick = cart.clickOnCheckout();

        //FILL REQUIRED TEXT FIELDS AND CLICK CONTINUE
        CheckoutStepOne checkoutTextFieldsFill =
                checkoutStepOne.typeFirstName(firstName).typeLastName(lastName).typeZipPostalCode(zipCode);
        Thread.sleep(1000);

        CheckoutStepOne checkoutContinueClick = checkoutStepOne.clickOnContinue();

        //CLICK FINISH
        CheckoutStepTwo checkoutFinishClick = checkoutStepTwo.clickOnFinish();
        Thread.sleep(2000);

        //Verify "THANK YOU FOR YOUR ORDER" is displayed
        String getThankYouMessageCheckout = checkoutComplete.getThankYouMessageCheckout();
        System.out.println("Find THANK YOU MESSAGE. Located element is: " + getThankYouMessageCheckout);
        Assert.assertEquals(thankYouMessageCheckout, getThankYouMessageCheckout, "ERROR - THANK YOU MESSAGE NOT FOUND");

        //LOGOUT

        CheckoutComplete buttonBurgerMenu = checkoutComplete.clickButtonBurgerMenu();
        Thread.sleep(1000);

        CheckoutComplete logoutClick = checkoutComplete.logoutClick();
        Thread.sleep(2000);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }
}
