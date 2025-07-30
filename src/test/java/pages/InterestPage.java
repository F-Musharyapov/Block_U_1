package pages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.FormModel;

import static utils.Waiters.waitUntilVisible;

/**
 * Класс с методами для взаимодействия с вкладкой InterestPage
 */
public class InterestPage extends BasePage {

    /**
     * Конструктор создания страницы BasePage
     *
     * @param driver драйвер для управления браузером
     */
    public InterestPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Экземпляр преобразователя между POJO и JSON
     */
    ObjectMapper objectMapper = new ObjectMapper();

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
     * Локатор для проверки статуса вкладки
     */
    @FindBy(css = "#status-buttons a.active")
    private WebElement activeTab;

    /**
     * Локатор для кнопки Submit
     */
    @FindBy(css = "button.btn.btn-danger[type='submit']")
    private WebElement buttonSubmit;

    /**
     * Локатор для JSON текста под формой
     */
    @FindBy(css = "pre.ng-binding")
    private WebElement textJSONWebElement;

    /**
     * Метод клика по кнопке Next Section на вкладке Profile
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Next Section на вкладке Profile")
    public InterestPage clickToButtonNextSectionInterests() {
        waitUntilVisible(driver, buttonNextSectionInterests);
        buttonNextSectionInterests.click();
        return this;
    }

    /**
     * Метод клика по кнопке xbox
     *
     * @return текущая страница
     */
    @Step("Клик по radio-button xbox")
    public InterestPage clickToXbox() {
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
    public InterestPage clickToPS() {
        waitUntilVisible(driver, ps);
        ps.click();
        return this;
    }

    /**
     * Метод клика по кнопке Next Section на вкладке Interest
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Next Section на вкладке Interest")
    public InterestPage clickToButtonNextSectionPayment() {
        waitUntilVisible(driver, buttonNextSectionPayment);
        buttonNextSectionPayment.click();
        return this;
    }

    /**
     * Метод для передачи текста активной секции
     *
     * @return текст активной сеции
     */
    @Step("Передача текста активной секции")
    public String getActiveTabText() {
        waitUntilVisible(driver, buttonSubmit);
        return activeTab.getText();
    }

    /**
     * Метод для получения данных формы в виде FormModel
     *
     * @return объект FormModel с данными формы
     */
    @Step("Получение данных формы в виде FormData")
    public FormModel getFormModel() {
        try {
            return objectMapper.readValue(textJSONWebElement.getText(), FormModel.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка при десериализации JSON", e);
        }
    }
}