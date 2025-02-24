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
    
    public boolean doButtonDisabled( By doButtonLocator ) {
        WebElement doOneButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(doButtonLocator));
        String doOneButtonDisabled = doOneButton.getAttribute("disabled");
        if (doOneButtonDisabled != null || !doOneButtonDisabled.trim().isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

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
