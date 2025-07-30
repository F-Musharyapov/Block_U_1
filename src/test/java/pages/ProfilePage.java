package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitUntilVisible;

/**
 * Класс с методами для взаимодействия с вкладкой ProfilePage
 */
public class ProfilePage extends BasePage {

    /**
     * Конструктор создания страницы BasePage
     *
     * @param driver драйвер для управления браузером
     */
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Константа названия вкладки PAYMENT
     */
    public static final String INTERESTS_TAB_NAME = "INTERESTS";

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
     * Локатор для проверки появления второй вкладки по классу текста
     */
    @FindBy(css = "label.ng-scope")
    public WebElement textTabTwo;

    /**
     * Метод ввода в поле name
     *
     * @return текущая страница
     */
    @Step("Ввод {str} в поле name")
    public ProfilePage inputName(String str) {
        name.sendKeys(str);
        return this;
    }

    /**
     * Метод ввода в поле email
     *
     * @return текущая страница
     */
    @Step("Ввод {str} в поле email")
    public ProfilePage inputEmail(String str) {
        email.sendKeys(str);
        return this;
    }

    /**
     * Метод клика по кнопке Next Section на вкладке Profile
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Next Section на вкладке Profile")
    public ProfilePage clickToButtonNextSectionInterests() {
        buttonNextSectionInterests.click();
        return this;
    }

    /**
     * Метод передачи текста активной секции
     *
     * @return текст активной сеции
     */
    public String getActiveTabText() {
        waitUntilVisible(driver, textTabTwo);
        return activeTab.getText();
    }
}