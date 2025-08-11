package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Класс для перезапусков тестов
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    /**
     * Переменная для отслеживания количества попыток повторного запуска теста
     */
    private int retryCount = 0;

    /**
     * Максимальное количество попыток, которое будет выполнено при неудаче теста
     */
    private int maxRetryCount = 2;

    /**
     * Метод для повторного запуска теста
     *
     * @param result принимает результат теста
     * @return возвращает true для повтора теста и false для остановки если попыток больше чем в maxRetryCount
     */
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}