package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.PaymentPage;

import static org.testng.Assert.assertTrue;
import static pages.PaymentPage.ALERT_TEXT;
import static utils.TestData.getValideEmail;
import static utils.TestData.getValideName;

/**
 * Класс тестирования вкладки  PaymentPage
 */
public class PaymentPageTest extends BaseTest {

    /**
     * Экземпляр вкладки PaymentPage
     */
    private PaymentPage paymentPage;

    @Epic(value = "Тестирование формы way2automation")
    @Feature(value = "Тестирование вкладки Payment")
    @Story(value = "Отправка без данных")
    @Test(description = "ID 3.1. Отправка пустой формы")
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
    @Test(description = "ID 3.2. Отправка с заполненным именем")
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
    @Test(description = "ID 3.3. Отправка с выбранным интересом")
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
    @Test(description = "ID 3.4. Отправка со всеми заполненными полями")
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