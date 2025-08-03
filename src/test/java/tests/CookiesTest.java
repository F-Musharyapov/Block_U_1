package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CookiesPage;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertTrue;

/**
 * Класс тестирования cookies страницы sql-ex.ru
 */
public class CookiesTest extends BaseTest {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Экземпляр страницы CookiesPage
     */
    private static CookiesPage cookiesPage;

    /**
     * Метод предусловие для инициализации
     */
    @BeforeMethod
    public void initialsBefore() {
        driver.get(config.cookiesUrl());
        cookiesPage = new CookiesPage(driver);
    }

    @Epic(value = "Тестирование сайта sql-ex.ru")
    @Feature(value = "Тестирование cookies страницы sql-ex.ru")
    @Story(value = "Авторизация")
    @Test(description = "Авторизация и запись cookies")
    @Severity(value = SeverityLevel.NORMAL)
    public void testAuth() throws IOException {
        cookiesPage.inputLogin(config.cookieslogin())
                .inputPassword(config.cookiespass())
                .clickToSubmitButton();
        Set<Cookie> cookies = driver.manage().getCookies();
        cookiesPage.writeAllCookie(cookies);
        driver.navigate().refresh();
    }

    @Epic(value = "Тестирование сайта sql-ex.ru")
    @Feature(value = "Тестирование cookies страницы sql-ex.ru")
    @Story(value = "Сookie")
    @Test(dependsOnMethods = "testAuth", description = "Проверка клика по ссылке с помощью cookie")
    @Severity(value = SeverityLevel.NORMAL)
    public void testAuthCookies() throws IOException {
        cookiesPage.readAllCookie(config.fileCookiesAdress());
        driver.navigate().refresh();
        cookiesPage.clickToPersonLink();
        assertTrue(cookiesPage.getLogoutButton().isDisplayed(), "Авторизация не прошла, отсутствует кнопка выхода)");
    }

    /**
     * Метод выхода из лк после тестов
     */
    @AfterMethod
    public static void logout() {
        cookiesPage.clickToLogoutButton();
    }
}