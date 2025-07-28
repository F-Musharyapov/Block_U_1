package tests.profile;

import org.testng.annotations.Test;
import pages.ProfilePage;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;
import static utils.TestData.getValideName;

/**
 * Класс тестирования тест-кейса 1.2. вкладки Profile
 */
public class ProfilePageTest_1_2 extends BaseTest {

    @Test(description = "ID 1.2. Проверка перехода на вкладку INTERESTS с валидным именем")
    public void testForm() {
        ProfilePage profilePage = new ProfilePage(driver)
                .inputName(getValideName())
                .clickToButtonNextSectionInterests();
        assertTrue(profilePage.getActiveTabText().toUpperCase().contains("INTERESTS"), "Активная вкладка должна быть 'Interests', но найдено: " + profilePage.getActiveTabText());
    }
}
