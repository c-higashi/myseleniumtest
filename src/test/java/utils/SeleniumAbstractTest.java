package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Base cass for Selenium-based UI Automation tests
 */
public abstract class SeleniumAbstractTest {

    /**
     * WebDriver that can be used by the implementing class's tests.
     */
    protected WebDriver driver;

    /**
     * Initializes this class's driver.
     */
    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
    }

    /**
     * Closes this class's driver.
     */
    @AfterSuite
    public void afterSuite() {
        driver.close();
    }
}
