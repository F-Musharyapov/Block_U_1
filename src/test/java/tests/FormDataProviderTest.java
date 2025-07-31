package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormDataProviderPage;
import utils.TestData;

import static org.testng.Assert.assertTrue;

public class FormDataProviderTest extends BaseTestFormDataProviderTest {

    /**
     * Экземпляр dataProviderTest
     */
    //private FormDataProviderTest formDataProviderTest;

    private FormDataProviderPage formDataProviderPage;

    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Метод предусловие перед тестами и инициализация вкладки
     */
    @BeforeMethod
    public void profileClickNext() {
        formDataProviderPage = new FormDataProviderPage(driver);
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование формы авторизации")
    @Story(value = "Тестирование формы авторизации с разными сценариями")
    @Test(description = "ID 4.1. Проверка авторизации с положительными и отрицательными сценариями", dataProvider = "Auth", dataProviderClass = TestData.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void parametersTest(String username, String password, String usernameDescription, boolean result, String type) {

        formDataProviderPage.inputUsername(username)
                .inputPassword(password)
                .inputUsernameDescription(usernameDescription)
                .clickToButtonLogin();

        if (result) {
            assertTrue(formDataProviderPage.getMessageHappy().isDisplayed(), "Сообщение успешной авторизации отсутствует");
        } else {
            if (type.contains("Checking input fields")) {
                assertTrue(formDataProviderPage.getLoginButtonDisabled().isDisplayed(), "Ошибка, кнопка LOGIN должна быть не активной");
            } else {
                assertTrue(formDataProviderPage.getLoginButtonDisabled().isDisplayed(), "Ошибка, кнопка LOGIN должна быть не активной");
            }
        }
    }
}