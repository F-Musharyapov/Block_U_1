package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InterestPage;

import static org.testng.Assert.assertTrue;

/**
 * Класс тестирования вкладки Interest
 */
public class InterestPageTest extends BaseTest {

    /**
     * Экземпляр вкладки InterestPage
     */
    private InterestPage interestPage;

    /**
     * Метод предусловие перед тестами и инициализация вкладки
     */
    @BeforeMethod
    public void profileClickNext() {
        interestPage = new InterestPage(driver);
        interestPage.clickToButtonNextSectionInterests();
    }

    @Test(description = "ID 2.1. Проверка перехода на вкладку PAYMENT без выбранного radio button")
    public void testInterestPage_2_1() {
        interestPage.clickToButtonNextSectionPayment();
        assertTrue(interestPage.getActiveTabText().toUpperCase().contains("PAYMENT"), "Активная вкладка должна быть 'Payment', но найдено: " + interestPage.getActiveTabText());
    }

    @Test(description = "ID 2.2. Проверка перехода на вкладку PAYMENT с выбранным radio button PS4")
    public void testInterestPage_2_2() {
        interestPage.clickToPS()
                .clickToButtonNextSectionPayment();
        assertTrue(interestPage.getActiveTabText().toUpperCase().contains("PAYMENT"), "Активная вкладка должна быть 'Payment', но найдено: " + interestPage.getActiveTabText());
    }

    @Test(description = "ID 2.3. Проверка перехода на вкладку PAYMENT с выбранным radio button XBOX")
    public void testInterestPage_2_3() {
        interestPage.clickToXbox()
                .clickToButtonNextSectionPayment();
        assertTrue(interestPage.getActiveTabText().toUpperCase().contains("PAYMENT"), "Активная вкладка должна быть 'Payment', но найдено: " + interestPage.getActiveTabText());
    }

    @Test(description = "ID 2.4. Попытка выбрать оба варианта")
    public void testInterestPage_2_4() {
        interestPage.clickToXbox()
                .clickToPS();
        assertTrue(interestPage.getJsonText().toUpperCase().contains("PS"), "Выбрано должно быть 'PS', но найдено: " + interestPage.getJsonText());
    }
}
