package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForAlert;
import static utils.Waiters.waitUntilVisible;

/**
 * Класс с методами для взаимодействия с вкладкой PaymentPage
 */
public class PaymentPage extends BasePage {

    /**
     * Конструктор создания страницы BasePage
     *
     * @param driver драйвер для управления браузером
     */
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Константа текста всплывающего окна успеха
     */
    public static final String ALERT_TEXT = "awesome!";

    /**
     * Локатор для кнопки Submit
     */
    @FindBy(css = "button.btn.btn-danger[type='submit']")
    private WebElement buttonSubmit;

    /**
     * Локатор для кнопки Next Section на вкладке Interests
     */
    @FindBy(css = "a[ui-sref='form.payment']")
    private WebElement buttonNextSectionPayment;

    /**
     * Локатор для кнопки Next Section на вкладке Profile
     */
    @FindBy(css = "a[ui-sref='form.interests']")
    private WebElement buttonNextSectionInterests;

    /**
     * Локатор с полем ввода name
     */
    @FindBy(css = "input[name='name']")
    private WebElement name;

    /**
     * Локатор с полем ввода email
     */
    @FindBy(css = "input[name='email']")
    private WebElement email;

    /**
     * Локатор для radio-button xbox
     */
    @FindBy(xpath = "//input[@value='xbox']")
    private WebElement xbox;

    /**
     * Локатор для radio-button ps4
     */
    @FindBy(xpath = "//input[@value='ps']")
    private WebElement ps;

    /**
     * Метод клика по кнопке Next Section на вкладке Profile
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Next Section на вкладке Profile")
    public PaymentPage clickToButtonNextSectionInterests() {
        buttonNextSectionInterests.click();
        return this;
    }

    /**
     * Метод клика по кнопке Next Section на вкладке Interest
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Next Section на вкладке Interest")
    public PaymentPage clickToButtonNextSectionPayment() {
        buttonNextSectionPayment.click();
        return this;
    }

    /**
     * Метод клика по кнопке Submit на вкладке Payment
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Submit на вкладке Payment")
    public PaymentPage clickToButtonSubmit() {
        waitUntilVisible(driver, buttonSubmit);
        buttonSubmit.click();
        return this;
    }

    /**
     * Метод ввода в поле name
     *
     * @return текущая страница
     */
    @Step("Ввод {str} в поле name")
    public PaymentPage inputName(String str) {
        waitUntilVisible(driver, name);
        name.sendKeys(str);
        return this;
    }

    /**
     * Метод ввода в поле email
     *
     * @return текущая страница
     */
    @Step("Ввод {str} в поле email")
    public PaymentPage inputEmail(String str) {
        waitUntilVisible(driver, email);
        email.sendKeys(str);
        return this;
    }

    /**
     * Метод клика по кнопке xbox
     *
     * @return текущая страница
     */
    @Step("Клик по radio-button xbox")
    public PaymentPage clickToXbox() {
        waitUntilVisible(driver, xbox);
        xbox.click();
        return this;
    }

    /**
     * Метод клика по кнопке ps4
     *
     * @return текущая страница
     */
    @Step("Клик по radio-button ps4")
    public PaymentPage clickToPS() {
        waitUntilVisible(driver, ps);
        ps.click();
        return this;
    }

    /**
     * Метод извлечения текста алерта
     *
     * @return извлеченный текст
     */
    public String getAlertText() {
        waitForAlert(driver);
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    /**
     * Метод закрытия алерта
     */
    @Step("Закрытие алерта")
    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (IllegalStateException e) {
            throw new RuntimeException("Нет активного алерта.", e);
        }
    }
}