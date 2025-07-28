package tests.interest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InterestPage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;

/**
 * Класс тестирования тест-кейса 2.4. вкладки Interest
 */
public class InterestPageTest_2_4 extends BaseTest {

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

    @Test(description = "ID 2.4. Попытка выбрать оба варианта")
    public void testInterestPage() {
        interestPage.clickToXbox()
                .clickToPS();
        assertTrue(interestPage.getJsonText().toUpperCase().contains("PS"), "Выбрано должно быть 'PS', но найдено: " + interestPage.getJsonText());
    }
}
