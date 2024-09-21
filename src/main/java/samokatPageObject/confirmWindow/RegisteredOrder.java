package samokatPageObject.confirmWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Окно "Заказ оформлен"
 */
public class RegisteredOrder {

    private final WebDriver driver;

    /**
     * Header "Заказ оформлен"
     */
    private final By header = By.xpath(".//div[text()='Заказ оформлен']");

    /**
     * Button "Посмотреть статус"
     */
    private final By buttonCheckStatus = By.xpath(".//button[text()='Посмотреть статус']");

    public RegisteredOrder(WebDriver driver) {
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
     * Нажать на кнопку "Посмотреть статус"
     */
    public void clickButtonCheckStatus() {
        driver.findElement(buttonCheckStatus).click();
    }

    /**
     * Сценарий "Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа"
     */
    public Boolean checkSuccessOrderWindow() {
        waitForOpened();
        return driver.findElement(header).isDisplayed();
    }
}
