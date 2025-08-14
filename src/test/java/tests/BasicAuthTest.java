package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasicAuthPage;
import utils.RetryAnalyzer;

import java.awt.*;

import static org.testng.Assert.assertTrue;

/**
 * Класс тестирования basic auth страницы BasicAuth
 */
public class BasicAuthTest extends BaseTest {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Экземпляр страницы CookiesPage
     */
    private static BasicAuthPage basicAuthPage;

    /**
     * Метод предусловие для инициализации
     */
    @BeforeMethod
    public void initialsBefore() {
        driver.get(config.basicAuthUrl());
        basicAuthPage = new BasicAuthPage(driver);
    }

    @Epic(value = "Тестирование сайта httpwatch.com")
    @Feature(value = "BasicAuth сайта httpwatch.com")
    @Story(value = "BasicAuth")
    @Test(description = "Тест функционала BasicAuth", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testBasicAuth() throws AWTException {
        basicAuthPage.clikButtonDisplayImage()
                .inputDataAlert(config.basicAuthLogin(), config.basicAuthPassword());
        assertTrue(basicAuthPage.getHappyImage().isDisplayed(), "Аутентификация не прошла");
    }
}