package Modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverCreator {
    // Подключение веб-драйвера на выбор: "Chrome", "Firefox", "Edge"
    public static WebDriver webDriverCreator(String webDriverName) {
        switch (webDriverName) {
            case ("Chrome") :
                // Подключение драйвера Google Chrome
                System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");
                WebDriver driverChrome = new ChromeDriver();
                driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                return driverChrome;
            case ("Firefox") :
                // Подключение драйвера Firefox
                System.setProperty("webdriver.gecko.driver", "C:\\java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
                WebDriver driverFirefox = new FirefoxDriver();
                driverFirefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                return driverFirefox;
            case ("Edge"):
                // Подключение драйвера Microsoft Edge
                System.setProperty("webdriver.edge.driver", "C:\\Windows\\System32\\MicrosoftWebDriver.exe");
                WebDriver driverEdge = new EdgeDriver();
                driverEdge.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                return driverEdge;
            default:
                // Подключение драйвера Google Chrome по умолчанию
                System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                return driver;
        }
    }
}
