package DemoTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class driversTests {

    @Test (groups = {"demo", "drivers", "web", "yandex"})
    public static void main () {
        String url = "http://ya.ru/";

        // Подключение драйвера Microsoft Edge
        System.setProperty("webdriver.edge.driver", "C:\\Windows\\System32\\MicrosoftWebDriver.exe");
        WebDriver driverEdge = new EdgeDriver();
        driverEdge.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Подключение драйвера Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        WebDriver driverFirefox = new FirefoxDriver();
        driverFirefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Подключение драйвера Google Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");
        WebDriver driverChrome = new ChromeDriver();
        driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        try {
            Thread.sleep(1000);
            System.out.println("t1");

            // Запрос в каждом броузере
            driverEdge.get(url);
            driverFirefox.get(url);
            driverChrome.get(url);
            Thread.sleep(5000);

            // Закрыть каждый броузер
            driverEdge.quit();
            driverFirefox.quit();
            driverChrome.quit();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driverEdge.quit();
            driverFirefox.quit();
            driverChrome.quit();
        }

    }
}
