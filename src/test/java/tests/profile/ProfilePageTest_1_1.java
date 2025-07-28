package tests.profile;

import org.testng.annotations.Test;
import pages.ProfilePage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;

/**
 * Класс тестирования тест-кейса 1.1. вкладки Profile
 */
public class ProfilePageTest_1_1 extends BaseTest {

    @Test(description = "ID 1.1. Проверка перехода на вкладку INTERESTS без заполнения данных")
    public void testForm() {
        ProfilePage profilePage = new ProfilePage(driver)
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains("INTERESTS"), "Активная вкладка должна быть 'Interests', но найдено: " + profilePage.getActiveTabText());
    }
}
