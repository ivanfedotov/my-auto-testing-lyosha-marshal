import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Modules.WebDriverCreator.webDriverCreator;

/*
 * Тест 9 - Проверка <title> страницы (TestNG)
 */
public class CheckTitleSite {

    // URL страницы и проверяемое значение тега "title"
    @Parameters ({"url", "title"})
    @Test (groups = {"web", "grabber"})
    public static void main(String url, String title) {
        // Подключение веб-драйвера на выбор: "Chrome", "Firefox", "Edge"
        WebDriver driver = webDriverCreator("Chrome");

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
