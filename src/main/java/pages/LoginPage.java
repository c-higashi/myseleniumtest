package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

/**
 * Represents the login page of https://yltrue.com/automation
 */
public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Performs a login using the provided username and password
     */
    public void login(String username, String password) {
        WebElement usernameField = new WebDriverWait(driver, PageUtil.WAIT_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordField = new WebDriverWait(driver, PageUtil.WAIT_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        String welcomeMsg = new WebDriverWait(driver, PageUtil.WAIT_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("welcomeMsg"))).getText();
        Assert.assertTrue(welcomeMsg.contains("Welcome to the Main page!"), "Log in failed!");
    }
}
