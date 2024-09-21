package samokatPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Страница "Про аренду"
 */
public class OrderFormRentPage {

    private final WebDriver driver;

    /**
     * Заголовок страницы "Про аренду"
     */
    private final By header = By.xpath(".//div[text()='Про аренду']");

    /**
     * Input "Когда привезти самокат"
     */
    private final By inputDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    /**
     * Dropdown "Срок аренды"
     */
    private final By dropdownRentPeriod = By.xpath(".//div[text()='* Срок аренды']");

    /**
     * Div "Сутки"
     */
    private final By dayPeriod = By.xpath(".//div[text()='сутки']");

    /**
     * Checkbox "Черный жемчуг"
     */
    private final By checkbox = By.xpath(".//label[@for='black']");

    /**
     * Input "Комментарий для курьера"
     */
    private final By inputNote = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    /**
     * Button "Заказать"
     */
    private final By buttonOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public OrderFormRentPage(WebDriver driver) {
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
     * Заполнить поле "Когда привезти самокат"
     */
    public void fillDateInput(String date) {
        driver.findElement(inputDate).sendKeys(date);
        driver.findElement(inputDate).sendKeys(Keys.ENTER);
    }

    /**
     * Заполнить поле "Срок аренды"
     */
    public void fillRentPeriodDropdown() {
        driver.findElement(dropdownRentPeriod).click();
        driver.findElement(dayPeriod).click();
    }

    /**
     * Нажать на чекбокс "Черный жемчуг"
     */
    public void clickBlackCheckbox() {
        driver.findElement(checkbox).click();
    }

    /**
     * Заполнить поле "Комментарий"
     */
    public void fillNote(String note) {
        driver.findElement(inputNote).sendKeys(note);
    }

    /**
     * Нажать на кнопку "Заказать"
     */
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    /**
     * Сценарий "Проверить точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу
     */
    public void checkSuccessOrder(String date, String note) {
        waitForOpened();
        fillDateInput(date);
        fillRentPeriodDropdown();
        clickBlackCheckbox();
        fillNote(note);
        clickButtonOrder();
    }
}
