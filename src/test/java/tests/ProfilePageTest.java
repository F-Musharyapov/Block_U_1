package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProfilePage;

import static org.testng.Assert.assertTrue;
import static utils.TestData.*;

/**
 * Класс тестирования вкладки Profile
 */
public class ProfilePageTest extends BaseTest {

    /**
     * Экземпляр вкладки ProfilePage
     */
    private ProfilePage profilePage;

    /**
     * Метод предусловие перед тестами и инициализация вкладки
     */
    @BeforeMethod
    public void initialClass() {
        profilePage = new ProfilePage(driver);
    }

    @Test(description = "ID 1.1. Проверка перехода на вкладку INTERESTS без заполнения данных")
    public void testProfilePage_1_1() {
        profilePage.clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains("INTERESTS"), "Активная вкладка должна быть 'Interests', но найдено: " + profilePage.getActiveTabText());
    }

    @Test(description = "ID 1.2. Проверка перехода на вкладку INTERESTS с валидным именем")
    public void testProfilePage_1_2() {
        profilePage.inputName(getValideName())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains("INTERESTS"), "Активная вкладка должна быть 'Interests', но найдено: " + profilePage.getActiveTabText());
    }

    @Test(description = "ID 1.3. Проверка перехода на вкладку INTERESTS с валидной почтой")
    public void testProfilePage_1_3() {
        profilePage.inputEmail(getValideEmail())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains("INTERESTS"), "Активная вкладка должна быть 'Interests', но найдено: " + profilePage.getActiveTabText());
    }

    @Test(description = "ID 1.4. Проверка перехода на вкладку INTERESTS с валидным именем и почтой")
    public void testProfilePage_1_4() {
        profilePage.inputName(getValideName())
                .inputEmail(getValideEmail())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains("INTERESTS"), "Активная вкладка должна быть 'Interests', но найдено: " + profilePage.getActiveTabText());
    }

    @Test(description = "ID 1.5. Проверка ввода невалидного имени")
    public void testProfilePage_1_5() {
        profilePage.inputEmail(getFakeName())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains("INTERESTS"), "Активная вкладка должна быть 'Interests', но найдено: " + profilePage.getActiveTabText());
    }

    @Test(description = "ID 1.6. Проверка ввода некорректного email")
    public void testProfilePage_1_6() {
        profilePage.inputEmail(getFakeEmail())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains("INTERESTS"), "Активная вкладка должна быть 'Interests', но найдено: " + profilePage.getActiveTabText());
    }
}
