package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class SeleniumAbstractTest {

    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
