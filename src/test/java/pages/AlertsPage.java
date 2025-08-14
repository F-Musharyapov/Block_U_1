package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.TestData.ALERT_INPUT;
import static utils.Waiters.waitForAlert;
import static utils.Waiters.waitUntilVisible;

/**
 * Класс с методами для взаимодействия со страницей Alert
 */
public class AlertsPage extends BasePage {

    /**
     * Конструктор создания страницы AlertsPage
     *
     * @param driver драйвер для управления браузером
     */
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локатор для таба Input Alert
     */
    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[1]/div[1]/div[1]/ul/li[2]/a")
    private WebElement tabInputAlert;

    /**
     * Локатор для iframe
     */
    @FindBy(xpath = "//*[@id=\"example-1-tab-2\"]/div/iframe")
    private WebElement iframe;

    /**
     * Локатор для кнопки вызова Alert
     */
    @FindBy(xpath = "/html/body/button")
    private WebElement buttonAlert;

    /**
     * Локатор для поля с текстом
     */
    @Getter
    @FindBy(xpath = "//*[@id=\"demo\"]")
    private WebElement textField;

    /**
     * Метод для клика по кнопке таба Input Alert
     *
     * @return текущая страница
     */
    @Step("Клика по кнопке таба Input Alert")
    public AlertsPage clikTabInputAlert() {
        waitUntilVisible(driver, tabInputAlert);
        tabInputAlert.click();
        return this;
    }

    /**
     * Метод переключения на iframe
     *
     * @return текущая страница
     */
    @Step("Переключение на iframe")
    public AlertsPage switchToIframe() {
        waitUntilVisible(driver, iframe);
        driver.switchTo().frame(iframe);
        return this;
    }

    /**
     * Метод для клика по кнопке вызова alert
     * @return текущая страница
     */
    @Step("Клик по кнопке вызова alert")
    public AlertsPage clikButtonAlert() {
        waitUntilVisible(driver, buttonAlert);
        buttonAlert.click();
        return this;
    }

    /**
     * Метод переключения на alert
     *
     * @return текущая страница
     */
    @Step("Переключение на alert")
    public AlertsPage switchToAlert() {
        waitForAlert(driver);
        driver.switchTo().alert();
        return this;
    }

    /**
     * Метод ввода текста в поле alert
     *
     * @return текущая страница
     */
    @Step("Ввод текста в поле alert")
    public AlertsPage inputDataToAlert() {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(ALERT_INPUT);
        return this;
    }

    /**
     * Метод закрытия окна alert
     *
     * @return текущая страница
     */
    @Step("Закрытие окна alert")
    public AlertsPage outAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
}