package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CookiesPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptExecutorTest extends BaseTestSeleniumGRID {

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
    @Feature(value = "Тестирование с использованием скрипта JavaScriptExecutor страницы sql-ex.ru")
    @Story(value = "Использование скрипта JavaScriptExecutor")
    @Test(description = "Убрать фокус и определить наличие скролла")
    @Severity(value = SeverityLevel.NORMAL)
    public void testAuth() {

        cookiesPage.removFocusInput();
        assertEquals("BODY", cookiesPage.reviewFocusInput());

        cookiesPage.reviewScrollBar();
        assertTrue(cookiesPage.reviewScrollBar(), "Скролл должен присутствовать на странице");
    }
}