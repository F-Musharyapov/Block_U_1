package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс с методами явного ожидания
 */
public class Waiters {

    /**
     * Ожидает в течение 15 секунд появления элемента на странице.
     *
     * @param driver  экземпляр драйвера браузера
     * @param element элемент
     */
    public static void waitUntilVisible(final WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Ожидает в течение 15 секунд появления алерта в браузере.
     *
     * @param driver экземпляр драйвера браузера
     */
    public static void waitForAlert(final WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Ожидает в течение 15 секунд элемент в DOM (даже если невидим)
     *
     * @param driver  экземпляр драйвера браузера
     * @param element элемент
     */
    public static void waitUntilPresent(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(d -> element.isDisplayed());
    }
}