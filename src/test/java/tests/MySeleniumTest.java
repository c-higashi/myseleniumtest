package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

import pages.LoginPage;
import pages.MainPage;
import utils.ReadConfigFiles;
import utils.SeleniumAbstractTest;

public class MySeleniumTest extends SeleniumAbstractTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private ReadConfigFiles readConfigFiles;

    @BeforeMethod
    void beforeMethod()
    {
        readConfigFiles = new ReadConfigFiles();
        Properties properties = readConfigFiles.readConfigProperties("config.properties");
        driver.get( properties.getProperty("exampleweburl") );

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test
    void testDoButtons()
    {
        // Click the DO1! button.
        mainPage.clickDoButton( mainPage.getDoOneButtonLocator() );
        Assert.assertTrue(mainPage.doButtonDisabled( mainPage.getDoOneButtonLocator() ) );

        // Click the DO2! button.
        mainPage.clickDoButton( mainPage.getDoTwoLocatorLocator() );
        Assert.assertTrue(mainPage.doButtonDisabled( mainPage.getDoTwoLocatorLocator() ) );
    }

    @Test
    void testChangeFontSize()
    {
        // Verify the default font size.
        Assert.assertEquals(mainPage.getFontSizeAttribute(), "font-size: 20px;");

        // Increase the font size.
        mainPage.changeFontSize( mainPage.getIncreaseFontSizeButtonLocator() );
        Assert.assertEquals(mainPage.getFontSizeAttribute(), "font-size: 23px;");

        // Decrease the font size.
        mainPage.changeFontSize( mainPage.getDecreaseFontSizeButtonLocator() );
        Assert.assertEquals(mainPage.getFontSizeAttribute(), "font-size: 20px;");
    }

    @Test
    void testChangeColor()
    {
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
        }
        finally {
            mainPage.clearBackgroundColor();
        }
    }
}
