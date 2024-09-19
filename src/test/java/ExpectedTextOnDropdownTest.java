import org.junit.Test;
import samokatPageObject.MainPage;

public class ExpectedTextOnDropdownTest extends BaseTest {

    @Test
    public void checkForExpectedTextOnDropdown() {
        MainPage mainPage = new MainPage(driver);
        mainPage.checkTextOnDropdown("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }
}
