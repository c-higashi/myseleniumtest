package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import pages.LoginPage;
import pages.MainPage;
import utils.SeleniumAbstractTest;

public class MySeleniumTest extends SeleniumAbstractTest {

    private String url;
    private String username;
    private String password;

    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeMethod
    void beforeMethod()
    {
        readConfigProperties("config.properties");
        driver.get(url);

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        loginPage.login(username, password);
    }

    @Test
    void testDoButtons()
    {
        // Click the DO1! button.
        mainPage.clickDoOneButton();
        Assert.assertTrue(mainPage.doOneButtonDisabled());

        // Click the DO2! button.
        mainPage.clickTwoButton();
        Assert.assertTrue(mainPage.doTwoButtonDisabled());
    }

    @Test
    void testChangeFontSize()
    {
        // Verify the default font size.
        Assert.assertEquals(mainPage.getFontSizeAttribute(), "font-size: 20px;");

        // Increase the font size.
        mainPage.increaseFontSize();
        Assert.assertEquals(mainPage.getFontSizeAttribute(), "font-size: 23px;");

        // Decrease the font size.
        mainPage.decreaseFontSize();
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
        catch( NullPointerException e ) {
            logger.error( "bgColor element not found!" );
        }
        finally {
            mainPage.clearBackgroundColor();
        }
    }

    void readConfigProperties(String fileName)
    {
        Properties properties = new Properties();
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            properties.load(fis);

            url = properties.getProperty("exampleweburl");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        }
        catch (IOException e)
        {
            logger.error("Reading the Config properties file failed!");
        }
    }
}
