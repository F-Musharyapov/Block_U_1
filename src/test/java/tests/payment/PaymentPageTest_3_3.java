package tests.payment;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PaymentPage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;

/**
 * Класс тестирования тест-кейса 3.3. вкладки Payment
 */
public class PaymentPageTest_3_3 extends BaseTest {

    /**
     * Экземпляр класса PaymentPage
     */
    private PaymentPage paymentPage;

    /**
     * Метод предусловие перед тестом
     */
    @BeforeMethod
    public void profileClickNext() {
        paymentPage.clickToButtonNextSectionInterests()
                .clickToXbox()
                .clickToButtonNextSectionPayment();
    }

    @Test(description = "ID 3.3. Отправка с выбранным интересом")
    public void testForm() {
        paymentPage.clickToButtonSubmit();
        assertTrue(paymentPage.getAlertText().contains("awesome!"), "Текст предупреждения не содержит ожидаемого сообщения.");
        paymentPage.acceptAlert();
    }
}
