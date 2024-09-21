import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    private static final String MAIN_URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void open() {
        driver = new ChromeDriver();
        driver.get(MAIN_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}