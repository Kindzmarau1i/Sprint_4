package samokatPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Страница "Для кого самокат"
 */
public class OrderFormPage {

    private final WebDriver driver;

    /**
     * Заголовок страницы "Для кого самокат"
     */
    private final By header = By.xpath(".//div[text()='Для кого самокат']");

    /**
     * Input "Имя"
     */
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");

    /**
     * Input "Фамилия"
     */
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");

    /**
     * Input "Адрес"
     */
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    /**
     * Input "Станиця метро"
     */
    private final By inputSubway = By.xpath(".//input[@placeholder='* Станция метро']");

    /**
     * Input "Телефон"
     */
    private final By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    /**
     * Button "Далее"
     */
    private final By buttonNext = By.xpath(".//button[text()='Далее']");

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Подождать, пока загрузится страница
     */
    public void waitForOpened() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(header));
    }

    /**
     * Заполнить поле "Имя"
     */
    public void fillNameInput(String value) {
        driver.findElement(inputName).sendKeys(value);
    }

    /**
     * Заполнить поле "Фамилия"
     */
    public void fillSurnameInput(String value) {
        driver.findElement(inputSurname).sendKeys(value);
    }

    /**
     * Заполнить поле "Адрес: куда привети заказ"
     */
    public void fillAddressInput(String value) {
        driver.findElement(inputAddress).sendKeys(value);
    }

    /**
     * Заполнить поле "Станция метро"
     */
    public void fillSubwayInput() {
        driver.findElement(inputSubway).click();
        driver.findElement(inputSubway).sendKeys(Keys.DOWN);
        driver.findElement(inputSubway).sendKeys(Keys.ENTER);
    }

    /**
     * Заполнить поле "Телефон"
     */
    public void fillPhoneInput(String value) {
        driver.findElement(inputPhone).sendKeys(value);
    }

    /**
     * Нажать на кнопку "Далее"
     */
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    /**
     * Сценарий "Проверить точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу
     */
    public void checkSuccessOrder(String name, String surname, String address, String phone) {
        waitForOpened();
        fillNameInput(name);
        fillSurnameInput(surname);
        fillAddressInput(address);
        fillSubwayInput();
        fillPhoneInput(phone);
        clickButtonNext();
    }
}
