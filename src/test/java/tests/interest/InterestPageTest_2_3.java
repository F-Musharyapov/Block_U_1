package tests.interest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InterestPage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;

/**
 * Класс тестирования тест-кейса 2.3. вкладки Interest
 */
public class InterestPageTest_2_3 extends BaseTest {

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

    @Test(description = "ID 2.3. Проверка перехода на вкладку PAYMENT с выбранным radio button XBOX")
    public void testInterestPage() {
        interestPage.clickToXbox()
                .clickToButtonNextSectionPayment();
        assertTrue(interestPage.getActiveTabText().toUpperCase().contains("PAYMENT"), "Активная вкладка должна быть 'Payment', но найдено: " + interestPage.getActiveTabText());
    }
}
