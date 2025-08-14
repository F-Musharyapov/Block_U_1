package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsPage;
import utils.RetryAnalyzer;

import static org.testng.Assert.assertTrue;
import static utils.TestData.ALERT_INPUT;

/**
 * Класс тестирования alert страницы AlertsPage
 */
public class AlertsTest extends BaseTest {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Экземпляр страницы TabsPage
     */
    private static AlertsPage alertsPage;

    /**
     * Метод предусловие для инициализации
     */
    @BeforeMethod
    public void initialsBefore() {
        driver.get(config.alertUrl());
        alertsPage = new AlertsPage(driver);
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Alerts сайта way2automation.com")
    @Story(value = "Alerts")
    @Test(description = "Тест функционала Alerts", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testAllerts() {
        alertsPage.clikTabInputAlert()
                .switchToIframe()
                .clikButtonAlert()
                .switchToAlert()
                .inputDataToAlert()
                .outAlert();
        assertTrue(alertsPage.getTextField().getText().contains(ALERT_INPUT));
    }

    /**
     * Метод для выхода из frame
     */
    @AfterMethod
    public void exitIframe() {
        driver.switchTo().defaultContent();
    }
}