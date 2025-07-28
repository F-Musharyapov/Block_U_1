package tests.profile;

import org.testng.annotations.Test;
import pages.ProfilePage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;
import static utils.TestData.getValideEmail;

/**
 * Класс тестирования тест-кейса 1.3. вкладки Profile
 */
public class ProfilePageTest_1_3 extends BaseTest {

    @Test(description = "ID 1.3. Проверка перехода на вкладку INTERESTS с валидной почтой")
    public void testForm() {
        ProfilePage profilePage = new ProfilePage(driver)
                .inputEmail(getValideEmail())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains("INTERESTS"), "Активная вкладка должна быть 'Interests', но найдено: " + profilePage.getActiveTabText());
    }
}
