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
    private final By bgColorTextFieldLocator = By.id("bgColor");
    private final By btnSetBgColorLocator = By.id("btnSetBgColor");
    private final By formToColorizeLocator = By.id("formToColorize");

    public MainPage( WebDriver driver ) {
        this.driver = driver;
    }

    /**
     * Returns true if the button is disabled.
     *
     * @param doButtonLocator
     * @return
     */
    public boolean doButtonDisabled( By doButtonLocator ) {
        WebElement doButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(doButtonLocator));
        String doOneButtonDisabled = doButton.getAttribute("disabled");
        if (doOneButtonDisabled != null || !doOneButtonDisabled.trim().isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Clicks DO1! or DO2! button.
     * @param doButtonLocator
     */
    public void clickDoButton( By doButtonLocator ) {
        WebElement doButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(doButtonLocator));
        doButton.click();
    }

    public By getDoOneButtonLocator() {
        return doOneLocator;
    }

    public By getDoTwoLocatorLocator() {
        return doTwoLocator;
    }

    public String getFontSizeAttribute() {
        WebElement textFontSize = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(textFontSizeLocator));
        return textFontSize.getAttribute("style");
    }

    public void changeFontSize( By changeFontSizeButtonLocator ) {
        WebElement changeFontSizeButton = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(changeFontSizeButtonLocator));
        changeFontSizeButton.click();
    }

    public By getIncreaseFontSizeButtonLocator() {
        return increaseFontSizeButtonLocator;
    }

    public By getDecreaseFontSizeButtonLocator() {
        return decreaseFontSizeButtonLocator;
    }

    public void changeBackgroundColor( String color ) {
        WebElement bgColorTextField = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(bgColorTextFieldLocator));
        WebElement setBgColorBtn = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(btnSetBgColorLocator));

        bgColorTextField.sendKeys(color);
        setBgColorBtn.click();
    }

    public void clearBackgroundColor(){
        WebElement bgColorTextField = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(bgColorTextFieldLocator));
        WebElement setBgColorBtn = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(btnSetBgColorLocator));

        bgColorTextField.clear();
        setBgColorBtn.click();
    }

    public String getBackgroundColor() {
        WebElement formToColorize = (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(formToColorizeLocator));
        return formToColorize.getAttribute("style");
    }
}
