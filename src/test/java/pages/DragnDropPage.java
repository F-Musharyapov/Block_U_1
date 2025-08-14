package pages;

import config.BaseConfig;
import io.qameta.allure.Step;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitUntilPresent;
import static utils.Waiters.waitUntilVisible;

/**
 * Класс с методами для взаимодействия с DragnDrop
 */
public class DragnDropPage extends BasePage {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Конструктор создания страницы CookiesPage
     *
     * @param driver драйвер для управления браузером
     */
    public DragnDropPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Конструктор Actions
     */
    Actions actions = new Actions(driver);

    /**
     * Локатор для iframe
     */
    @FindBy(css = "iframe.demo-frame[src*='droppable/default.html']")
    private WebElement iframe;

    /**
     * Локатор для draggable
     */
    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement draggable;

    /**
     * Локатор для droppable
     */
    @Getter
    @FindBy(xpath = "//div[@id='droppable']")
    private WebElement droppable;

    /**
     * Метод перехода на frame
     *
     * @return текущая страница
     */
    @Step("Переход на frame")
    public DragnDropPage switchToIframe() {
        waitUntilPresent(driver, iframe);
        driver.switchTo().frame(iframe);
        return this;
    }

    /**
     * Метод перетаскивания draggable в область droppable
     *
     * @return текущая страница
     */
    @Step("Перетаскивание draggable в область droppable")
    public DragnDropPage dragAndDropElement() {
        waitUntilVisible(driver, draggable);
        actions.dragAndDrop(draggable, droppable)
                .perform();
        return this;
    }
}