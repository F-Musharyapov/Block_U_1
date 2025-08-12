package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragnDropPage;
import utils.RetryAnalyzer;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static utils.TestData.DROPPED;

/**
 * Класс тестирования страницы DragnDropPage
 */
public class DragnDropTest extends BaseTest {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Экземпляр страницы DragnDropPage
     */
    private static DragnDropPage dragnDropPage;

    /**
     * Метод предусловие для инициализации
     */
    @BeforeMethod
    public void initialsBefore() {
        driver.get(config.dragnDropUrl());
        dragnDropPage = new DragnDropPage(driver);
    }

    @Epic(value = "Тестирование сайта way2automation")
    @Feature(value = "Тестирование формы DragnDropPage сайта way2automation")
    @Story(value = "Проверка функции DragnDropPage")
    @Test(description = "Проверка функции DragnDropPage на вывод окна успеха", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testdragnDrop() throws IOException {
        dragnDropPage.switchToIframe();
        dragnDropPage.dragAndDropElement();
        assertEquals(dragnDropPage.getDroppable().getText(), DROPPED, "Сообщение не совпадает");
    }

    /**
     * Метод для выхода из frame
     */
    @AfterMethod
    public void exitIframe() {
        driver.switchTo().defaultContent();
    }
}