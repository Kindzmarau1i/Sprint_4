package samokatPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import samokatPageObject.constants.QuestionsAndResponses;

import java.time.Duration;

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
     * Div "Вопросы о важном"
     */
    private final By divQuestions = By.xpath(".//div[@class='Home_FourPart__1uthg']");

    /**
     * Div "Сколько это стоит? И как оплатить?"
     */
    private final By divHowMuch = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");

    /**
     * Text "Текст внутри блока 'Сколько это стоит? И как оплатить?'"
     */
    private final By divHowMuchText = By.xpath(".//div[@aria-labelledby='accordion__heading-0']/p");

    /**
     * Div "Хочу сразу несколько самокатов! Так можно?"
     */
    private final By divSeveralScooters = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");

    /**
     * Text "Текст внутри блока 'Хочу сразу несколько самокатов! Так можно?'"
     */
    private final By divSeveralScootersText = By.xpath(".//div[@aria-labelledby='accordion__heading-1']/p");

    /**
     * Div "Как рассчитывается время аренды?"
     */
    private final By divRentalTime = By.xpath(".//div[text()='Как рассчитывается время аренды?']");

    /**
     * Text "Текст внутри блока 'Как рассчитывается время аренды?'"
     */
    private final By divRentalTimeText = By.xpath(".//div[@aria-labelledby='accordion__heading-2']/p");

    /**
     * Div "Можно ли заказать самокат прямо на сегодня?"
     */
    private final By divOrderForToday = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");

    /**
     * Text "Текст внутри блока 'Можно ли заказать самокат прямо на сегодня?'"
     */
    private final By divOrderForTodayText = By.xpath(".//div[@aria-labelledby='accordion__heading-3']/p");

    /**
     * Div "Можно ли продлить заказ или вернуть самокат раньше?"
     */
    private final By divExtendOrder = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");

    /**
     * Text "Текст внутри блока 'Можно ли продлить заказ или вернуть самокат раньше?'"
     */
    private final By divExtendOrderText = By.xpath(".//div[@aria-labelledby='accordion__heading-4']/p");

    /**
     * Div "Вы привозите зарядку вместе с самокатом?"
     */
    private final By divCharging = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");

    /**
     * Text "Текст внутри блока 'Вы привозите зарядку вместе с самокатом?'"
     */
    private final By divChargingText = By.xpath(".//div[@aria-labelledby='accordion__heading-5']/p");

    /**
     * Div "Можно ли отменить заказ?"
     */
    private final By divCancelOrder = By.xpath(".//div[text()='Можно ли отменить заказ?']");

    /**
     * Text "Текст внутри блока 'Можно ли отменить заказ?'"
     */
    private final By divCancelOrderText = By.xpath(".//div[@aria-labelledby='accordion__heading-6']/p");

    /**
     * Div "Я жизу за МКАДом, привезёте?"
     */
    private final By divMKAD = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");

    /**
     * Text "Текст внутри блока 'Я жизу за МКАДом, привезёте?'"
     */
    private final By divMKADText = By.xpath(".//div[@aria-labelledby='accordion__heading-7']/p");

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
    public void clickDropdown(String divQuestion) {
        switch (divQuestion) {
            case QuestionsAndResponses.HOW_MUCH:
                driver.findElement(divHowMuch).click();
                break;
            case QuestionsAndResponses.SEVERAL_SCOOTERS:
                driver.findElement(divSeveralScooters).click();
                break;
            case QuestionsAndResponses.RENTAL_TIME:
                driver.findElement(divRentalTime).click();
                break;
            case QuestionsAndResponses.ORDER_FOR_TODAY:
                driver.findElement(divOrderForToday).click();
                break;
            case QuestionsAndResponses.EXTEND_ORDER:
                driver.findElement(divExtendOrder).click();
                break;
            case QuestionsAndResponses.CHARGING:
                driver.findElement(divCharging).click();
                break;
            case QuestionsAndResponses.CANCEL_ORDER:
                driver.findElement(divCancelOrder).click();
                break;
            case QuestionsAndResponses.MKAD:
                driver.findElement(divMKAD).click();
                break;
        }
    }

    /**
     * Проверить, что в раскрывшемся списке отображается соответствующий текст
     */
    public String verifyDropdownText(String divQuestion) {
        // / Необходима задержка, чтобы получить текст из локатора. Без задержки текст не успевает сохраниться
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(divQuestions));
        return switch (divQuestion) {
            case QuestionsAndResponses.HOW_MUCH -> driver.findElement(divHowMuchText).getText();
            case QuestionsAndResponses.SEVERAL_SCOOTERS -> driver.findElement(divSeveralScootersText).getText();
            case QuestionsAndResponses.RENTAL_TIME -> driver.findElement(divRentalTimeText).getText();
            case QuestionsAndResponses.ORDER_FOR_TODAY -> driver.findElement(divOrderForTodayText).getText();
            case QuestionsAndResponses.EXTEND_ORDER -> driver.findElement(divExtendOrderText).getText();
            case QuestionsAndResponses.CHARGING -> driver.findElement(divChargingText).getText();
            case QuestionsAndResponses.CANCEL_ORDER -> driver.findElement(divCancelOrderText).getText();
            case QuestionsAndResponses.MKAD -> driver.findElement(divMKADText).getText();
            default -> divQuestion;
        };
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
    public String checkTextOnDropdown(String divQuestion) {
        waitForOpened();
        clickButtonAcceptCookie();
        clickDropdown(divQuestion);
        return verifyDropdownText(divQuestion);
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
