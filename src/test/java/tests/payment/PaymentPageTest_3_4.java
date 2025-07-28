package tests.payment;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PaymentPage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;
import static utils.TestData.getValideEmail;
import static utils.TestData.getValideName;

/**
 * Класс тестирования тест-кейса 3.4. вкладки Payment
 */
public class PaymentPageTest_3_4 extends BaseTest {

    /**
     * Экземпляр класса PaymentPage
     */
    private PaymentPage paymentPage;

    /**
     * Метод предусловие перед тестом
     */
    @BeforeMethod
    public void profileClickNext() {
        paymentPage.inputName(getValideName())
                .inputEmail(getValideEmail())
                .clickToButtonNextSectionInterests()
                .clickToPS()
                .clickToButtonNextSectionPayment();
    }

    @Test(description = "ID 3.4. Отправка со всеми заполненными полями")
    public void testForm() {
        paymentPage.clickToButtonSubmit();
        assertTrue(paymentPage.getAlertText().contains("awesome!"), "Текст предупреждения не содержит ожидаемого сообщения.");
        paymentPage.acceptAlert();
    }
}
