package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TabsPage;
import utils.RetryAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static utils.TestData.NAME_LINK;

/**
 * Класс тестирования tabs страницы TabsPage
 */
public class TabsPageTest extends BaseTest {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Экземпляр страницы TabsPage
     */
    private static TabsPage tabsPage;

    /**
     * Метод предусловие для инициализации
     */
    @BeforeMethod
    public void initialsBefore() {
        driver.get(config.tabsUrl());
        tabsPage = new TabsPage(driver);
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Вкладки и окна сайта way2automation.com")
    @Story(value = "Вкладки и окна")
    @Test(description = "Тест открытия трех вкладок", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testTabsClick() {
        tabsPage.switchToIframe()
                .clikLink()
                .clikLink();

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);

        String elementWindowHandlesList = windowHandlesList.get(2);
        driver.switchTo().window(windowHandlesList.get(2));

        assertEquals(windowHandlesList.size(), 3, "Количество открытых вкладок не совпадает");
        assertEquals(driver.getWindowHandle().toString(), elementWindowHandlesList, "Открыта не третья вкладка");
        assertEquals(tabsPage.getLink().getText(), NAME_LINK, "Название кнопки не совпадает");
    }
}