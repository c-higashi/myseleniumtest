import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MySeleniumTest {

    private WebDriver driver;

    @BeforeClass
    void beforeClass() {
        driver = new ChromeDriver();
    }

    @AfterClass
    void afterClass() {
        driver.close();
    }

    @Test
    void testDoButtons()
    {
        driver.get("https://yltrue.com/automation/");

        // log in
        login("admin", "admin");

        // Click the DO1! button.
        WebElement doOneButton = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("do1")));
        doOneButton.click();

        // TODO - Find a better way to get attribute "disabled"
        String doOneButtonDisabled = doOneButton.getAttribute("disabled");
        Assert.assertNotNull(doOneButtonDisabled);

        // Click the DO2! button.
        WebElement doTwoButton = driver.findElement(By.id("do2"));
        doTwoButton.click();
        String doTwoButtonDisabled = doTwoButton.getAttribute("disabled");
        Assert.assertNotNull(doTwoButtonDisabled);
    }

    @Test
    void testChangeFontSize()
    {
        driver.get("https://yltrue.com/automation/");
        // log in
        login("admin", "admin");

        // Verify the default font size.
        WebElement textFontSize = driver.findElement(By.id("textFontSize"));
        String fontSize = textFontSize.getAttribute("style");
        Assert.assertEquals(fontSize, "font-size: 20px;");

        // Increase the font size.
        WebElement increaseFontSizeButton = driver.findElement(By.id("btnIncreaseFont"));
        increaseFontSizeButton.click();
        fontSize = textFontSize.getAttribute("style");
        Assert.assertEquals(fontSize, "font-size: 23px;");

        // Decrease the font size.
        WebElement decreaseFontSizeButton = driver.findElement(By.id("btnDecreaseFont"));
        decreaseFontSizeButton.click();
        fontSize = textFontSize.getAttribute("style");
        Assert.assertEquals(fontSize, "font-size: 20px;");
    }

    @Test
    void testChangeColor()
    {
        driver.get("https://yltrue.com/automation/");
        // log in
        login("admin", "admin");

        WebElement formToColorize = driver.findElement(By.id("formToColorize"));
        String bgColor = formToColorize.getAttribute("style");
        Assert.assertTrue(bgColor.isEmpty());

        // Type "red" in the Background color text field.
        WebElement bgColorTextField = driver.findElement(By.id("bgColor"));
        WebElement setBgColorBtn = driver.findElement(By.id("btnSetBgColor"));
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

        bgColorTextField.clear();
        setBgColorBtn.click();
    }

    private void login(String username, String password) {
        WebElement usernameField = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordField = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        String welcomeMsg = driver.findElement(By.id("welcomeMsg")).getText();
        Assert.assertTrue(welcomeMsg.contains("Welcome to the Main page!"), "Log in failed!");
    }
}
