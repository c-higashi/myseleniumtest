package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private final By doOne = By.id("do1");
    private final By doTwo = By.id("do2");


    public MainPage( WebDriver driver ) {
        this.driver = driver;
    }

    public void clickDoOneButton() {
        WebElement doOneButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(doOne));
        doOneButton.click();
    }

    public boolean doOneButtonDisabled() {
        WebElement doOneButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(doOne));
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
                .until(ExpectedConditions.visibilityOfElementLocated(doTwo));
        doOneButton.click();
    }

    public boolean doTwoButtonDisabled() {
        WebElement doOneButton = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOfElementLocated(doTwo));
        String doOneButtonDisabled = doOneButton.getAttribute("disabled");
        if (doOneButtonDisabled != null || !doOneButtonDisabled.trim().isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

}
