import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import pages.Inventory;
import pages.Login;
import testingData.StandardData;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase01SauceDemo extends BaseTestClass {

        private WebDriver driver;
        private String username;
        private String password;




        @BeforeMethod
        public void setUpTest(){
            driver = setUpDriver();
            username = StandardData.STANDARD_USER_USERNAME;
            password = StandardData.STANDARD_USER_PASSWORD;
        }

        @Test
        public void TC_01() {
            Login login = new Login(driver).open();

            Login loginUsername = login.typeUsername(username);
            Login loginPass = login.typePassword(password);
            Login buttonLogin = login.buttonLogin();

            Inventory inventory = new Inventory(driver);

            //Find - "PRODUCTS" header
            String headerText = inventory.getProductHeaderText();
            System.out.println("Find word PRODUCTS. Located element is: " + headerText);
            Assert.assertEquals("PRODUCTS", headerText, "ERROR - PRODUCTS HEADER NOT FOUND");
            //Find - shopping cart
            boolean shoppingCart = inventory.getShoppingCartPresent();
            System.out.println("Find element SHOPPING CART. Element found: " + shoppingCart);
            Assert.assertTrue(shoppingCart, "ERROR - Element Shopping Cart not found!");

            //Find - burger menu in the upper left corner
            boolean burgerMenu = inventory.getBurgerMenuPresent();
            System.out.println("Find element BURGER MENU BUTTON. Element found: " + burgerMenu);
            Assert.assertTrue(burgerMenu, "ERROR - Element Burger Menu Button not found!");

            //Find - Twitter, Facebook, Linkedin links
            String tweeterLink = inventory.getTweeterLinkPresent();
            System.out.println("Find element TWEETER LINK. Element found: " + tweeterLink);
            Assert.assertEquals(tweeterLink, StandardData.SAUCE_DEMO_TWEETER_LINK, "ERROR - TWEETER WEB LINK NOT FOUND");

            //Find - Twitter, Facebook, Linkedin links
            String linkedInLink = inventory.getLinkedinLinkPresent();
            System.out.println("Find element LINKEDIN LINK. Element found: " + linkedInLink);
            Assert.assertEquals(linkedInLink, StandardData.SAUCE_DEMO_LINKEDIN_LINK, "ERROR - LINKEDIN WEB LINK NOT FOUND");

            //Find - Twitter, Facebook, Linkedin links
            String facebookLink = inventory.getFacebookLinkPresent();
            System.out.println("Find element FACEBOOK LINK. Element found: " + facebookLink);
            Assert.assertEquals(facebookLink, StandardData.SAUCE_DEMO_FACEBOOK_LINK, "ERROR - FACEBOOK WEB LINK NOT FOUND");

            //Find - Logout
            Inventory buttonBurgerMenu = inventory.clickButtonBurgerMenu();
            boolean logoutInMenu = inventory.getLogoutPresent();
            System.out.println("Find element LOGOUT IN BURGER MENU. Element found: " + logoutInMenu);
            Assert.assertTrue(logoutInMenu, "ERROR - Element Logout not found!");
        }


        @AfterMethod(alwaysRun = true)
        public void tearDownTest(){
            quitDriver(driver);
        }
}
