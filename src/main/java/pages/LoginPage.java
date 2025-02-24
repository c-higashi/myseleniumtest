package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void login(String username, String password) {
        WebElement usernameField = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordField = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        String welcomeMsg = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("welcomeMsg"))).getText();
        Assert.assertTrue(welcomeMsg.contains("Welcome to the Main page!"), "Log in failed!");
    }
}
