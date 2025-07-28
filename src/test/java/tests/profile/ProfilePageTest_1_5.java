package tests.profile;

import org.testng.annotations.Test;
import pages.ProfilePage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;
import static utils.TestData.getFakeName;

/**
 * Класс тестирования тест-кейса 1.5. вкладки Profile
 */
public class ProfilePageTest_1_5 extends BaseTest {

    @Test(description = "ID 1.5. Проверка ввода невалидного имени")
    public void testForm() {
        ProfilePage profilePage = new ProfilePage(driver)
                .inputEmail(getFakeName())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains("INTERESTS"), "Активная вкладка должна быть 'Interests', но найдено: " + profilePage.getActiveTabText());
    }
}