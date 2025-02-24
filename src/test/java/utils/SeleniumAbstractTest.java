package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    /**
     * Closes this class's driver.
     */
    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
