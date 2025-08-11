package utils;

import config.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Класс для создания различных WebDriver в зависимости от входных параметров (любые браузеры, с GRID и без него)
 */
public class DriverFactory {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    static BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Метод для создания WebDriver без GRID
     *
     * @param browser строка с параметром названия браузера
     * @return необходимый driver с настройками для запуска
     * @throws Exception если не нашелся подходящий браузер
     */
    public static WebDriver getWebDriver(String browser) throws Exception {
        WebDriver driver;

        if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty(config.driverPropertyEdge(), config.driverPathEdge());
            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("InternetExplorer")) {
            InternetExplorerOptions options = new InternetExplorerOptions();
            System.setProperty(config.driverPropertyIE(), config.driverPathIE());
            options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
            options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
            options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            driver = new InternetExplorerDriver(options);

        } else {
            throw new Exception("Incorrect Browser");
        }
        return driver;
    }

    /**
     * Метод для создания WebDriver c GRID
     *
     * @param browser строка с параметром названия браузера
     * @return необходимый RemoteWebDriver с настройками для запуска через Selenium Grid
     * @throws Exception если не нашелся подходящий браузер
     */
    public static WebDriver getGridDriver(String browser) throws Exception {

        MutableCapabilities options;

        if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("platformName", "Windows");
            firefoxOptions.setCapability("se:name", "My test Firefox");
            firefoxOptions.setCapability("se:sampleMetadata", "Sample metadata value");
            options = firefoxOptions;

        } else if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platformName", "Windows");
            chromeOptions.setCapability("se:name", "My test Chrome");
            chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");
            options = chromeOptions;

        } else if (browser.equalsIgnoreCase("Edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setCapability("platformName", "Windows");
            edgeOptions.setCapability("se:name", "My test Edge");
            edgeOptions.setCapability("se:sampleMetadata", "Sample metadata value");
            options = edgeOptions;

        } else if (browser.equalsIgnoreCase("InternetExplorer")) {
            InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
            System.setProperty(config.driverPropertyIE(), config.driverPathIE());
            internetExplorerOptions.setCapability("platformName", "Windows");
            internetExplorerOptions.setCapability("se:name", "My test InternetExplorer");
            internetExplorerOptions.setCapability("se:sampleMetadata", "Sample metadata value");
            internetExplorerOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
            internetExplorerOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
            internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            internetExplorerOptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            options = internetExplorerOptions;

        } else {
            throw new Exception("Incorrect Browser");
        }
        return new RemoteWebDriver(new URL(config.remoteUrl()), options);
    }
}