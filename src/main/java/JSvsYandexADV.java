import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static Modules.WebDriverCreator.webDriverCreator;

/*
 * Тест 8 - Удаление блока рекламы на YANDEX.RU через JavaScript
 */
public class JSvsYandexADV {

    @Test (groups = {"web", "yandex", "js", "interactive"})
    public static void main() {
        // Подключение веб-драйвера на выбор: "Chrome", "Firefox", "Edge"
        WebDriver driver = webDriverCreator("Chrome");

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
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
