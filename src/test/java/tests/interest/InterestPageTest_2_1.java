package tests.interest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InterestPage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;

/**
 * Класс тестирования тест-кейса 2.1. вкладки Interest
 */
public class InterestPageTest_2_1 extends BaseTest {

    /**
     * Экземпляр класса InterestPage
     */
    private InterestPage interestPage;

    /**
     * Метод предусловие перед тестом
     */
    @BeforeMethod
    public void profileClickNext() {
        interestPage.clickToButtonNextSectionInterests();
    }

    @Test(description = "ID 2.1. Проверка перехода на вкладку PAYMENT без выбранного radio button")
    public void testInterestPage() {
        interestPage.clickToButtonNextSectionPayment();
        assertTrue(interestPage.getActiveTabText().toUpperCase().contains("PAYMENT"), "Активная вкладка должна быть 'Payment', но найдено: " + interestPage.getActiveTabText());
    }
}
