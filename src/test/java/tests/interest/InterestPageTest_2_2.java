package tests.interest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InterestPage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;

/**
 * Класс тестирования тест-кейса 2.2. вкладки Interest
 */
public class InterestPageTest_2_2 extends BaseTest {

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

    @Test(description = "ID 2.2. Проверка перехода на вкладку PAYMENT с выбранным radio button PS4")
    public void testInterestPage() {
        interestPage.clickToPS()
                .clickToButtonNextSectionPayment();
        assertTrue(interestPage.getActiveTabText().toUpperCase().contains("PAYMENT"), "Активная вкладка должна быть 'Payment', но найдено: " + interestPage.getActiveTabText());
    }
}
