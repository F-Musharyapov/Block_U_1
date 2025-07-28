package tests.profile;

import org.testng.annotations.Test;
import pages.ProfilePage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;
import static utils.TestData.getFakeEmail;

/**
 * Класс тестирования тест-кейса 1.6. вкладки Profile
 */
public class ProfilePageTest_1_6 extends BaseTest {

    @Test(description = "ID 1.6. Проверка ввода некорректного email")
    public void testForm() {
        ProfilePage profilePage = new ProfilePage(driver)
                .inputEmail(getFakeEmail())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains("INTERESTS"), "Активная вкладка должна быть 'Interests', но найдено: " + profilePage.getActiveTabText());
    }
}
