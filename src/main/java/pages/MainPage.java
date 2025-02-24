package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Represents the main page of https://yltrue.com/automation that is rendered after the user logs in.
 *
 * @see LoginPage
 */
public class MainPage {
    private final WebDriver driver;
    private final By doOneLocator = By.id("do1");
    private final By doTwoLocator = By.id("do2");
    private final By textFontSizeLocator = By.id("textFontSize");
    private final By increaseFontSizeButtonLocator = By.id("btnIncreaseFont");
    private final By decreaseFontSizeButtonLocator = By.id("btnDecreaseFont");
    private final By bgColorTextFieldLocator = By.id("bgColor");
    private final By btnSetBgColorLocator = By.id("btnSetBgColor");
    private final By formToColorizeLocator = By.id("formToColorize");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns true if a "DO" button (e.g. DO1! or DO2!) represented by the provided locator is disabled
     *
     * @see #getDoOneButtonLocator()
     * @see #getDoTwoButtonLocator()
     */
    public boolean doButtonDisabled(By doButtonLocator) {
        WebElement doButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(doButtonLocator));
        String doOneButtonDisabled = doButton.getAttribute("disabled");
        return doOneButtonDisabled != null && !doOneButtonDisabled.trim().isEmpty();
    }

    /**
     * Clicks the "DO" button (e.g. DO1! or DO2!) represented by the provided locator
     *
     * @see #getDoOneButtonLocator()
     * @see #getDoTwoButtonLocator()
     */
    public void clickDoButton(By doButtonLocator) {
        WebElement doButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(doButtonLocator));
        doButton.click();
    }

    /**
     * Returns the locator for the DO1! button
     */
    public By getDoOneButtonLocator() {
        return doOneLocator;
    }

    /**
     * Returns the locator for the DO2! button
     */
    public By getDoTwoButtonLocator() {
        return doTwoLocator;
    }

    /**
     * Returns the font size of the element affected by the font size buttons.
     */
    public String getFontSizeAttribute() {
        WebElement textFontSize = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(textFontSizeLocator));
        return textFontSize.getAttribute("style");
    }

    /**
     * Changes the font size based on the provided increase or decrease button locator
     *
     * @see #getIncreaseFontSizeButtonLocator()
     * @see #getDecreaseFontSizeButtonLocator()
     */
    public void changeFontSize(By changeFontSizeButtonLocator) {
        WebElement changeFontSizeButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(changeFontSizeButtonLocator));
        changeFontSizeButton.click();
    }

    /**
     * Returns the locator for the button that increases the font size
     */
    public By getIncreaseFontSizeButtonLocator() {
        return increaseFontSizeButtonLocator;
    }

    /**
     * Returns the locator for the button that decreases the font size
     */
    public By getDecreaseFontSizeButtonLocator() {
        return decreaseFontSizeButtonLocator;
    }

    /**
     * Sets the "SET BACKGROUND COLOR" form to the provided color.
     */
    public void changeBackgroundColor(String color) {
        WebElement bgColorTextField = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(bgColorTextFieldLocator));
        WebElement setBgColorBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(btnSetBgColorLocator));

        bgColorTextField.sendKeys(color);
        setBgColorBtn.click();
    }

    /**
     * Clears the background color of the "SET BACKGROUND COLOR" form.
     */
    public void clearBackgroundColor() {
        WebElement bgColorTextField = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(bgColorTextFieldLocator));
        WebElement setBgColorBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(btnSetBgColorLocator));

        bgColorTextField.clear();
        setBgColorBtn.click();
    }

    /**
     * Returns the background color of the "SET BACKGROUND COLOR" form.
     */
    public String getBackgroundColor() {
        WebElement formToColorize = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(formToColorizeLocator));
        return formToColorize.getAttribute("style");
    }
}
