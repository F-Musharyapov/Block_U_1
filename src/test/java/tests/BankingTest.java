package tests;

import config.BaseConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BankingPage;
import utils.AshotScreenshot;
import utils.RetryAnalyzer;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.TestData.*;

/**
 * Класс тестирования страницы BankingSampleFormPage
 */
public class BankingTest {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Переменная с экземпляром драйвера
     */
    private WebDriver driver;

    /**
     * Экземпляр страницы BankingPage
     */
    private BankingPage bankingPage;

    /**
     * Переменная для поля firstName
     */
    private String firstNameCustomer = generateFirstName();

    /**
     * Переменная для поля lastName
     */
    private String lastNameCustomer = generateLastName();

    /**
     * Метод предусловие для инициализации
     */
    @BeforeClass
    public void initialsBefore() {
        System.setProperty(config.driverPropertyChrome(), config.driverPathChrome());

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        bankingPage = new BankingPage(driver);
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Sample Form")
    @Test(description = "5.1 - Тестирование формы в интерфейсе Sample Form", priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testSampleForm() {
        driver.get(config.bankingUrl());
        bankingPage
                .clickButtonSampleForm()
                .inputFirstNameSampleForm(generateFirstName())
                .inputLastNameSampleForm(generateLastName())
                .inputEmailSampleForm(getValideEmail())
                .inputPasswordSampleForm(generatePassword())
                .clickCheckBoxSportsSampleForm()
                .selectGenderTypeSampleForm()
                .inputAboutSampleForm("Самое длинное слово из предложенных хобби - " + bankingPage.findLongestLabel())
                .clickButtonRegisterSampleForm();

        assertEquals(bankingPage.getSuccessMessageSampleForm().getText(), SUCCESS_MESSAGE, "Сообщение не совпадает");
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Bank Manager Login")
    @Test(description = "5.2.1 - Тестирование формы создания аккаунта", priority = 2, dependsOnMethods = "testSampleForm", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testBankManager() {
        driver.get(config.bankingUrl());
        bankingPage
                .clickButtonBankManagerLogin()
                .clickTabAddCust()
                .inputFirstNameAddCustomer(firstNameCustomer)
                .inputLastNameAddCustomer(lastNameCustomer)
                .inputPostCodeAddCustomer(generateSimplePostCode())
                .clickButtonAddCust();

        assertTrue(bankingPage.getAlertText().contains(CUSTOMER_ADDED_SUCCESS_MESSAGE),
                "Alert не содержит ожидаемого сообщения.");

        bankingPage.acceptAlert();
    }

    @Epic(value = "Тестирование сайта way2automation.com")
    @Feature(value = "Интерфейсы")
    @Story(value = "Тестирование вкладки Bank Manager Login")
    @Test(description = "5.2.2 - Тестирование открытия аккаунта и добавления currency", priority = 3, dependsOnMethods = "testAddCustomer", retryAnalyzer = RetryAnalyzer.class)
    @Severity(value = SeverityLevel.NORMAL)
    public void testOpenAccount() {
        bankingPage
                .clickTabOpenAccount()
                .clickUserSelect()
                .selectCreatedCustomer(firstNameCustomer + " " + lastNameCustomer)
                .selectCurrency(getRandomCurrency())
                .clickButtonProcess();

        assertTrue(bankingPage.getAlertText().contains(CURRENCY_SUCCESS_MESSAGE),
                "Alert не содержит ожидаемого сообщения.");

        bankingPage.acceptAlert();
    }

    /**
     * Завершающий метод для скриншотов при неудаче
     */
    @AfterMethod
    public void afterScreenMethod(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE && driver != null) {
                AshotScreenshot.makeScreenShot(driver);
            }
        } catch (Exception e) {
            System.err.println("Скриншот не создался, ошибка " + e.getMessage());
        }
    }

    /**
     * Завершающий метод выхода из драйвера для всех тестов
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}