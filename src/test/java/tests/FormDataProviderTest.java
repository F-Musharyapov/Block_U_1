package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormDataProviderPage;
import utils.AshotScreenshot;
import utils.TestData;

import static org.testng.Assert.assertTrue;

public class FormDataProviderTest extends BaseTest {

    /**
     * Экземпляр dataProviderTest
     */
    private FormDataProviderPage formDataProviderPage;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Метод предусловие для инициализации вкладки
     */
    @BeforeMethod
    public void initialsBefore() {
        driver.get(config.authUrl());
        formDataProviderPage = new FormDataProviderPage(driver);
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование формы авторизации")
    @Story(value = "Тестирование формы авторизации с разными сценариями")
    @Test(description = "ID 4.1. Проверка авторизации с положительными и отрицательными сценариями", dataProvider = "Auth", dataProviderClass = TestData.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void parametersTest(String username, String password, String usernameDescription, boolean successResult, String type) {

        formDataProviderPage.inputUsername(username)
                .inputPassword(password)
                .inputUsernameDescription(usernameDescription)
                .clickToButtonLogin();

        if (successResult) {
            assertTrue(formDataProviderPage.getMessageHappy().isDisplayed(), "Сообщение успешной авторизации отсутствует");
            formDataProviderPage.clickLogout();
        } else {
            if (type.contains("Checking input fields")) {
                assertTrue(formDataProviderPage.getLoginButtonDisabled().isDisplayed(), "Ошибка, кнопка LOGIN должна быть не активной");
            } else {
                assertTrue(formDataProviderPage.getErrorLogged().isDisplayed(), "Ошибка, авторизация с невалидными данными");
            }
        }
    }

    /**
     * Завершающий метод для скриншота, если тест упал
     */
    //@AfterMethod
    //public void makeScreenShotAfterTestFailure(ITestResult result) {
    //    if (result.getStatus() == ITestResult.FAILURE) {
     //       AshotScreenshot.makeScreenShot(driver);
     //   }
    //}
}