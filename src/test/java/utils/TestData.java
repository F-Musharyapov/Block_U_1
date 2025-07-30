package utils;

import com.github.javafaker.Faker;

/**
 * Класс для работы с данными
 */
public class TestData {

    /**
     * Экземпляр для Faker
     */
    private static final Faker faker = new Faker();

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
}