package tests;

import config.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.AshotScreenshot;
import utils.DriverFactory;

import java.time.Duration;

/**
 * Общий класс с настройками для всех тестов
 */
public class BaseTest {

    /**
     * Переменная с экземпляром драйвера
     */
    protected WebDriver driver;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Общие настройки для всех тестов, перед выполнением каждого теста
     *
     * @param browser строка с параметром названия браузера
     * @param grid    строка с параметром использование Selenium GRID
     * @throws Exception если не нашелся подходящий браузер
     */
    @BeforeMethod
    @Parameters({"browser", "grid"})
    public void setUp(String browser, boolean grid) throws Exception {

        if (grid) {
            driver = DriverFactory.getGridDriver(browser);
        } else if (!(grid)) {
            driver = DriverFactory.getWebDriver(browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
    }

    /**
     * Завершающий метод выхода из драйвера для всех тестов
     */
    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE && driver != null) {
                AshotScreenshot.makeScreenShot(driver);
            }
        } catch (Exception e) {
            System.err.println("Скриншот не создался, ошибка " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}