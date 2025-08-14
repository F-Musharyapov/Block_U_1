package utils;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

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
     * Идентификаторы
     */
    public static final String EMAIL_USER = "[a-z]{10}\\@[a-z]{5}\\.[a-z]{2}";
    public static final String NOVALIDE_EMAIL_USER = "[a-z]{10}\\@\\.[a-z]{2}";

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
     * @param enumBrowsers принимает константу
     * @return Undefined
     */
    String getEnumBrowsers(EnumBrowsers enumBrowsers){
        switch(enumBrowsers){
            case FIREFOX: return "Firefox";
            case CHROME: return "Chrome";
            case EDGE: return "Edge";
            case INTERNET_EXPLORER: return "InternetExplorer";
            default: return "Undefined";
        }
    }
}