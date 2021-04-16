import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

/*
 * Тест 9 - Проверка <title> страницы (TestNG)
 */
public class CheckTitleSite {

    // URL страницы и проверяемое значение тега "title"
    @Parameters ({"url", "title"})
    @Test (groups = {"web", "grabber"})
    public static void main(String url, String title) {
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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
