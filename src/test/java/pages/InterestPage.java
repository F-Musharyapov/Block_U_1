package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public WebElement activeTab;

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
    public InterestPage clickToButtonNextSectionInterests() {
        buttonNextSectionInterests.click();
        return this;
    }

    /**
     * Метод клика по кнопке xbox
     *
     * @return текущая страница
     */
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
    public InterestPage clickToButtonNextSectionPayment() {
        buttonNextSectionPayment.click();
        return this;
    }

    /**
     * Метод для передачи текста активной секции
     *
     * @return текст активной сеции
     */
    public String getActiveTabText() {
        waitUntilVisible(driver, buttonSubmit);
        return activeTab.getText();
    }

    /**
     * Метод получения текста из JSON
     *
     * @return текущая страница
     */
    public String getJsonText() {
        return textJSONWebElement.getText();
    }
}
