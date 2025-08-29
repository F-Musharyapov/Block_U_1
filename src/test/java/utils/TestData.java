package utils;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 * Класс для работы с данными
 */
public class TestData {

    /**
     * Экземпляр для списка браузеров
     */
    private EnumBrowsers enumBrowsers;

    /**
     * Экземпляр для Faker
     */
    private static final Faker faker = new Faker();

    /**
     * Экземпляр для Random
     */
    private static final Random random = new Random();

    /**
     * Константа текста успеха dragnDropPage
     */
    public static final String DROPPED = "Dropped!";

    /**
     * Константа названия вкладки PAYMENT
     */
    public static final String PAYMENT_TAB_NAME = "PAYMENT";

    /**
     * Константа названия radio-button PS
     */
    public static final String PS_SELECTED_TEXT = "ps";

    /**
     * Константа названия вкладки INTERESTS
     */
    public static final String INTERESTS_TAB_NAME = "INTERESTS";

    /**
     * Константа текста всплывающего окна успеха
     */
    public static final String ALERT_TEXT = "awesome!";

    /**
     * Константа названия ссылки для TabsPageTest
     */
    public static final String NAME_LINK = "New Browser Tab";

    /**
     * Константа текста всплывающего окна alert теста AlertTest
     */
    public static final String ALERT_INPUT = "Selenium";

    /**
     * Константа всплывающего текста BankingSampleFormPage
     */
    public static final String SUCCESS_MESSAGE = "User registered successfully!";

    /**
     * Константа всплывающего текста алерта при создании customer на BankingTest
     */
    public static final String CUSTOMER_ADDED_SUCCESS_MESSAGE = "Customer added successfully with customer id";

    /**
     * Константа всплывающего текста алерта при добавлении Currency для customer на BankingTest
     */
    public static final String CURRENCY_SUCCESS_MESSAGE = "Account created successfully with account Number";

    /**
     * Массив для выбора Currency для customer на BankingTest
     */
    public static final String[] CURRENCY_SELECT = {"Dollar", "Pound", "Rupee"};

    /**
     * Константа PostCode для customer на BankingTest
     */
    public static final String POST_CODE_CUSTOMER = "[0-9]{6}";

    /**
     * Константа всплывающего текста вкладки Deposit интерфейса Customer Login теста BankingTest
     */
    public static final String DEPOSITE_SUCCESS_MESSAGE = "Deposit Successful";

    /**
     * Константа суммы депозита для успешного пополнения счета пользователя интерфейса Customer Login теста BankingTest
     */
    public static final String DEPOSITE_AMOUNT_SUCCESS = "100321";

    /**
     * Константа суммы депозита для неуспешного пополнения счета пользователя интерфейса Customer Login теста BankingTest
     */
    public static final String DEPOSITE_AMOUNT_FAILED = "0";

    /**
     * Константа всплывающего текста успеха вкладки Withdrawl интерфейса Customer Login теста BankingTest
     */
    public static final String WITHDRAWN_SUCCESS_MESSAGE = "Transaction successful";

    /**
     * Константа всплывающего текста неудачи вкладки Withdrawl интерфейса Customer Login теста BankingTest
     */
    public static final String WITHDRAWN_FAILED_MESSAGE = "Transaction Failed. You can not withdraw amount more than the balance.";

    /**
     * Константа суммы депозита для неуспешного снятия средств со счета пользователя вкладки Withdrawl интерфейса Customer Login теста BankingTest
     */
    public static final String WITHDRAWN_AMOUNT_FAILED = "1000000";

    /**
     * Константа счета пользователя с 0 на балансе интерфейса Customer Login теста BankingTest
     */
    public static final String BALANCE_EMPTY = "0";

    /**
     * Константа нуля транзакций пользователя интерфейса Customer Login теста BankingTest
     */
    public static final int TRANSACTIONS_EMPTY = 0;

    /**
     * Идентификаторы
     */
    public static final String EMAIL_USER = "[a-z]{10}\\@[a-z]{5}\\.[a-z]{2}";
    public static final String NOVALIDE_EMAIL_USER = "[a-z]{10}\\@\\.[a-z]{2}";

    /**
     * Метод генерации валидных данных для поля First Name страницы BankingSampleFormPage
     *
     * @return сгенерированное имя
     */
    public static String generateFirstName() {
        return faker.name().firstName();
    }

    /**
     * Метод генерации валидных данных для поля Last Name страницы BankingSampleFormPage
     *
     * @return сгенерированное имя
     */
    public static String generateLastName() {
        return faker.name().lastName();
    }

    /**
     * Метод генерации валидных данных для поля Password страницы BankingSampleFormPage
     *
     * @return сгенерированное имя
     */
    public static String generatePassword() {
        return faker.internet().password(8, 16, true, true, true);
    }

    /**
     * Метод генерации валидных данных для поля email
     *
     * @return сгенерированная почта
     */
    public static String getValideEmail() {
        return faker.regexify(EMAIL_USER);
    }

    /**
     * Метод генерации валидных данных для поля user
     *
     * @return сгенерированное имя
     */
    public static String getValideName() {
        return faker.name().username();
    }

    /**
     * Метод генерации невалидных данных для поля email
     *
     * @return сгенерированная почта
     */
    public static String getFakeEmail() {
        return faker.regexify(NOVALIDE_EMAIL_USER);
    }

    /**
     * Метод генерации невалидных данных для поля user
     *
     * @return сгенерированное имя
     */
    public static String getFakeName() {
        return faker.name().username() + faker.number().digits(3);
    }

    /**
     * Метод генерации post code для BankingTest
     *
     * @return сгенерированное имя
     */
    public static String generateSimplePostCode() {
        return faker.regexify(POST_CODE_CUSTOMER);
    }

    /**
     * Метод генерации Currency для customer на BankingTest
     *
     * @return один Currency из массива
     */
    public static String getRandomCurrency() {
        return CURRENCY_SELECT[random.nextInt(CURRENCY_SELECT.length)];
    }

    public static int getRandomNumberAmountWithdrawn(int n) {
        Random random = new Random();
        return random.nextInt(n) + 1;
    }

    /**
     * Метод DataProvider для подстановки данных
     *
     * @return двумерный массив Object[][]
     */
    @DataProvider(name = "Auth")
    public Object[][] createData() {
        return new Object[][]{
                {"angular", "password", "userdescriptions", true, "validate"},
                {"angular1", "password", "userdescriptions", true, "validate"},
                {"angular", "12345", "testuser", false, "novalidate"},
                {"wronguser", "password", "testuser", false, "novalidate"},
                {"", "password", "12345", false, "Checking input fields"},
                {"angular", "", "12345", false, "Checking input fields"},
                {"angular", "password", "", false, "Checking input fields"},
                {"", "", "", false, "Checking input fields"},
                {"an", "password", "testuser", false, "Checking input fields"},
                {"angular", "pa", "testuser", false, "Checking input fields"},
                {"angular", "password", "ab", false, "Checking input fields"}
        };
    }

    /**
     * Метод для подстановки названий браузеров
     *
     * @param enumBrowsers принимает константу
     * @return Undefined
     */
    String getEnumBrowsers(EnumBrowsers enumBrowsers) {
        switch (enumBrowsers) {
            case FIREFOX:
                return "Firefox";
            case CHROME:
                return "Chrome";
            case EDGE:
                return "Edge";
            case INTERNET_EXPLORER:
                return "InternetExplorer";
            default:
                return "Undefined";
        }
    }
}