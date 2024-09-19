import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import samokatPageObject.MainPage;

public class ExpectedTextOnDropdownTest {

    @Test
    public void checkForExpectedTextOnDropdown() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.checkTextOnDropdown("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        driver.quit();
    }
}
