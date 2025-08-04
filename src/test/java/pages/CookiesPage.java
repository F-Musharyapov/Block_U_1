package pages;

import config.BaseConfig;
import io.qameta.allure.Step;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.*;
import java.util.Set;

import static utils.Waiters.waitUntilVisible;

/**
 * Класс с методами для взаимодействия с Cookies на sql-ex
 */
public class CookiesPage extends BasePage {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Конструктор создания страницы CookiesPage
     *
     * @param driver драйвер для управления браузером
     */
    public CookiesPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локатор для поля login
     */
    @FindBy(css = "input[type='text'][name='login']")
    private WebElement login;

    /**
     * Локатор для поля password
     */
    @FindBy(css = "input[type='password'][name='psw']")
    private WebElement password;

    /**
     * Локатор для кнопки submitButton
     */
    @FindBy(css = "input[name='subm1']")
    private WebElement submitButton;

    /**
     * Локатор для кнопки submitButton
     */
    @Getter
    @FindBy(css = "a[href='/logout.php']")
    private WebElement logoutButton;

    /**
     * Локатор для ссылки personLink
     */
    @FindBy(xpath = "//a[@href=\"/personal.php\" and text()=\"Персональная страница\"]")
    private WebElement personLink;

    /**
     * Метод ввода в поле login
     *
     * @return текущая страница
     */
    @Step("Ввод {str} в поле login")
    public CookiesPage inputLogin(String str) {
        login.sendKeys(str);
        return this;
    }

    /**
     * Метод ввода в поле password
     *
     * @return текущая страница
     */
    @Step("Ввод {str} в поле password")
    public CookiesPage inputPassword(String str) {
        password.sendKeys(str);
        return this;
    }

    /**
     * Метод клика по кнопке submitButton
     *
     * @return текущая страница
     */
    @Step("Клик на кнопку submitButton")
    public CookiesPage clickToSubmitButton() {
        waitUntilVisible(driver, submitButton);
        submitButton.click();
        return this;
    }

    /**
     * Метод клика по кнопке submitButton
     *
     * @return текущая страница
     */
    @Step("Клик на кнопку logoutButton")
    public CookiesPage clickToLogoutButton() {
        waitUntilVisible(driver, logoutButton);
        logoutButton.click();
        return this;
    }

    /**
     * Метод клика по ссылке personLink
     *
     * @return текущая страница
     */
    @Step("Клик по ссылке personLink")
    public CookiesPage clickToPersonLink() {
        waitUntilVisible(driver, personLink);
        personLink.click();
        return this;
    }

    /**
     * Метод для записи всех cookie в файл
     *
     * @param cookies объекты из коллекции
     */
    @Step("Запись всех cookie в файл")
    public void writeAllCookie(Set<Cookie> cookies) {

        File cookieFile = new File(config.fileCookiesAdress());

        try (FileWriter writer = new FileWriter(cookieFile)) {
            for (Cookie cookie : cookies) {
                writer.write(cookie.getName() + "=" + cookie.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для использования всех cookie из файла
     *
     * @param file с cookies
     */
    @Step("Использование всех cookie из файла")
    public void readAllCookie(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String name = parts[0];
                    String value = parts[1];
                    driver.manage().addCookie(new Cookie(name, value));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод снятия фокуса с поля login
     *
     * @return текущая страница
     */
    @Step("Снятие фокуса с поля login")
    public void removFocusInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.activeElement.blur();");
    }

    /**
     * Метод для понимания наличия фокуса на элементе
     *
     * @return true если фокус есть
     */
    @Step("Проверка наличия фокуса на элементе")
    public String reviewFocusInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String activeTag = (String) js.executeScript("return document.activeElement.tagName;");
        return activeTag;
    }

    /**
     * Метод для понимания наличия скролла
     *
     * @return true если скроллбар скроллится
     */
    @Step("Проверка наличия скролла")
    public boolean reviewScrollBar() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
    }
}