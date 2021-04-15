import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

/*
 * Тест 8 - Удаление блока рекламы на YANDEX.RU через JavaScript
 */
public class JSvsADV {

    @Test (groups = {"web", "yandex", "js", "interactive"})
    public static void main() {
        // Подключение драйвера Google Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // JavaScript
        JavascriptExecutor js = (JavascriptExecutor)driver;

        try {
            driver.get("http://yandex.ru/");
            Thread.sleep(3000);
            // Удаление блока рекламы через выполнение JavaScript с установкой атрибута "display"
            js.executeScript("document.querySelector" +
                    "('.container.container__banner.container__line.container__banner_flex')" +
                    ".setAttribute('style', 'display: none')"
            );
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
