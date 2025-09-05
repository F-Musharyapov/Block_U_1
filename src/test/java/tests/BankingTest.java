package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BankingPage;
import utils.AshotScreenshot;
import utils.RetryAnalyzer;

import java.time.Duration;

import static org.testng.Assert.*;
import static utils.TestData.*;

/**
 * Класс тестирования страницы BankingSampleFormPage
 */
public class BankingTest {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Переменная с экземпляром драйвера
     */
    private WebDriver driver;

    /**
     * Экземпляр страницы BankingPage
     */
    private BankingPage bankingPage;

    /**
     * Переменная для поля firstName
     */
    private String firstNameCustomerBankManagerInterface = generateFirstName();

    /**
     * Переменная для поля lastName
     */
    private String lastNameCustomerBankManagerInterface = generateLastName();

    /**
     * Переменная для поля balance
     */
    private int balanceCustomerLoginInterface;

    /**
     * Переменная для суммы Withdrawn
     */
    private int sumWithdrawnCustomerLoginInterface;

    /**
     * Метод предусловие для инициализации
     */
    @BeforeClass
    public void initialsBefore() {
        System.setProperty(config.driverPropertyChrome(), config.driverPathChrome());

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        bankingPage = new BankingPage(driver);
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Sample Form")
    @Test(description = "5.1 - Тестирование формы в интерфейсе Sample Form", priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testSampleFormInterface() {
        driver.get(config.bankingUrl());
        bankingPage
                .clickButtonSampleForm()
                .inputFirstNameSampleFormInterface(generateFirstName())
                .inputLastNameSampleFormInterface(generateLastName())
                .inputEmailSampleFormInterface(getValideEmail())
                .inputPasswordSampleFormInterface(generatePassword())
                .clickCheckBoxSportsSampleFormInterface()
                .selectGenderTypeSampleFormInterface()
                .inputAboutSampleFormInterface("Самое длинное слово из предложенных хобби - " + bankingPage.findLongestLabel())
                .clickButtonRegisterSampleFormInterface();

        assertEquals(bankingPage.getSuccessMessageSampleFormInterface().getText(), SUCCESS_MESSAGE, "Сообщение не совпадает");
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Bank Manager Login")
    @Test(description = "5.2.1 - Тестирование формы создания аккаунта", priority = 2, dependsOnMethods = "testSampleFormInterface", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testAddCustomerBankManagerInterface() {
        driver.get(config.bankingUrl());
        bankingPage
                .clickButtonBankManagerLogin()
                .clickTabAddCustBankManagerInterface()
                .inputFirstNameAddCustomerBankManagerInterface(firstNameCustomerBankManagerInterface)
                .inputLastNameAddCustomerBankManagerInterface(lastNameCustomerBankManagerInterface)
                .inputPostCodeAddCustomerBankManagerInterface(generateSimplePostCode())
                .clickButtonAddCustBankManagerInterface();

        assertTrue(bankingPage.getAlertText().contains(CUSTOMER_ADDED_SUCCESS_MESSAGE),
                "Alert не содержит ожидаемого сообщения.");

        bankingPage.acceptAlert();
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Bank Manager Login")
    @Test(description = "5.2.2 - Тестирование открытия аккаунта и добавления currency", priority = 3, dependsOnMethods = "testAddCustomerBankManagerInterface", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testOpenAccountBankManagerInterface() {
        bankingPage
                .clickTabOpenAccountBankManagerInterface()
                .clickUserSelectBankManagerInterface()
                .selectCreatedCustomerBankManagerInterface(firstNameCustomerBankManagerInterface + " " + lastNameCustomerBankManagerInterface)
                .selectCurrencyBankManagerInterface(getRandomCurrency())
                .clickButtonProcessBankManagerInterface();

        assertTrue(bankingPage.getAlertText().contains(CURRENCY_SUCCESS_MESSAGE),
                "Alert не содержит ожидаемого сообщения.");

        bankingPage.acceptAlert();
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Customer Login")
    @Test(description = "5.3 - Успешная авторизация", priority = 4, dependsOnMethods = "testOpenAccountBankManagerInterface", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testLoginInCustomerLoginInterface() {
        driver.get(config.bankingUrl());
        bankingPage
                .clickButtonCustomerLogin()
                .clickSelectCustomerLoginInterface()
                .selectCustomerLoginInterface(firstNameCustomerBankManagerInterface + " " + lastNameCustomerBankManagerInterface)
                .clickButtonLoginCustomerLoginInterface();

        assertEquals(bankingPage.getWelcomeTextCustomerLoginInterface().getText(),
                "Welcome " + firstNameCustomerBankManagerInterface + " " + lastNameCustomerBankManagerInterface + " !!", "Сообщение не совпадает");
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Customer Login")
    @Test(description = "5.3.1 - Успешное пополнение счета пользователя", priority = 5, dependsOnMethods = "testLoginInCustomerLoginInterface", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testSuccessfulDepositCustomerLoginInterface() {
        bankingPage
                .clickButtonDepositCustomerLoginInterface()
                .inputAmountCustomerLoginInterface(DEPOSITE_AMOUNT_SUCCESS)
                .clickButtonDepositSubmitCustomerLoginInterface();

        assertEquals(bankingPage.getMessageDepositSuccessfulСustomerLoginInterface().getText(), DEPOSITE_SUCCESS_MESSAGE,
                "Сообщение успеха не совпадает");

        bankingPage.clickButtonLogoutCustomerLoginInterface()
                .clickSelectCustomerLoginInterface()
                .selectCustomerLoginInterface(firstNameCustomerBankManagerInterface + " " + lastNameCustomerBankManagerInterface)
                .clickButtonLoginCustomerLoginInterface();

        bankingPage.clickButtonTransactionsCustomerLoginInterface();

        assertTrue(bankingPage.findDigitTransactionCustomerLoginInterface(DEPOSITE_AMOUNT_SUCCESS),
                "Ошибка, успешная транзакция отсутствует");
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Customer Login")
    @Test(description = "5.3.2 - Неуспешное пополнение счета пользователя", priority = 6, dependsOnMethods = "testSuccessfulDepositCustomerLoginInterface", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testFailedDepositCustomerLoginInterface() {
        bankingPage.clickButtonBackCustomerLoginInterface()
                .clickButtonDepositCustomerLoginInterface()
                .inputAmountCustomerLoginInterface(DEPOSITE_AMOUNT_FAILED)
                .clickButtonDepositSubmitCustomerLoginInterface();

        assertFalse(bankingPage.getMessageDepositSuccessfulСustomerLoginInterface().isDisplayed(),
                "Сообщение об успехе не должно отображаться при неуспешном пополнении");
        bankingPage.clickButtonTransactionsCustomerLoginInterface();
        assertFalse(bankingPage.findDigitTransactionCustomerLoginInterface(DEPOSITE_AMOUNT_FAILED),
                "Ошибка, неуспешная транзакция существует");
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Customer Login")
    @Test(description = "5.3.3 - Успешное снятие средств со счета пользователя", priority = 7, dependsOnMethods = "testFailedDepositCustomerLoginInterface", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testSuccessfulWithdrawlCustomerLoginInterface() {
        bankingPage.clickButtonLogoutCustomerLoginInterface()
                .clickSelectCustomerLoginInterface()
                .selectCustomerLoginInterface(firstNameCustomerBankManagerInterface + " " + lastNameCustomerBankManagerInterface)
                .clickButtonLoginCustomerLoginInterface();

        balanceCustomerLoginInterface = Integer.parseInt(bankingPage.getStringBalanceCustomerLoginInterface().getText());
        sumWithdrawnCustomerLoginInterface = getRandomNumberAmountWithdrawn(balanceCustomerLoginInterface);
        bankingPage.clickButtonWithdrawlCustomerLoginInterface()
                .inputAmountWithdrawnCustomerLoginInterface(String.valueOf(sumWithdrawnCustomerLoginInterface))
                .clickButtonWithdrawlSubmitCustomerLoginInterface();

        assertEquals(bankingPage.getMessageWithdrawSuccessfulСustomerLoginInterface().getText(), WITHDRAWN_SUCCESS_MESSAGE,
                "Сообщение успеха не совпадает");
        bankingPage.clickButtonLogoutCustomerLoginInterface()
                .clickSelectCustomerLoginInterface()
                .selectCustomerLoginInterface(firstNameCustomerBankManagerInterface + " " + lastNameCustomerBankManagerInterface)
                .clickButtonLoginCustomerLoginInterface()
                .clickButtonTransactionsCustomerLoginInterface();
        assertTrue(bankingPage.findDigitTransactionCustomerLoginInterface(String.valueOf(sumWithdrawnCustomerLoginInterface)),
                "Ошибка, успешная транзакция отсутствует");
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Customer Login")
    @Test(description = "5.3.4 - Неуспешное снятие средств со счета пользователя", priority = 8, dependsOnMethods = "testSuccessfulWithdrawlCustomerLoginInterface", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testFailedWithdrawlCustomerLoginInterface() {
        bankingPage.clickButtonBackCustomerLoginInterface()
                .clickButtonWithdrawlCustomerLoginInterface()
                .inputAmountWithdrawnCustomerLoginInterface(WITHDRAWN_AMOUNT_FAILED)
                .clickButtonWithdrawlSubmitCustomerLoginInterface();
        assertEquals(bankingPage.getMessageWithdrawSuccessfulСustomerLoginInterface().getText(), WITHDRAWN_FAILED_MESSAGE,
                "Сообщение провального снятия средств не совпадает");
        bankingPage.clickButtonTransactionsCustomerLoginInterface();
        assertFalse(bankingPage.findDigitTransactionCustomerLoginInterface(WITHDRAWN_AMOUNT_FAILED),
                "Ошибка, неуспешная транзакция существует");
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Customer Login")
    @Test(description = "5.3.5 - Порверка баланса пользователя", priority = 9, dependsOnMethods = "testFailedWithdrawlCustomerLoginInterface", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testBalanceReviewCustomerLoginInterface() {
        bankingPage.clickButtonBackCustomerLoginInterface();
        balanceCustomerLoginInterface = Integer.parseInt(bankingPage.getStringBalanceCustomerLoginInterface().getText());
        bankingPage.clickButtonTransactionsCustomerLoginInterface();
        assertEquals(balanceCustomerLoginInterface, bankingPage.calculateBalanceTransactionsCustomerLoginInterface(),
                "Баланс не совпадает с подсчетом транзакций");
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Customer Login")
    @Test(description = "5.3.6 - Снятие оставшихся средств c баланса пользователя", priority = 10, dependsOnMethods = "testBalanceReviewCustomerLoginInterface", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testWithdrawFullCustomerLoginInterface() {
        bankingPage.clickButtonBackCustomerLoginInterface();
        balanceCustomerLoginInterface = Integer.parseInt(bankingPage.getStringBalanceCustomerLoginInterface().getText());
        bankingPage.clickButtonWithdrawlCustomerLoginInterface()
                .inputAmountWithdrawnCustomerLoginInterface(String.valueOf(balanceCustomerLoginInterface))
                .clickButtonWithdrawlSubmitCustomerLoginInterface();

        assertEquals(bankingPage.getMessageWithdrawSuccessfulСustomerLoginInterface().getText(), WITHDRAWN_SUCCESS_MESSAGE,
                "Сообщение успеха не совпадает");
        assertEquals(bankingPage.getStringBalanceCustomerLoginInterface().getText(), BALANCE_EMPTY,
                "Баланс не совпадает");
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Customer Login")
    @Test(description = "5.3.7 - Очистка истории транзакций пользователя", priority = 11, dependsOnMethods = "testWithdrawFullCustomerLoginInterface", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testCleanHistoryTransactionsCustomerLoginInterface() {
        bankingPage.clickButtonTransactionsCustomerLoginInterface();

        assertNotEquals(TRANSACTIONS_EMPTY, bankingPage.calculateCountTransactionsCustomerLoginInterface(),
                "В системе должны присутствовать транзакции");

        bankingPage.clickButtonResetTransactionsCustomerLoginInterface();

        assertEquals(bankingPage.calculateCountTransactionsCustomerLoginInterface(), TRANSACTIONS_EMPTY, "Транзакции не очистились");

        bankingPage.clickButtonBackCustomerLoginInterface();

        assertEquals(bankingPage.getStringBalanceCustomerLoginInterface().getText(), BALANCE_EMPTY,
                "Баланс не совпадает");
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Bank Manager Login")
    @Test(description = "5.4 - Удаление покупателя", priority = 12, dependsOnMethods = "testCleanHistoryTransactionsCustomerLoginInterface", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testDeleteCustomerBankManagerInterface() {
        driver.get(config.bankingUrl());
        bankingPage
                .clickButtonBankManagerLogin()
                .clickTabCustomersBankManagerInterface()
                .inputSearchCustomerBankManagerInterface(firstNameCustomerBankManagerInterface);

        assertTrue(bankingPage.searchCustomerInListBankManagerInterface(firstNameCustomerBankManagerInterface + " " + lastNameCustomerBankManagerInterface),
                "Таблица не содержит пользователя " + firstNameCustomerBankManagerInterface + " " + lastNameCustomerBankManagerInterface);

        bankingPage
                .deleteCustomersByNamesСustomerLoginInterface(firstNameCustomerBankManagerInterface)
                .cleanFieldSearchCustomerBankManagerInterface();

        assertFalse(bankingPage.searchCustomerInListBankManagerInterface(firstNameCustomerBankManagerInterface + " " + lastNameCustomerBankManagerInterface),
                "Таблица не должна содержать " + firstNameCustomerBankManagerInterface + " " + lastNameCustomerBankManagerInterface);
    }

    /**
     * Завершающий метод для скриншотов при неудаче
     */
    @AfterMethod
    public void afterScreenMethod(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE && driver != null) {
                AshotScreenshot.makeScreenShot(driver);
            }
        } catch (Exception e) {
            System.err.println("Скриншот не создался, ошибка " + e.getMessage());
        }
    }

    /**
     * Завершающий метод выхода из драйвера для всех тестов
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}