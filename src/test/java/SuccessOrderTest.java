import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import samokatPageObject.MainPage;
import samokatPageObject.OrderFormPage;
import samokatPageObject.OrderFormRentPage;
import samokatPageObject.confirmWindow.ApproveOrder;
import samokatPageObject.confirmWindow.RegisteredOrder;

@RunWith(Parameterized.class)
public class SuccessOrderTest {
    private final String buttonOrder;

    public SuccessOrderTest(String buttonOrder) {
        this.buttonOrder = buttonOrder;
    }

    @Parameterized.Parameters
    public static Object[] getButtonOrder() {
        return new Object[] {"Верх", "Низ"};
    }

    @Test
    public void checkForSuccessOrder() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        OrderFormRentPage orderFormRentPage = new OrderFormRentPage(driver);
        ApproveOrder approveOrder = new ApproveOrder(driver);
        RegisteredOrder registeredOrder = new RegisteredOrder(driver);

        mainPage.checkSuccessOrder(buttonOrder);
        orderFormPage.checkSuccessOrder("Руслан", "Николаев", "г.Москва, ул.Тверская, д.75, п.3", "89179375481");
        orderFormRentPage.checkSuccessOrder("18.09.2024", "Без комментария");
        approveOrder.clickButtonYes();
        registeredOrder.checkSuccessOrderWindow();
        driver.quit();
    }
}
