import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

/*
 * Тест 9 - Проверка <title> страницы (TestNG)
 */
public class CheckTitle {
    public static void main(String[] args) {
        // URL страницы и проверяемое значение тега "title"
        String url = "http://yandex.ru/", title = "Яндекс";

        // Подключение драйвера Google Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            driver.get(url);
            Thread.sleep(3000);
            // Значение тега "title" на странице
            String pageTitle = driver.getTitle();
            // Проверка соответсвия значения тега <title>
            Assert.assertEquals(pageTitle, title);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
