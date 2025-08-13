package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitUntilVisible;

/**
 * Класс с методами для взаимодействия со страницей TabsPage
 */
public class TabsPage extends BasePage {

    /**
     * Конструктор создания страницы TabsPage
     *
     * @param driver драйвер для управления браузером
     */
    public TabsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локатор для iframe
     */
    @FindBy(xpath = "//*[@id=\"example-1-tab-1\"]/div/iframe")
    private WebElement iframe;

    /**
     * Локатор для link
     */
    @Getter
    @FindBy(xpath = "/html/body/div/p/a")
    private WebElement link;

    /**
     * Метод переключения на iframe
     *
     * @return текущая страница
     */
    @Step("Переключение на iframe")
    public TabsPage switchToIframe() {
        waitUntilVisible(driver, iframe);
        driver.switchTo().frame(iframe);
        return this;
    }

    /**
     * Метод клика по кнопке
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке")
    public TabsPage clikLink() {
        waitUntilVisible(driver, link);
        link.click();
        return this;
    }
}