package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InterestPage;
import pojo.FormModel;
import utils.RetryAnalyzer;

import static org.testng.Assert.assertTrue;
import static utils.TestData.PAYMENT_TAB_NAME;
import static utils.TestData.PS_SELECTED_TEXT;

/**
 * Класс тестирования вкладки Interest
 */
public class InterestPageTest extends BaseTestSeleniumGRID {

    /**
     * Экземпляр вкладки InterestPage
     */
    private InterestPage interestPage;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Метод предусловие перед тестами и инициализация вкладки
     */
    @BeforeMethod
    public void profileClickNext() {
        driver.get(config.url());
        interestPage = new InterestPage(driver);
        interestPage.clickToButtonNextSectionInterests();
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Interest")
    @Story(value = "Отправка без данных")
    @Test(description = "ID 2.1. Проверка перехода на вкладку PAYMENT без выбранного radio button", retryAnalyzer= RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testInterestPage_2_1() {
        interestPage.clickToButtonNextSectionPayment();
        assertTrue(interestPage.getActiveTabText().toUpperCase().contains(PAYMENT_TAB_NAME), "Активная вкладка должна быть " + PAYMENT_TAB_NAME + ", но найдено: " + interestPage.getActiveTabText());
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Interest")
    @Story(value = "Ввод данных валидных данных")
    @Test(description = "ID 2.2. Проверка перехода на вкладку PAYMENT с выбранным radio button PS4", retryAnalyzer= RetryAnalyzer.class)
    @Severity(value = SeverityLevel.CRITICAL)
    public void testInterestPage_2_2() {
        interestPage.clickToPS()
                .clickToButtonNextSectionPayment();
        assertTrue(interestPage.getActiveTabText().toUpperCase().contains(PAYMENT_TAB_NAME), "Активная вкладка должна быть " + PAYMENT_TAB_NAME + ", но найдено: " + interestPage.getActiveTabText());
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Interest")
    @Story(value = "Ввод данных валидных данных")
    @Test(description = "ID 2.3. Проверка перехода на вкладку PAYMENT с выбранным radio button XBOX", retryAnalyzer= RetryAnalyzer.class)
    @Severity(value = SeverityLevel.CRITICAL)
    public void testInterestPage_2_3() {
        interestPage.clickToXbox()
                .clickToButtonNextSectionPayment();
        assertTrue(interestPage.getActiveTabText().toUpperCase().contains(PAYMENT_TAB_NAME), "Активная вкладка должна быть " + PAYMENT_TAB_NAME + ", но найдено: " + interestPage.getActiveTabText());
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Interest")
    @Story(value = "Ввод данных невалидных данных")
    @Test(description = "ID 2.4. Попытка выбрать оба варианта", retryAnalyzer= RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testInterestPage_2_4() {
        interestPage.clickToXbox()
                .clickToPS();
        FormModel formModel = interestPage.getFormModel();
        assertTrue(formModel.getType().contains(PS_SELECTED_TEXT), "Выбрано должно быть " + PS_SELECTED_TEXT + ", но найдено: " + formModel.getType());
    }
}