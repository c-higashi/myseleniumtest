import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MySeleniumTest {

    @Test
    void testDoButtons()
    {
        final WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://yltrue.com/automation/");
            // TODO - Wait for username field appears

            // log in
            login(driver, "admin", "admin");

            // TODO - wait for the DO1 button to appear.
            WebElement doOneButton = driver.findElement(By.id("do1"));
            doOneButton.click();
            // TODO - Find a better way to get attribute "disabled"
            String doOneButtonDisabled = doOneButton.getAttribute("disabled");
            Assert.assertNotNull(doOneButtonDisabled);

            WebElement doTwoButton = driver.findElement(By.id("do2"));
            doTwoButton.click();
            String doTwoButtonDisabled = doTwoButton.getAttribute("disabled");
            Assert.assertNotNull(doTwoButtonDisabled);
        } finally {
            driver.close();
        }
    }

    @Test
    void testChangeFontSize() {
        final WebDriver driver = new ChromeDriver();
        try
        {
            driver.get("https://yltrue.com/automation/");
            // TODO - Wait for username field appears

            // log in
            login(driver, "admin", "admin");

            WebElement textFontSize = driver.findElement(By.id("textFontSize"));
            String fontSize = textFontSize.getAttribute("style");
            Assert.assertEquals(fontSize, "font-size: 20px;");

            // Increase the font size
            WebElement increaseFontSizeButton = driver.findElement(By.id("btnIncreaseFont"));
            increaseFontSizeButton.click();
            fontSize = textFontSize.getAttribute("style");
            Assert.assertEquals(fontSize, "font-size: 23px;");

            // Decrease the font size
            WebElement decreaseFontSizeButton = driver.findElement(By.id("btnDecreaseFont"));
            decreaseFontSizeButton.click();
            fontSize = textFontSize.getAttribute("style");
            Assert.assertEquals(fontSize, "font-size: 20px;");
        }
        finally {
            driver.close();
        }
    }

    private void login(WebDriver driver, String username, String password) {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
    }
}
