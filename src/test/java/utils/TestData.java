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
