package samokatPageObject.confirmWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Окно "Хотите оформить заказ?"
 */
public class ApproveOrder {

    private final WebDriver driver;

    /**
     * Header "Хотите оформить заказ?"
     */
    private final By header = By.xpath(".//div[text()='Хотите оформить заказ?']");

    /**
     * Button "Да"
     */
    private final By buttonYes = By.xpath(".//button[text()='Да']");

    /**
     * Button "Нет"
     */
    private final By buttonNo = By.xpath(".//button[text()='Нет']");

    public ApproveOrder(WebDriver driver) {
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
     * Нажать на кнопку "Да"
     */
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    /**
     * Нажать на кнопку "Нет"
     */
    public void clickButtonNo() {
        driver.findElement(buttonNo).click();
    }
}
