package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.Configuration;
import utils.SeleniumAbstractTest;

/**
 * Example Selenium test that asserts functionality of the website https://yltrue.com/automation
 */
public class MySeleniumTest extends SeleniumAbstractTest {

    private LoginPage loginPage;
    private MainPage mainPage;

    /**
     * Initializes this test's page object models and performs a login with the configured username and password
     */
    @BeforeMethod
    void beforeMethod() {
        Configuration config = new Configuration("config.properties");

        String url = config.getProperty("exampleweburl");
        String username = config.getProperty("username");
        String password = config.getProperty("password");

        driver.get(url);

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        loginPage.login(username, password);
    }

    /**
     * Asserts that clicking the DO1! and DO2! buttons become disabled
     */
    @Test
    void testDoButtons() {
        // Click the DO1! button.
        mainPage.clickDoButton(mainPage.getDoOneButtonLocator());
        Assert.assertTrue(mainPage.doButtonDisabled(mainPage.getDoOneButtonLocator()));

        // Click the DO2! button.
        mainPage.clickDoButton(mainPage.getDoTwoButtonLocator());
        Assert.assertTrue(mainPage.doButtonDisabled(mainPage.getDoTwoButtonLocator()));
    }

    /**
     * Asserts that the font size increase and decrease buttons work as expected
     */
    @Test
    void testChangeFontSize() {
        // Verify the default font size.
        Assert.assertEquals(mainPage.getFontSizeAttribute(), "font-size: 20px;");

        // Increase the font size.
        mainPage.changeFontSize(mainPage.getIncreaseFontSizeButtonLocator());
        Assert.assertEquals(mainPage.getFontSizeAttribute(), "font-size: 23px;");

        // Decrease the font size.
        mainPage.changeFontSize(mainPage.getDecreaseFontSizeButtonLocator());
        Assert.assertEquals(mainPage.getFontSizeAttribute(), "font-size: 20px;");
    }

    /**
     * Asserts that the "SET BACKGROUND COLOR" button works as expected
     */
    @Test
    void testSetBackgroundColor() {
        try {
            // Verify no color at the beginning.
            Assert.assertTrue(mainPage.getBackgroundColor().isEmpty());

            // Type "red" in the Background color text field.
            mainPage.changeBackgroundColor("red");

            // Verify that the background color is now red.
            Assert.assertEquals(mainPage.getBackgroundColor(), "background: red;");

            // Clear the Background color text field.
            mainPage.clearBackgroundColor();

            // Now change the color to blue.
            mainPage.changeBackgroundColor("blue");

            // Verify that the background color is now blue.
            Assert.assertEquals(mainPage.getBackgroundColor(), "background: blue;");
        } finally {
            mainPage.clearBackgroundColor();
        }
    }
}
