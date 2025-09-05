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
    private WebElement fieldFirstNameSampleFormInterface;

    /**
     * Локатор для поля Last Name SampleForm
     */
    @FindBy(id = "lastName")
    private WebElement fieldLastNameSampleFormInterface;

    /**
     * Локатор для поля Email SampleForm
     */
    @FindBy(id = "email")
    private WebElement fieldEmailSampleFormInterface;

    /**
     * Локатор для поля Password SampleForm
     */
    @FindBy(id = "password")
    private WebElement fieldPasswordSampleFormInterface;

    /**
     * Локатор для чекбокса Sports SampleForm
     */
    @FindBy(css = "input[value='Sports']")
    private WebElement checkBoxSportsSampleFormInterface;

    /**
     * Локатор для поля Gender SampleForm
     */
    @FindBy(id = "gender")
    private WebElement selectGenderSampleFormInterface;

    /**
     * Локатор для поля Gender SampleForm
     */
    @FindBy(css = "#gender option[value='male']")
    private WebElement selectGenderMaleSampleFormInterface;

    /**
     * Локатор для поля About Yourself SampleForm
     */
    @FindBy(id = "about")
    private WebElement fieldAboutSampleFormInterface;

    /**
     * Локатор для кнопки Register SampleForm
     */
    @FindBy(css = "button[type='submit']")
    private WebElement buttonRegisterSampleFormInterface;

    /**
     * Локатор для списка checkboxGroup SampleForm
     */
    @FindBy(css = "div.checkbox-group")
    private WebElement checkboxGroupSampleFormInterface;

    /**
     * Локатор для successMessage SampleForm
     */
    @Getter
    @FindBy(css = "#successMessage[style*='display: block']")
    private WebElement successMessageSampleFormInterface;

    /**
     * Локатор для кнопки Bank Manager Login
     */
    @FindBy(css = "button.btn-primary[ng-click='manager()']")
    private WebElement buttonBankManagerLogin;

    /**
     * Локатор для вкладки AddCustomer для интерфейса Bank Manager
     */
    @FindBy(css = "button.btn.tab[ng-click='addCust()']")
    private WebElement tabAddCustBankManagerInterface;

    /**
     * Локатор для поля First Name вкладки AddCustomer для интерфейса Bank Manager
     */
    @FindBy(css = "input.form-control[ng-model='fName']")
    private WebElement fieldFirstNameAddCustomerBankManagerInterface;

    /**
     * Локатор для поля Last Name вкладки AddCustomer для интерфейса Bank Manager
     */
    @FindBy(css = "input.form-control[ng-model='lName']")
    private WebElement fieldLastNameAddCustomerBankManagerInterface;

    /**
     * Локатор для поля Post Code вкладки AddCustomer для интерфейса Bank Manager
     */
    @FindBy(css = "input.form-control[ng-model='postCd']")
    private WebElement fieldPostCodeAddCustomerBankManagerInterface;

    /**
     * Локатор для кнопки вкладки AddCustomer для интерфейса Bank Manager
     */
    @FindBy(css = "button.btn.btn-default[type='submit']")
    private WebElement buttonAddCustBankManagerInterface;

    /**
     * Локатор для таба Open Account интерфейса Bank Manager
     */
    @FindBy(css = "button.btn.tab[ng-click='openAccount()']")
    private WebElement tabOpenAccountBankManagerInterface;

    /**
     * Локатор для таба Customers интерфейса Bank Manager
     */
    @FindBy(css = "button.btn.tab[ng-click='showCust()']")
    private WebElement tabCustomersBankManagerInterface;

    /**
     * Локатор для селекта выбора userSelect таба Open Account интерфейса Bank Manager
     */
    @FindBy(css = "select.form-control[name='userSelect']")
    private WebElement userSelectBankManagerInterface;

    /**
     * Локатор для селекта выбора currencySelect таба Open Account интерфейса Bank Manager
     */
    @FindBy(css = "select.form-control[name='currency']")
    private WebElement currencySelectBankManagerInterface;

    /**
     * Локатор для кнопки Process таба Open Account интерфейса Bank Manager
     */
    @FindBy(xpath = "//button[@type='submit' and text()='Process']")
    private WebElement buttonProcessBankManagerInterface;

    /**
     * Локатор для поля Search Customer вкладки Customer для интерфейса Bank Manager
     */
    @FindBy(css = "input.form-control[ng-model='searchCustomer']")
    private WebElement fieldSearchCustomerBankManagerInterface;

    /**
     * Локатор для кнопки Customer Login
     */
    @FindBy(css = "button.btn-primary[ng-click='customer()']")
    private WebElement buttonCustomerLogin;

    /**
     * Локатор для селекта выбора Your Name интерфейса Customer Login
     */
    @FindBy(css = "select.form-control[name='userSelect']")
    private WebElement selectNameCustomerLoginInterface;

    /**
     * Локатор для кнопки Login интерфейса Customer Login
     */
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement buttonLoginCustomerLoginInterface;

    /**
     * Локатор для текста welcome интерфейса Customer Login
     */
    @Getter
    @FindBy(xpath = "//strong[contains(text(), 'Welcome')]")
    private WebElement welcomeTextCustomerLoginInterface;

    /**
     * Локатор для кнопки Transactions интерфейса Customer Login
     */
    @FindBy(xpath = "//button[@ng-click='transactions()']")
    private WebElement buttonTransactionsCustomerLoginInterface;

    /**
     * Локатор для кнопки Deposit интерфейса Customer Login
     */
    @FindBy(xpath = "//button[@ng-click='deposit()']")
    private WebElement buttonDepositCustomerLoginInterface;

    /**
     * Локатор для кнопки Withdrawl интерфейса Customer Login
     */
    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    private WebElement buttonWithdrawlCustomerLoginInterface;

    /**
     * Локатор для поля ввода Amount кладки Deposit интерфейса Customer Login
     */
    @FindBy(css = "input.form-control[ng-model='amount']")
    private WebElement fieldAmountDepositCustomerLoginInterface;

    /**
     * Локатор для кнопки Deposit Submit интерфейса Customer Login
     */
    @FindBy(css = "button[type='submit'].btn.btn-default")
    private WebElement buttonDepositSubmitCustomerLoginInterface;

    /**
     * Локатор для сообщения успеха Deposit Successful вкладки Deposit интерфейса Customer Login
     */
    @Getter
    @FindBy(css = "span[ng-show='message']")
    private WebElement messageDepositSuccessfulСustomerLoginInterface;

    /**
     * Локатор таблицы вкладки Transactions интерфейса Customer Login
     */
    @FindBy(css = "tbody")
    private WebElement tableTransactionsСustomerLoginInterface;

    /**
     * Локатор для строк таблицы вкладки Transactions интерфейса Customer Login
     */
    @Getter
    @FindBy(css = "tbody tr")
    private WebElement tableRowsTransactionsСustomerLoginInterface;

    /**
     * Локатор для кнопки Back вкладки Transactions интерфейса Customer Login
     */
    @FindBy(css = "button[ng-click='back()'].btn")
    private WebElement buttonBackTransactionsCustomerLoginInterface;

    /**
     * Локатор для строки Balance интерфейса Customer Login
     */
    @Getter
    @FindBy(xpath = "//div[@class='center']/strong[2]")
    private WebElement stringBalanceCustomerLoginInterface;

    /**
     * Локатор для поля ввода Amount вкладки Withdrawl интерфейса Customer Login
     */
    @FindBy(css = "input.form-control[ng-model='amount']")
    private WebElement fieldAmountWithdrawCustomerLoginInterface;

    /**
     * Локатор для кнопки Withdraw submit вкладки Withdrawl интерфейса Customer Login
     */
    @FindBy(css = "button[type='submit'].btn.btn-default")
    private WebElement buttonWithdrawSubmitCustomerLoginInterface;

    /**
     * Локатор для сообщения успеха Withdrawl Successful вкладки Withdraw интерфейса Customer Login
     */
    @Getter
    @FindBy(css = "span[ng-show='message']")
    private WebElement messageWithdrawSuccessfulСustomerLoginInterface;

    /**
     * Локатор для кнопки Logout интерфейса Customer Login
     */
    @Getter
    @FindBy(css = "button[ng-click='byebye()'].btn.logout")
    private WebElement buttonLogoutCustomerLoginInterface;

    /**
     * Локатор для кнопки Reset вкладки Transactions интерфейса Customer Login
     */
    @FindBy(css = "button[ng-click='reset()'].btn")
    private WebElement buttonResetTransactionsCustomerLoginInterface;

    /**
     * Локатор для кнопки Delete вкладки Customer интерфейса Customer Login
     */
    @FindBy(css = "td button[ng-click='deleteCust(cust)']")
    private WebElement deleteCustomerButtonСustomerLoginInterface;

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
    public BankingPage inputFirstNameSampleFormInterface(String input) {
        fieldFirstNameSampleFormInterface.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Last Name SampleForm
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Last Name SampleForm")
    public BankingPage inputLastNameSampleFormInterface(String input) {
        fieldLastNameSampleFormInterface.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Email SampleForm
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Email SampleForm")
    public BankingPage inputEmailSampleFormInterface(String input) {
        fieldEmailSampleFormInterface.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Password SampleForm
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Password SampleForm")
    public BankingPage inputPasswordSampleFormInterface(String input) {
        fieldPasswordSampleFormInterface.sendKeys(input);
        return this;
    }

    /**
     * Метод для клика по чекбоксу Sports SampleForm
     *
     * @return текущая страница
     */
    @Step("Клик по чекбоксу Sports SampleForm")
    public BankingPage clickCheckBoxSportsSampleFormInterface() {
        checkBoxSportsSampleFormInterface.click();
        return this;
    }

    /**
     * Метод клика в поле Gender и выбора пункта из выпадающего списка SampleForm
     *
     * @return текущая страница
     */
    @Step("Клик в поле Gender и выбора пункта из выпадающего списка SampleForm")
    public BankingPage selectGenderTypeSampleFormInterface() {
        selectGenderSampleFormInterface.click();
        waitUntilVisible(driver, selectGenderMaleSampleFormInterface);
        selectGenderMaleSampleFormInterface.click();
        return this;
    }

    /**
     * Метод получения списка label SampleForm
     */
    public List<String> getAllCheckboxLabels() {
        List<WebElement> labels = checkboxGroupSampleFormInterface.findElements(By.tagName("label"));
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
    public BankingPage inputAboutSampleFormInterface(String input) {
        fieldAboutSampleFormInterface.sendKeys(input);
        return this;
    }

    /**
     * Метод для клика по кнопке Register SampleForm
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Register SampleForm")
    public BankingPage clickButtonRegisterSampleFormInterface() {
        buttonRegisterSampleFormInterface.click();
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
    public BankingPage clickTabAddCustBankManagerInterface() {
        waitUntilVisible(driver, tabAddCustBankManagerInterface);
        tabAddCustBankManagerInterface.click();
        return this;
    }

    /**
     * Метод ввода текста в поле First Name вкладки AddCustomer интерфейса Bank Manager
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода First Name вкладки AddCustomer интерфейса Bank Manager")
    public BankingPage inputFirstNameAddCustomerBankManagerInterface(String input) {
        waitUntilVisible(driver, fieldFirstNameAddCustomerBankManagerInterface);
        fieldFirstNameAddCustomerBankManagerInterface.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Last Name вкладки AddCustomer интерфейса Bank Manager
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Last Name вкладки AddCustomer интерфейса Bank Manager")
    public BankingPage inputLastNameAddCustomerBankManagerInterface(String input) {
        waitUntilVisible(driver, fieldLastNameAddCustomerBankManagerInterface);
        fieldLastNameAddCustomerBankManagerInterface.sendKeys(input);
        return this;
    }

    /**
     * Метод ввода текста в поле Post Code вкладки AddCustomer интерфейса Bank Manager
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Post Code вкладки AddCustomer интерфейса Bank Manager")
    public BankingPage inputPostCodeAddCustomerBankManagerInterface(String input) {
        waitUntilVisible(driver, fieldPostCodeAddCustomerBankManagerInterface);
        fieldPostCodeAddCustomerBankManagerInterface.sendKeys(input);
        return this;
    }

    /**
     * Метод для клика по кнопке Add Customer интерфейса Bank Manager
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Add Customer интерфейса Bank Manager")
    public BankingPage clickButtonAddCustBankManagerInterface() {
        waitUntilVisible(driver, buttonAddCustBankManagerInterface);
        buttonAddCustBankManagerInterface.click();
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
    public BankingPage clickTabOpenAccountBankManagerInterface() {
        waitUntilVisible(driver, tabAddCustBankManagerInterface);
        tabOpenAccountBankManagerInterface.click();
        return this;
    }

    /**
     * Метод для клика по селекту выбора пользователя вкладки Open Account интерфейса Bank Manager
     *
     * @return текущая страница
     */
    @Step("Клик по селекту выбора пользователя вкладки Open Account интерфейса Bank Manager")
    public BankingPage clickUserSelectBankManagerInterface() {
        waitUntilVisible(driver, userSelectBankManagerInterface);
        userSelectBankManagerInterface.click();
        return this;
    }

    /**
     * Метод выбора customer вкладки Open Account интерфейса Bank Manager
     *
     * @param str название нужного customer
     * @return
     */
    @Step("Клик по customer вкладки Open Account интерфейса Bank Manager")
    public BankingPage selectCreatedCustomerBankManagerInterface(String str) {
        waitUntilVisible(driver, userSelectBankManagerInterface);
        Select select = new Select(userSelectBankManagerInterface);
        select.selectByVisibleText(str);
        userSelectBankManagerInterface.click();
        return this;
    }

    /**
     * Метод клика по полю селекта currency вкладки Open Account интерфейса Bank Manager
     *
     * @return
     */
    @Step("Клик по полю селекта currency вкладки Open Account интерфейса Bank Manager")
    public BankingPage clickCurrencySelectBankManagerInterface() {
        waitUntilVisible(driver, currencySelectBankManagerInterface);
        currencySelectBankManagerInterface.click();
        return this;
    }

    /**
     * Метод выбора currency вкладки Open Account интерфейса Bank Manager
     *
     * @param str название нужного селекта вкладки Open Account интерфейса Bank Manager
     * @return
     */
    @Step("Выбор currency в select вкладки Open Account интерфейса Bank Manager")
    public BankingPage selectCurrencyBankManagerInterface(String str) {
        waitUntilVisible(driver, currencySelectBankManagerInterface);
        Select select = new Select(currencySelectBankManagerInterface);
        select.selectByVisibleText(str);
        currencySelectBankManagerInterface.click();
        return this;
    }

    /**
     * Метод для клика по кнопке Process вкладки Open Account интерфейса Bank Manager
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Process вкладки Open Account интерфейса Bank Manager")
    public BankingPage clickButtonProcessBankManagerInterface() {
        waitUntilVisible(driver, buttonProcessBankManagerInterface);
        buttonProcessBankManagerInterface.click();
        return this;
    }

    /**
     * Метод для клика по кнопке Customer Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Customer Login")
    public BankingPage clickButtonCustomerLogin() {
        waitUntilVisible(driver, buttonCustomerLogin);
        buttonCustomerLogin.click();
        return this;
    }

    /**
     * Метод для клика по селекту выбора пользователя интерфейса Customer Login
     *
     * @return текущая страница
     */
    @Step("Клик по селекту выбора пользователя интерфейса Customer Login")
    public BankingPage clickSelectCustomerLoginInterface() {
        waitUntilVisible(driver, selectNameCustomerLoginInterface);
        selectNameCustomerLoginInterface.click();
        return this;
    }

    /**
     * Метод выбора name списке пользователей интерфейса Customer Login
     *
     * @param str название нужного customer
     * @return
     */
    @Step("Выбор name списке пользователей интерфейса Customer Login")
    public BankingPage selectCustomerLoginInterface(String str) {
        waitUntilVisible(driver, selectNameCustomerLoginInterface);
        Select select = new Select(selectNameCustomerLoginInterface);
        select.selectByVisibleText(str);
        selectNameCustomerLoginInterface.click();
        return this;
    }

    /**
     * Метод для клика по кнопке Login интерфейса Customer Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Login интерфейса Customer Login")
    public BankingPage clickButtonLoginCustomerLoginInterface() {
        waitUntilVisible(driver, buttonLoginCustomerLoginInterface);
        buttonLoginCustomerLoginInterface.click();
        return this;
    }

    /**
     * Метод для клика по кнопке Transactions интерфейса Customer Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Transactions интерфейса Customer Login")
    public BankingPage clickButtonTransactionsCustomerLoginInterface() {
        waitUntilVisible(driver, buttonTransactionsCustomerLoginInterface);
        buttonTransactionsCustomerLoginInterface.click();
        return this;
    }

    /**
     * Метод для клика по кнопке Deposit интерфейса Customer Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Deposit интерфейса Customer Login")
    public BankingPage clickButtonDepositCustomerLoginInterface() {
        waitUntilVisible(driver, buttonDepositCustomerLoginInterface);
        buttonDepositCustomerLoginInterface.click();
        return this;
    }

    /**
     * Метод для клика по кнопке Withdrawl интерфейса Customer Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Withdrawl интерфейса Customer Login")
    public BankingPage clickButtonWithdrawlCustomerLoginInterface() {
        waitUntilVisible(driver, buttonWithdrawlCustomerLoginInterface);
        buttonWithdrawlCustomerLoginInterface.click();
        return this;
    }

    /**
     * Метод ввода текста в поле Amount вкладки Deposit интерфейса Customer Login
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Amount вкладки Deposit интерфейса Customer Login")
    public BankingPage inputAmountCustomerLoginInterface(String input) {
        waitUntilVisible(driver, fieldAmountDepositCustomerLoginInterface);
        fieldAmountDepositCustomerLoginInterface.sendKeys(input);
        return this;
    }

    /**
     * Метод для клика по кнопке Deposit Submit вкладки Deposit интерфейса Customer Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Deposit Submit вкладки Deposit интерфейса Customer Login")
    public BankingPage clickButtonDepositSubmitCustomerLoginInterface() {
        waitUntilVisible(driver, buttonDepositSubmitCustomerLoginInterface);
        buttonDepositSubmitCustomerLoginInterface.click();
        return this;
    }

    /**
     * Метод цикл для проверки наличия транзакции во вкладке Transactions интерфейса Customer Login
     *
     * @return результат поиска
     * @str число для поиска
     */
    public boolean findDigitTransactionCustomerLoginInterface(String str) {
        List<WebElement> amountCells = tableTransactionsСustomerLoginInterface.findElements(By.cssSelector("tr td:nth-child(2)"));
        for (WebElement cell : amountCells) {
            if (cell.getText().trim().equals(str)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Метод для клика по кнопке Back вкладки Transactions интерфейса Customer Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Back вкладки Transactions интерфейса Customer Login")
    public BankingPage clickButtonBackCustomerLoginInterface() {
        waitUntilVisible(driver, buttonBackTransactionsCustomerLoginInterface);
        buttonBackTransactionsCustomerLoginInterface.click();
        return this;
    }

    /**
     * Метод ввода текста в поле Amount вкладки Withdrawl интерфейса Customer Login
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Amount вкладки Withdrawn интерфейса Customer Login")
    public BankingPage inputAmountWithdrawnCustomerLoginInterface(String input) {
        waitUntilVisible(driver, fieldAmountWithdrawCustomerLoginInterface);
        fieldAmountWithdrawCustomerLoginInterface.sendKeys(input);
        return this;
    }

    /**
     * Метод для клика по кнопке Withdraw Submit вкладки Withdrawl интерфейса Customer Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Withdraw Submit вкладки Withdrawn интерфейса Customer Login")
    public BankingPage clickButtonWithdrawlSubmitCustomerLoginInterface() {
        waitUntilVisible(driver, buttonWithdrawSubmitCustomerLoginInterface);
        buttonWithdrawSubmitCustomerLoginInterface.click();
        return this;
    }

    /**
     * Метод для клика по кнопке Logout интерфейса Customer Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Logout интерфейса Customer Login")
    public BankingPage clickButtonLogoutCustomerLoginInterface() {
        waitUntilVisible(driver, buttonLogoutCustomerLoginInterface);
        buttonLogoutCustomerLoginInterface.click();
        return this;
    }

    /**
     * Метод для извлечения транзакций из строк таблицы вкладки Transactions интерфейса Customer Login
     *
     * @return подсчитанный баланс пользователя
     */
    @Step("Извлечение транзакций из строк таблицы вкладки Transactions интерфейса Customer Login")
    public int calculateBalanceTransactionsCustomerLoginInterface() {
        waitUntilVisible(driver, tableTransactionsСustomerLoginInterface);
        List<WebElement> rows = tableTransactionsСustomerLoginInterface.findElements(By.cssSelector("tr"));

        int totalCredit = 0;
        int totalDebit = 0;

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);

            int amount = Integer.parseInt(row.findElement(By.cssSelector("td:nth-child(2)")).getText());
            String type = row.findElement(By.cssSelector("td:nth-child(3)")).getText();

            if ("Credit".equals(type)) {
                totalCredit += amount;
            } else if ("Debit".equals(type)) {
                totalDebit += amount;
            }
        }
        return totalCredit - totalDebit;
    }

    /**
     * Метод для подсчета количества транзакций вкладки Transactions интерфейса Customer Login
     *
     * @return количество транзакций
     */
    @Step("Подсчет количества транзакций вкладки Transactions интерфейса Customer Login")
    public int calculateCountTransactionsCustomerLoginInterface() {
        if (tableTransactionsСustomerLoginInterface.findElements(By.cssSelector("tr")).isEmpty()) {
            return 0;
        }
        List<WebElement> rows = tableTransactionsСustomerLoginInterface.findElements(By.cssSelector("tr"));
        return rows.size();
    }

    /**
     * Метод для клика по кнопке Reset вкладки Transactions интерфейса Customer Login
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Reset вкладки Transactions интерфейса Customer Login")
    public BankingPage clickButtonResetTransactionsCustomerLoginInterface() {
        waitUntilVisible(driver, buttonResetTransactionsCustomerLoginInterface);
        buttonResetTransactionsCustomerLoginInterface.click();
        return this;
    }

    /**
     * Метод для клика по табу Customers интерфейса Bank Manager
     *
     * @return текущая страница
     */
    @Step("Клик по табу Customers интерфейса Bank Manager")
    public BankingPage clickTabCustomersBankManagerInterface() {
        waitUntilVisible(driver, tabCustomersBankManagerInterface);
        tabCustomersBankManagerInterface.click();
        return this;
    }

    /**
     * Метод ввода текста в поле Search Customer вкладки Customer интерфейса Bank Manager
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Search Customer вкладки Customer интерфейса Bank Manager")
    public BankingPage inputSearchCustomerBankManagerInterface(String input) {
        waitUntilVisible(driver, fieldSearchCustomerBankManagerInterface);
        fieldSearchCustomerBankManagerInterface.sendKeys(input);
        return this;
    }

    /**
     * Метод для поиска пользователя в таблице вкладки Customer интерфейса Bank Manager
     *
     * @return результат поиска
     */
    @Step("Поиск пользователя в таблице вкладки Customer интерфейса Bank Manager")
    public boolean searchCustomerInListBankManagerInterface(String searchText) {
        List<WebElement> rows = tableTransactionsСustomerLoginInterface.findElements(By.cssSelector("tr"));

        for (WebElement row : rows) {
            String rowText = row.getText();
            if (rowText.contains(searchText)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод удаления по имени в таблице вкладки Customer интерфейса Bank Manager
     *
     * @param name имя пользователя
     */
    @Step("Удаления по имени в таблице вкладки Customer интерфейса Bank Manager")
    public BankingPage deleteCustomersByNamesСustomerLoginInterface(String name) {
        List<WebElement> rows = tableTransactionsСustomerLoginInterface.findElements(By.cssSelector("tr"));

        for (WebElement row : rows) {
            String customerName = row.findElement(By.cssSelector("td:nth-child(1)")).getText();
            if (name.contains(customerName)) {
                deleteCustomerButtonСustomerLoginInterface.click();
            }
        }
        return this;
    }

    /**
     * Метод очистки поля поиска вкладки Customer интерфейса Bank Manager
     *
     * @return текущая страница
     */
    @Step("Очистка поля поиска вкладки Customer интерфейса Bank Manager")
    public BankingPage cleanFieldSearchCustomerBankManagerInterface() {
        waitUntilVisible(driver, fieldSearchCustomerBankManagerInterface);
        fieldSearchCustomerBankManagerInterface.clear();
        return this;
    }
}