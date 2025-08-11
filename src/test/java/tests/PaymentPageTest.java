package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PaymentPage;
import utils.RetryAnalyzer;

import static org.testng.Assert.assertTrue;
import static utils.TestData.*;

/**
 * Класс тестирования вкладки PaymentPage
 */
public class PaymentPageTest extends BaseTest {

    /**
     * Экземпляр вкладки PaymentPage
     */
    private PaymentPage paymentPage;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Метод предусловие перед тестами
     */
    @BeforeMethod
    public void profileClickNext() {
        driver.get(config.formUrl());
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Payment")
    @Story(value = "Отправка без данных")
    @Test(description = "ID 3.1. Отправка пустой формы", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testPaymentPage_3_1() {
        paymentPage = new PaymentPage(driver)
                .clickToButtonNextSectionInterests()
                .clickToButtonNextSectionPayment()
                .clickToButtonSubmit();
        assertTrue(paymentPage.getAlertText().contains(ALERT_TEXT), "Текст предупреждения не содержит ожидаемого сообщения.");
        paymentPage.acceptAlert();
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Payment")
    @Story(value = "Ввод данных валидных данных")
    @Test(description = "ID 3.2. Отправка с заполненным именем", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testPaymentPage_3_2() {
        paymentPage = new PaymentPage(driver)
                .inputName(getValideName())
                .clickToButtonNextSectionInterests()
                .clickToButtonNextSectionPayment()
                .clickToButtonSubmit();
        assertTrue(paymentPage.getAlertText().contains(ALERT_TEXT), "Текст предупреждения не содержит ожидаемого сообщения.");
        paymentPage.acceptAlert();
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Payment")
    @Story(value = "Ввод данных валидных данных")
    @Test(description = "ID 3.3. Отправка с выбранным интересом", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testPaymentPage_3_3() {
        paymentPage = new PaymentPage(driver)
                .clickToButtonNextSectionInterests()
                .clickToXbox()
                .clickToButtonNextSectionPayment()
                .clickToButtonSubmit();
        assertTrue(paymentPage.getAlertText().contains(ALERT_TEXT), "Текст предупреждения не содержит ожидаемого сообщения.");
        paymentPage.acceptAlert();
    }

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Payment")
    @Story(value = "Ввод данных валидных данных")
    @Test(description = "ID 3.4. Отправка со всеми заполненными полями", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.CRITICAL)
    public void testPaymentPage_3_4() {
        paymentPage = new PaymentPage(driver)
                .inputName(getValideName())
                .inputEmail(getValideEmail())
                .clickToButtonNextSectionInterests()
                .clickToPS()
                .clickToButtonNextSectionPayment()
                .clickToButtonSubmit();
        assertTrue(paymentPage.getAlertText().contains(ALERT_TEXT), "Текст предупреждения не содержит ожидаемого сообщения.");
        paymentPage.acceptAlert();
    }
}