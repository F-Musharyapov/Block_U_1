package tests.payment;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PaymentPage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;
import static utils.TestData.getValideName;

/**
 * Класс тестирования тест-кейса 3.2. вкладки Payment
 */
public class PaymentPageTest_3_2 extends BaseTest {

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
                .clickToButtonNextSectionInterests()
                .clickToButtonNextSectionPayment();
    }

    @Test(description = "ID 3.2. Отправка с заполненным именем")
    public void testForm() {
        paymentPage.clickToButtonSubmit();
        assertTrue(paymentPage.getAlertText().contains("awesome!"), "Текст предупреждения не содержит ожидаемого сообщения.");
        paymentPage.acceptAlert();
    }
}
