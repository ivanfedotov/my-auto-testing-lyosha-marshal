package Modules;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {
    private int actualRetry = 0;
    private static final int MAX_RETRY = 3;

    // Повторный запуск тестов
    public boolean retry(ITestResult result) {
        if (actualRetry < MAX_RETRY){
            actualRetry++;
            return true;
        } else {
            return false;
        }
    }
}