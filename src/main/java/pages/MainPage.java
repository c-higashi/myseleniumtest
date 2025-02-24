package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private final By doOneLocator = By.id("do1");
    private final By doTwoLocator = By.id("do2");
    private final By textFontSizeLocator = By.id("textFontSize");
    private final By increaseFontSizeButtonLocator = By.id("btnIncreaseFont");
    private final By decreaseFontSizeButtonLocator = By.id("btnDecreaseFont");


    public MainPage( WebDriver driver ) {
        this.driver = driver;
    }

    public void clickDoOneButton() {
        WebElement doOneButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(doOneLocator));
        doOneButton.click();
    }

    public boolean doOneButtonDisabled() {
        WebElement doOneButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(doOneLocator));
        String doOneButtonDisabled = doOneButton.getAttribute("disabled");
        if (doOneButtonDisabled != null || !doOneButtonDisabled.trim().isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void clickTwoButton() {
        WebElement doOneButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(doTwoLocator));
        doOneButton.click();
    }

    public boolean doTwoButtonDisabled() {
        WebElement doOneButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(doTwoLocator));
        String doOneButtonDisabled = doOneButton.getAttribute("disabled");
        if (doOneButtonDisabled != null || !doOneButtonDisabled.trim().isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getFontSizeAttribute() {
        WebElement textFontSize = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(textFontSizeLocator));
        return textFontSize.getAttribute("style");
    }

    public void increaseFontSize() {
        WebElement increaseFontSizeButton = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(increaseFontSizeButtonLocator));
        increaseFontSizeButton.click();
    }

    public void decreaseFontSize() {
        WebElement decreaseFontSizeButton = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(decreaseFontSizeButtonLocator));
        decreaseFontSizeButton.click();
    }

}
