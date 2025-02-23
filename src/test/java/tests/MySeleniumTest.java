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
import utils.SeleniumAbstractTest;

public class MySeleniumTest extends SeleniumAbstractTest {

    private String url;
    private String username;
    private String password;

    private LoginPage loginPage;

    @BeforeMethod
    void beforeMethod()
    {
        logger.debug("beforeMethod()");
        logger.info("beforeMethod()");
        logger.warn("beforeMethod()");
        logger.error("beforeMethod()");
        readConfigProperties("config.properties");
        driver.get(url);

        loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    @Test
    void testDoButtons()
    {
        // Click the DO1! button.
        WebElement doOneButton = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("do1")));
        doOneButton.click();

        String doOneButtonDisabled = doOneButton.getAttribute("disabled");
        Assert.assertNotNull(doOneButtonDisabled);

        // Click the DO2! button.
        WebElement doTwoButton = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("do2")));
        doTwoButton.click();
        String doTwoButtonDisabled = doTwoButton.getAttribute("disabled");
        Assert.assertNotNull(doTwoButtonDisabled);
    }

    @Test
    void testChangeFontSize()
    {
        // Verify the default font size.
        WebElement textFontSize = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("textFontSize")));
        String fontSize = textFontSize.getAttribute("style");
        Assert.assertEquals(fontSize, "font-size: 20px;");

        // Increase the font size.
        WebElement increaseFontSizeButton = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("btnIncreaseFont")));
        increaseFontSizeButton.click();
        fontSize = textFontSize.getAttribute("style");
        Assert.assertEquals(fontSize, "font-size: 23px;");

        // Decrease the font size.
        WebElement decreaseFontSizeButton = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("btnDecreaseFont")));
        decreaseFontSizeButton.click();
        fontSize = textFontSize.getAttribute("style");
        Assert.assertEquals(fontSize, "font-size: 20px;");
    }

    @Test
    void testChangeColor()
    {
        WebElement bgColorTextField = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("bgColor")));
        WebElement setBgColorBtn = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSetBgColor")));
        try {
            WebElement formToColorize = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("formToColorize")));
            String bgColor = formToColorize.getAttribute("style");
            Assert.assertTrue(bgColor.isEmpty());

            // Type "red" in the Background color text field.
            bgColorTextField.sendKeys("red");
            setBgColorBtn.click();

            // Verify that the background color is now red.
            bgColor = formToColorize.getAttribute("style");
            Assert.assertEquals(bgColor, "background: red;");

            // Clear the Background color text field.
            bgColorTextField.clear();
            setBgColorBtn.click();

            // Now change the color to blue.
            bgColorTextField.sendKeys("blue");
            setBgColorBtn.click();

            // Verify that the background color is now blue.
            bgColor = formToColorize.getAttribute("style");
            Assert.assertEquals(bgColor, "background: blue;");
        }
        finally {
            bgColorTextField.clear();
            setBgColorBtn.click();
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
