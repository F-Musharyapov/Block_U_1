package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BankingSampleFormPage;
import utils.RetryAnalyzer;

import static org.testng.Assert.assertEquals;
import static utils.TestData.*;

/**
 * Класс тестирования страницы BankingSampleFormPage
 */
public class BankingSampleFormTest extends BaseTest {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Экземпляр страницы BankingSampleFormPage
     */
    private BankingSampleFormPage bankingSampleFormPage;

    /**
     * Метод предусловие для инициализации
     */
    @BeforeMethod
    public void initialsBefore() {
        driver.get(config.bankingUrl());
        bankingSampleFormPage = new BankingSampleFormPage(driver);
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Sample Form")
    @Test(description = "Тестирование формы в интерфейсе Sample Form", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testSampleForm() {
        bankingSampleFormPage.clickButtonSampleForm()
                .inputFirstName(generateFirstName())
                .inputLastName(generateLastName())
                .inputEmail(getValideEmail())
                .inputPassword(generatePassword())
                .clickCheckBoxSports()
                .selectGenderType()
                .inputAbout("Самое длинное слово из предложенных хобби - " + bankingSampleFormPage.findLongestLabel())
                .clickButtonRegister();

        assertEquals(bankingSampleFormPage.getSuccessMessage().getText(), SUCCESS_MESSAGE, "Сообщение не совпадает");
    }
}