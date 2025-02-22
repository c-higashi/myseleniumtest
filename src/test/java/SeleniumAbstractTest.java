import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class SeleniumAbstractTest {

    protected WebDriver driver;

    @BeforeClass
    void beforeClass() {
        driver = new ChromeDriver();
    }

    @AfterClass
    void afterClass() {
        driver.close();
    }
}
