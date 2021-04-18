package DemoTestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static Modules.WebDriverCreator.webDriverCreator;

public class driversTests {

    @Test (
            groups = {"demo", "drivers", "web", "yandex"},
            dependsOnGroups = {"test_N"},
            alwaysRun = false
    )
    public static void main () {
        String url = "http://ya.ru/";

        // Подключение веб-драйвера на выбор: "Chrome", "Firefox", "Edge"
        WebDriver driverEdge = webDriverCreator("Edge");
        WebDriver driverFirefox = webDriverCreator("Firefox");
        WebDriver driverChrome = webDriverCreator("Chrome");

        try {
            // Запрос в каждом броузере
            driverEdge.get(url);
            driverFirefox.get(url);
            driverChrome.get(url);

            Thread.sleep(1000);

            // Закрыть каждый броузер
            driverEdge.quit();
            driverFirefox.quit();
            driverChrome.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driverEdge.quit();
            driverFirefox.quit();
            driverChrome.quit();
        }

    }
}
