package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitUntilVisible;

public class FormDataProviderPage extends BasePage {

    /**
     * Конструктор создания страницы FormDataProviderPage
     *
     * @param driver драйвер для управления браузером
     */
    public FormDataProviderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локатор для поля username
     */
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    /**
     * Локатор для поля password
     */
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    /**
     * Локатор для поля usernameDescription
     */
    @FindBy(xpath = "//input[@name='formly_1_input_username_0']")
    private WebElement usernameDescription;

    /**
     * Локатор для кнопки login
     */
    @FindBy(css = "button.btn.btn-danger[ng-click=\"Auth.login()\"]\n")
    private WebElement loginButton;

    /**
     * Локатор для неактивной кнопки login с меткой disabled
     */
    @Getter
    @FindBy(css = "button.btn-danger[disabled]")
    private WebElement loginButtonDisabled;

    /**
     * Локатор для кнопки logout
     */
    @Getter
    @FindBy(css = "a[href=\"#/login\"]")
    private WebElement logout;

    /**
     * Локатор для текста успешной авторизации You're logged in!!
     */
    @Getter
    @FindBy(xpath = "//p[contains(text(), \"logged in\")]")
    private WebElement messageHappy;

    /**
     * Локатор сообщения неуспешной авторизации
     */
    @Getter
    @FindBy(xpath = "//div[text()='Username or password is incorrect']")
    private WebElement ErrorLogged;

    /**
     * Метод ввода в поле username
     *
     * @return текущая страница
     */
    @Step("Ввод {str} в поле username")
    public FormDataProviderPage inputUsername(String str) {
        waitUntilVisible(driver, username);
        username.sendKeys(str);
        return this;
    }

    /**
     * Метод ввода в поле password
     *
     * @return текущая страница
     */
    @Step("Ввод {str} в поле password")
    public FormDataProviderPage inputPassword(String str) {
        waitUntilVisible(driver, password);
        password.sendKeys(str);
        return this;
    }

    /**
     * Метод ввода в поле usernameDescription
     *
     * @return текущая страница
     */
    @Step("Ввод {str} в поле usernameDescription")
    public FormDataProviderPage inputUsernameDescription(String str) {
        usernameDescription.sendKeys(str);
        return this;
    }

    /**
     * Метод клика по кнопке Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Login")
    public FormDataProviderPage clickToButtonLogin() {
        loginButton.click();
        return this;
    }

    /**
     * Метод клика по кнопке logout
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке logout")
    public FormDataProviderPage clickLogout() {
        waitUntilVisible(driver, logout);
        logout.click();
        return this;
    }
}