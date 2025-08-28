package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static utils.Waiters.waitUntilVisible;

/**
 * Класс с методами для взаимодействия со страницей SampleForm
 */
public class BankingSampleFormPage extends BasePage {

    /**
     * Конструктор создания страницы BankingSampleFormPage
     *
     * @param driver драйвер для управления браузером
     */
    public BankingSampleFormPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локатор для кнопки SampleForm
     */
    @FindBy(css = "a.btn-primary[href*='registrationform.html']")
    private WebElement buttonSampleForm;

    /**
     * Локатор для поля First Name
     */
    @FindBy(id = "firstName")
    private WebElement fieldFirstName;

    /**
     * Локатор для поля Last Name
     */
    @FindBy(id = "lastName")
    private WebElement fieldLastName;

    /**
     * Локатор для поля Email
     */
    @FindBy(id = "email")
    private WebElement fieldEmail;

    /**
     * Локатор для поля Password
     */
    @FindBy(id = "password")
    private WebElement fieldPassword;

    /**
     * Локатор для чекбокса Sports
     */
    @FindBy(css = "input[value='Sports']")
    private WebElement checkBoxSports;

    /**
     * Локатор для поля Gender
     */
    @FindBy(id = "gender")
    private WebElement selectGender;

    /**
     * Локатор для поля Gender
     */
    @FindBy(css = "#gender option[value='male']")
    private WebElement selectGenderMale;

    /**
     * Локатор для поля About Yourself
     */
    @FindBy(id = "about")
    private WebElement fieldAbout;

    /**
     * Локатор для кнопки Register
     */
    @FindBy(css = "button[type='submit']")
    private WebElement buttonRegister;

    /**
     * Локатор для списка checkboxGroup
     */
    @FindBy(css = "div.checkbox-group")
    private WebElement checkboxGroup;

    /**
     * Локатор для successMessage
     */
    @Getter
    @FindBy(css = "#successMessage[style*='display: block']")
    private WebElement successMessage;

    /**
     * Метод для клика по кнопке SampleForm
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке SampleForm")
    public BankingSampleFormPage clickButtonSampleForm() {
        waitUntilVisible(driver, buttonSampleForm);
        buttonSampleForm.click();
        return this;
    }

    /**
     * Метод ввода текста в поле First Name
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода First Name")
    public BankingSampleFormPage inputFirstName(String input) {
        fieldFirstName.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Last Name
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Last Name")
    public BankingSampleFormPage inputLastName(String input) {
        fieldLastName.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Email
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Email")
    public BankingSampleFormPage inputEmail(String input) {
        fieldEmail.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Password
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Password")
    public BankingSampleFormPage inputPassword(String input) {
        fieldPassword.sendKeys(input);
        return this;
    }

    /**
     * Метод для клика по чекбоксу Sports
     *
     * @return текущая страница
     */
    @Step("Клик по чекбоксу Sports")
    public BankingSampleFormPage clickCheckBoxSports() {
        checkBoxSports.click();
        return this;
    }

    /**
     * Метод клика в поле Gender и выбора пункта из выпадающего списка
     *
     * @return текущая страница
     */
    @Step("Клик в поле Gender и выбора пункта из выпадающего списка")
    public BankingSampleFormPage selectGenderType() {
        selectGender.click();
        waitUntilVisible(driver, selectGenderMale);
        selectGenderMale.click();
        return this;
    }

    /**
     * Метод получения списка label
     */
    public List<String> getAllCheckboxLabels() {
        List<WebElement> labels = checkboxGroup.findElements(By.tagName("label"));
        List<String> result = new ArrayList<>();

        for (WebElement label : labels) {
            String text = label.getText();
            if (!text.isEmpty()) {
                result.add(text);
            }
        }
        return result;
    }

    /**
     * Метод получения самого длинного слова
     */
    public String findLongestLabel() {
        List<String> labels = getAllCheckboxLabels();

        if (labels.isEmpty()) {
            return "";
        }
        String longestWord = "";
        int maxLength = 0;
        for (String label : labels) {
            if (label.length() > maxLength) {
                longestWord = label;
                maxLength = label.length();
            }
        }
        return longestWord;
    }

    /**
     * Метод ввода текста в поле About
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода About")
    public BankingSampleFormPage inputAbout(String input) {
        fieldAbout.sendKeys(input);
        return this;
    }

    /**
     * Метод для клика по кнопке Register
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Register")
    public BankingSampleFormPage clickButtonRegister() {
        buttonRegister.click();
        return this;
    }
}