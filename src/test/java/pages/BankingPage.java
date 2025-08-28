package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static utils.Waiters.waitForAlert;
import static utils.Waiters.waitUntilVisible;

/**
 * Класс с методами для взаимодействия со страницей Banking
 */
public class BankingPage extends BasePage {

    /**
     * Конструктор создания страницы BankingPage
     *
     * @param driver драйвер для управления браузером
     */
    public BankingPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локатор для кнопки SampleForm
     */
    @FindBy(css = "a.btn-primary[href*='registrationform.html']")
    private WebElement buttonSampleForm;

    /**
     * Локатор для поля First Name вкладки SampleForm
     */
    @FindBy(id = "firstName")
    private WebElement fieldFirstNameSampleForm;

    /**
     * Локатор для поля Last Name SampleForm
     */
    @FindBy(id = "lastName")
    private WebElement fieldLastNameSampleForm;

    /**
     * Локатор для поля Email SampleForm
     */
    @FindBy(id = "email")
    private WebElement fieldEmailSampleForm;

    /**
     * Локатор для поля Password SampleForm
     */
    @FindBy(id = "password")
    private WebElement fieldPasswordSampleForm;

    /**
     * Локатор для чекбокса Sports SampleForm
     */
    @FindBy(css = "input[value='Sports']")
    private WebElement checkBoxSportsSampleForm;

    /**
     * Локатор для поля Gender SampleForm
     */
    @FindBy(id = "gender")
    private WebElement selectGenderSampleForm;

    /**
     * Локатор для поля Gender SampleForm
     */
    @FindBy(css = "#gender option[value='male']")
    private WebElement selectGenderMaleSampleForm;

    /**
     * Локатор для поля About Yourself SampleForm
     */
    @FindBy(id = "about")
    private WebElement fieldAboutSampleForm;

    /**
     * Локатор для кнопки Register SampleForm
     */
    @FindBy(css = "button[type='submit']")
    private WebElement buttonRegisterSampleForm;

    /**
     * Локатор для списка checkboxGroup SampleForm
     */
    @FindBy(css = "div.checkbox-group")
    private WebElement checkboxGroupSampleForm;

    /**
     * Локатор для successMessage SampleForm
     */
    @Getter
    @FindBy(css = "#successMessage[style*='display: block']")
    private WebElement successMessageSampleForm;

    /**
     * Локатор для кнопки Bank Manager Login
     */
    @FindBy(css = "button.btn-primary[ng-click='manager()']")
    private WebElement buttonBankManagerLogin;

    /**
     * Локатор для вкладки AddCustomer для интерфейса Bank Manager
     */
    @FindBy(css = "button.btn.tab[ng-click='addCust()']")
    private WebElement tabAddCustBankManager;

    /**
     * Локатор для поля First Name вкладки AddCustomer для интерфейса Bank Manager
     */
    @FindBy(css = "input.form-control[ng-model='fName']")
    private WebElement fieldFirstNameAddCustomerBankManager;

    /**
     * Локатор для поля Last Name вкладки AddCustomer для интерфейса Bank Manager
     */
    @FindBy(css = "input.form-control[ng-model='lName']")
    private WebElement fieldLastNameAddCustomerBankManager;

    /**
     * Локатор для поля Post Code вкладки AddCustomer для интерфейса Bank Manager
     */
    @FindBy(css = "input.form-control[ng-model='postCd']")
    private WebElement fieldPostCodeAddCustomerBankManager;

    /**
     * Локатор для кнопки вкладки AddCustomer для интерфейса Bank Manager
     */
    @FindBy(css = "button.btn.btn-default[type='submit']")
    private WebElement buttonAddCustBankManager;

    /**
     * Локатор для таба Open Account интерфейса Bank Manager
     */
    @FindBy(css = "button.btn.tab[ng-click='openAccount()']")
    private WebElement tabOpenAccountBankManager;

    /**
     * Локатор для селекта выбора userSelect таба Open Account интерфейса Bank Manager
     */
    @FindBy(css = "select.form-control[name='userSelect']")
    private WebElement userSelectBankManager;

    /**
     * Локатор для селекта выбора currencySelect таба Open Account интерфейса Bank Manager
     */
    @FindBy(css = "select.form-control[name='currency']")
    private WebElement currencySelectBankManager;

    /**
     * Локатор для кнопки Process таба Open Account интерфейса Bank Manager
     */
    @FindBy(xpath = "//button[@type='submit' and text()='Process']")
    private WebElement buttonProcessBankManager;

    /**
     * Метод для клика по кнопке SampleForm
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке SampleForm")
    public BankingPage clickButtonSampleForm() {
        waitUntilVisible(driver, buttonSampleForm);
        buttonSampleForm.click();
        return this;
    }

    /**
     * Метод ввода текста в поле First Name SampleForm
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода First Name SampleForm")
    public BankingPage inputFirstNameSampleForm(String input) {
        fieldFirstNameSampleForm.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Last Name SampleForm
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Last Name SampleForm")
    public BankingPage inputLastNameSampleForm(String input) {
        fieldLastNameSampleForm.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Email SampleForm
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Email SampleForm")
    public BankingPage inputEmailSampleForm(String input) {
        fieldEmailSampleForm.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Password SampleForm
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Password SampleForm")
    public BankingPage inputPasswordSampleForm(String input) {
        fieldPasswordSampleForm.sendKeys(input);
        return this;
    }

    /**
     * Метод для клика по чекбоксу Sports SampleForm
     *
     * @return текущая страница
     */
    @Step("Клик по чекбоксу Sports SampleForm")
    public BankingPage clickCheckBoxSportsSampleForm() {
        checkBoxSportsSampleForm.click();
        return this;
    }

    /**
     * Метод клика в поле Gender и выбора пункта из выпадающего списка SampleForm
     *
     * @return текущая страница
     */
    @Step("Клик в поле Gender и выбора пункта из выпадающего списка SampleForm")
    public BankingPage selectGenderTypeSampleForm() {
        selectGenderSampleForm.click();
        waitUntilVisible(driver, selectGenderMaleSampleForm);
        selectGenderMaleSampleForm.click();
        return this;
    }

    /**
     * Метод получения списка label SampleForm
     */
    public List<String> getAllCheckboxLabels() {
        List<WebElement> labels = checkboxGroupSampleForm.findElements(By.tagName("label"));
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
     * Метод ввода текста в поле About SampleForm
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода About SampleForm")
    public BankingPage inputAboutSampleForm(String input) {
        fieldAboutSampleForm.sendKeys(input);
        return this;
    }

    /**
     * Метод для клика по кнопке Register SampleForm
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Register SampleForm")
    public BankingPage clickButtonRegisterSampleForm() {
        buttonRegisterSampleForm.click();
        return this;
    }

    /**
     * Метод для клика по кнопке Bank Manager Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Bank Manager Login")
    public BankingPage clickButtonBankManagerLogin() {
        waitUntilVisible(driver, buttonSampleForm);
        buttonBankManagerLogin.click();
        return this;
    }

    /**
     * Метод для клика по табу Add Customer интерфейса Bank Manager
     *
     * @return текущая страница
     */
    @Step("Клик по табу Add Customer интерфейса Bank Manager")
    public BankingPage clickTabAddCust() {
        waitUntilVisible(driver, tabAddCustBankManager);
        tabAddCustBankManager.click();
        return this;
    }

    /**
     * Метод ввода текста в поле First Name вкладки AddCustomer интерфейса Bank Manager
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода First Name вкладки AddCustomer интерфейса Bank Manager")
    public BankingPage inputFirstNameAddCustomer(String input) {
        waitUntilVisible(driver, fieldFirstNameAddCustomerBankManager);
        fieldFirstNameAddCustomerBankManager.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Last Name вкладки AddCustomer интерфейса Bank Manager
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Last Name вкладки AddCustomer интерфейса Bank Manager")
    public BankingPage inputLastNameAddCustomer(String input) {
        waitUntilVisible(driver, fieldLastNameAddCustomerBankManager);
        fieldLastNameAddCustomerBankManager.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Post Code вкладки AddCustomer интерфейса Bank Manager
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Post Code вкладки AddCustomer интерфейса Bank Manager")
    public BankingPage inputPostCodeAddCustomer(String input) {
        waitUntilVisible(driver, fieldPostCodeAddCustomerBankManager);
        fieldPostCodeAddCustomerBankManager.sendKeys(input);
        return this;
    }

    /**
     * Метод для клика по кнопке Add Customer интерфейса Bank Manager
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Add Customer интерфейса Bank Manager")
    public BankingPage clickButtonAddCust() {
        waitUntilVisible(driver, buttonAddCustBankManager);
        buttonAddCustBankManager.click();
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
    @Step("Закрытие окна алерта")
    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (IllegalStateException e) {
            throw new RuntimeException("Нет активного алерта.", e);
        }
    }

    /**
     * Метод для клика по табу Open Account интерфейса Bank Manager
     *
     * @return текущая страница
     */
    @Step("Клик по табу Open Account интерфейса Bank Manager")
    public BankingPage clickTabOpenAccount() {
        waitUntilVisible(driver, tabAddCustBankManager);
        tabOpenAccountBankManager.click();
        return this;
    }

    /**
     * Метод для клика по селекту выбора пользователя вкладки Open Account интерфейса Bank Manager
     *
     * @return текущая страница
     */
    @Step("Клик по селекту выбора пользователя вкладки Open Account интерфейса Bank Manager")
    public BankingPage clickUserSelect() {
        waitUntilVisible(driver, userSelectBankManager);
        userSelectBankManager.click();
        return this;
    }

    /**
     * Метод выбора customer вкладки Open Account интерфейса Bank Manager
     *
     * @param str название нужного customer
     * @return
     */
    @Step("Клик по customer вкладки Open Account интерфейса Bank Manager")
    public BankingPage selectCreatedCustomer(String str) {
        waitUntilVisible(driver, userSelectBankManager);
        Select select = new Select(userSelectBankManager);
        select.selectByVisibleText(str);
        userSelectBankManager.click();
        return this;
    }

    /**
     * Метод клика по полю селекта currency вкладки Open Account интерфейса Bank Manager
     *
     * @return
     */
    @Step("Клик по полю селекта currency вкладки Open Account интерфейса Bank Manager")
    public BankingPage clickCurrencySelect() {
        waitUntilVisible(driver, currencySelectBankManager);
        currencySelectBankManager.click();
        return this;
    }

    /**
     * Метод выбора currency вкладки Open Account интерфейса Bank Manager
     *
     * @param str название нужного селекта вкладки Open Account интерфейса Bank Manager
     * @return
     */
    @Step("Выбор currency в select вкладки Open Account интерфейса Bank Manager")
    public BankingPage selectCurrency(String str) {
        waitUntilVisible(driver, currencySelectBankManager);
        Select select = new Select(currencySelectBankManager);
        select.selectByVisibleText(str);
        currencySelectBankManager.click();
        return this;
    }

    /**
     * Метод для клика по кнопке Process вкладки Open Account интерфейса Bank Manager
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Process вкладки Open Account интерфейса Bank Manager")
    public BankingPage clickButtonProcess() {
        waitUntilVisible(driver, buttonProcessBankManager);
        buttonProcessBankManager.click();
        return this;
    }
}