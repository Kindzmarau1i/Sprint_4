package samokatPageObject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Главная страница сервиса
 */
public class MainPage {

    private final WebDriver driver;

    /**
     * Главная страница сервиса
     */
    private final By mainPage = By.className("Home_HomePage__ZXKIX");

    /**
     * Button "Заказать" (сверху)
     */
    private final By buttonOrderTop = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");

    /**
     * Button "Заказать" (снизу)
     */
    private final By buttonOrderBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    /**
     * Div "Сколько это стоит? И как оплатить?"
     */
    private final By divHowMuch = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");

    /**
     * Text "Текст внутри первого выпадающего списка"
     */
    private final By divHowMuchText = By.xpath(".//div[@aria-labelledby='accordion__heading-0']/p");

    /**
     * Button "да все привыкли"
     */
    private final By buttonAcceptCookie = By.xpath(".//button[text()='да все привыкли']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Подождать, пока загрузится главная страница
     */
    public void waitForOpened() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(mainPage));
    }

    /**
     * Раскрыть выпадающий список
     */
    public void clickDropdown() {
        driver.findElement(divHowMuch).click();
    }

    /**
     * Проверить, что в раскрывшемся списке отображается соответствующий текст
     */
    public void verifyDropdownText(String expectedText) {
        // / Необходима задержка, чтобы получить текст из локатора. Без задержки текст не успевает сохраниться
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text = driver.findElement(divHowMuchText).getText();
        MatcherAssert.assertThat(text, equalTo(expectedText));
    }

    /**
     * Нажать на кнопку "Заказать"
     */
    public void clickButtonOrder(String var) {
        if (var.equals("Верх")) {
            driver.findElement(buttonOrderTop).click();
        } else {
            driver.findElement(buttonOrderBottom).click();
        }
    }

    /**
     * Нажать на кнопку "да все привыкли"
     */
    public void clickButtonAcceptCookie() {
        driver.findElement(buttonAcceptCookie).click();
    }

    /**
     * Сценарий "Проверить: когда нажимаешь на стрелочку, открывается соответствующий текст"
     */
    public void checkTextOnDropdown(String expectedText) {
        waitForOpened();
        clickButtonAcceptCookie();
        clickDropdown();
        verifyDropdownText(expectedText);
    }

    /**
     * Сценарий "Проверить точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу
     */
    public void checkSuccessOrder(String button) {
        waitForOpened();
        clickButtonAcceptCookie();
        clickButtonOrder(button);
    }
}
