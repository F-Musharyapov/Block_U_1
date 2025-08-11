package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProfilePage;
import utils.RetryAnalyzer;

import static org.testng.Assert.assertTrue;
import static utils.TestData.*;

/**
 * Класс тестирования вкладки Profile
 */
public class ProfilePageTest extends BaseTestSeleniumGRID {

    /**
     * Экземпляр вкладки ProfilePage
     */
    private ProfilePage profilePage;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Метод предусловие перед тестами и инициализация вкладки
     */
    @BeforeMethod
    public void initialClass() {
        driver.get(config.url());
        profilePage = new ProfilePage(driver);
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Profile")
    @Story(value = "Отправка без данных")
    @Test(description = "ID 1.1. Проверка перехода на вкладку INTERESTS без заполнения данных", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testProfilePage_1_1() {
        profilePage.clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains(INTERESTS_TAB_NAME), "Активная вкладка должна быть " + INTERESTS_TAB_NAME + ", но найдено: " + profilePage.getActiveTabText());
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Profile")
    @Story(value = "Ввод данных валидных данных")
    @Test(description = "ID 1.2. Проверка перехода на вкладку INTERESTS с валидным именем", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testProfilePage_1_2() {
        profilePage.inputName(getValideName())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains(INTERESTS_TAB_NAME), "Активная вкладка должна быть " + INTERESTS_TAB_NAME + ", но найдено: " + profilePage.getActiveTabText());
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Profile")
    @Story(value = "Ввод данных валидных данных")
    @Test(description = "ID 1.3. Проверка перехода на вкладку INTERESTS с валидной почтой", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testProfilePage_1_3() {
        profilePage.inputEmail(getValideEmail())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains(INTERESTS_TAB_NAME), "Активная вкладка должна быть " + INTERESTS_TAB_NAME + ", но найдено: " + profilePage.getActiveTabText());
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Profile")
    @Story(value = "Ввод данных валидных данных")
    @Test(description = "ID 1.4. Проверка перехода на вкладку INTERESTS с валидным именем и почтой", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.CRITICAL)
    public void testProfilePage_1_4() {
        profilePage.inputName(getValideName())
                .inputEmail(getValideEmail())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains(INTERESTS_TAB_NAME), "Активная вкладка должна быть " + INTERESTS_TAB_NAME + ", но найдено: " + profilePage.getActiveTabText());
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Profile")
    @Story(value = "Ввод данных невалидных данных")
    @Test(description = "ID 1.5. Проверка ввода невалидного имени", retryAnalyzer= RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testProfilePage_1_5() {
        profilePage.inputEmail(getFakeName())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains(INTERESTS_TAB_NAME), "Активная вкладка должна быть " + INTERESTS_TAB_NAME + ", но найдено: " + profilePage.getActiveTabText());
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Profile")
    @Story(value = "Ввод данных невалидных данных")
    @Test(description = "ID 1.6. Проверка ввода некорректного email", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testProfilePage_1_6() {
        profilePage.inputEmail(getFakeEmail())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains(INTERESTS_TAB_NAME), "Активная вкладка должна быть " + INTERESTS_TAB_NAME + ", но найдено: " + profilePage.getActiveTabText());
    }
}