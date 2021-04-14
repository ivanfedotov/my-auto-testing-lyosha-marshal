import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

/*
 * Тест 7 - Запросы в разных окнах к GOOGLE.COM и к YANDEX.RU
 */
public class Windows {
    public static void main(String[] args) {
        // Поисковый запрос
        String word = "Selenium WebDriver";

        // Подключение драйвера Google Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Явные ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // JS (будет нужен для открытия нового окна)
        JavascriptExecutor js = (JavascriptExecutor)driver;

        try {

            // Поиск количества ответов на GOOGLE.COM
            driver.get("http://google.com");
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("input[aria-label='Найти']"))
                    .sendKeys(word, Keys.ENTER);
            System.out.println("[GOOGLE.COM] " +
                driver.findElement(By.cssSelector("#result-stats"))
                    .getText()
            );

            String window1 = driver.getWindowHandle();  // Дескриптор для 1-го окна
            String window2 = null;                      // Дескриптор для 2-го окна

            // Открытие нового окна
            js.executeScript("window.open()");

            // Дескрипторы всех открытых окон
            Set<String> windows = driver.getWindowHandles();

            // Поиск дескриптора 2-го окна
            for (String window : windows) {
                if (!window.equals(window1)) {
                    window2 = window;
                    break;
                }
            }

            // Переключение окон - на второе окно
            driver.switchTo().window(window2);

            // Поиск количества ответов на YANDEX.RU
            driver.get("https://ya.ru/");
            driver.findElement(By.cssSelector(".input__control.input__input.mini-suggest__input"))
                    .sendKeys(word, Keys.ENTER);
            System.out.println("[YANDEX.RU] " +
                driver.findElement(By.cssSelector(".serp-adv__found"))
                    .getText()
            );

            // Закрыть окно (без перехода в другое!)
            driver.close();

            // Переключение окон - на первое окно
            driver.switchTo().window(window1);
            driver.close();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
