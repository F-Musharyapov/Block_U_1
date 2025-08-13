package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

import static utils.RobotPasteText.pasteText;
import static utils.Waiters.waitUntilVisible;

/**
 * Класс с методами для взаимодействия с BasicAuth
 */
public class BasicAuthPage extends BasePage {

    /**
     * Конструктор создания страницы BasicAuth
     *
     * @param driver драйвер для управления браузером
     */
    public BasicAuthPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локатор для кнопки Display Image
     */
    @FindBy(xpath = "//*[@id=\"displayImage\"]")
    private WebElement buttonDisplayImage;

    /**
     * Локатор элемента картинки успешной авторизации
     */
    @Getter
    @FindBy(xpath = "//img[@id]")
    public WebElement happyImage;

    /**
     * Метод для клика по кнопке Display Image
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке BasicAuthPage")
    public BasicAuthPage clikButtonDisplayImage() {
        waitUntilVisible(driver, buttonDisplayImage);
        buttonDisplayImage.click();
        return this;
    }

    /**
     * Метод вода данных basic auth
     *
     * @return текущая страница
     */
    @Step("Ввод данных basic auth")
    public BasicAuthPage inputDataAlert(String login, String password) throws AWTException {
        Robot robot = new Robot();

        pasteText(robot, login);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        pasteText(robot, password);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        waitUntilVisible(driver, happyImage);

        return this;
    }
}