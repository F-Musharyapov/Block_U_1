package tests;

import org.testng.annotations.Test;
import pages.PaymentPage;

import static org.testng.Assert.assertTrue;
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

    @Test(description = "ID 3.1. Отправка пустой формы")
    public void testPaymentPage_3_1() {
        paymentPage = new PaymentPage(driver)
                .clickToButtonNextSectionInterests()
                .clickToButtonNextSectionPayment()
                .clickToButtonSubmit();
        assertTrue(paymentPage.getAlertText().contains("awesome!"), "Текст предупреждения не содержит ожидаемого сообщения.");
        paymentPage.acceptAlert();
    }

    @Test(description = "ID 3.2. Отправка с заполненным именем")
    public void testPaymentPage_3_2() {
        paymentPage = new PaymentPage(driver)
                .inputName(getValideName())
                .clickToButtonNextSectionInterests()
                .clickToButtonNextSectionPayment()
                .clickToButtonSubmit();
        assertTrue(paymentPage.getAlertText().contains("awesome!"), "Текст предупреждения не содержит ожидаемого сообщения.");
        paymentPage.acceptAlert();
    }

    @Test(description = "ID 3.3. Отправка с выбранным интересом")
    public void testPaymentPage_3_3() {
        paymentPage = new PaymentPage(driver)
                .clickToButtonNextSectionInterests()
                .clickToXbox()
                .clickToButtonNextSectionPayment()
                .clickToButtonSubmit();
        assertTrue(paymentPage.getAlertText().contains("awesome!"), "Текст предупреждения не содержит ожидаемого сообщения.");
        paymentPage.acceptAlert();
    }

    @Test(description = "ID 3.4. Отправка со всеми заполненными полями")
    public void testPaymentPage_3_4() {
        paymentPage = new PaymentPage(driver)
                .inputName(getValideName())
                .inputEmail(getValideEmail())
                .clickToButtonNextSectionInterests()
                .clickToPS()
                .clickToButtonNextSectionPayment()
                .clickToButtonSubmit();
        assertTrue(paymentPage.getAlertText().contains("awesome!"), "Текст предупреждения не содержит ожидаемого сообщения.");
        paymentPage.acceptAlert();
    }
}
