import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

/*
 * Тест 6 - Ожидания и работа с модальными окнами ("alert", "prompt" и "confirm")
 */
public class Alerts {
    public static void main(String[] args) {
        // Подключение драйвера Google Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Явные ожидания для alerts
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Тестовая страница "alerts.html" запущенная через Live Server
            driver.get("http://127.0.0.1:5500/src/main/resources/alerts.html");
            Thread.sleep(1000);

            // Ссылки на модальные окна типов "alert", "prompt" и "confirm"
            WebElement linkA = driver.findElement(By.cssSelector("#a"));
            WebElement linkB = driver.findElement(By.cssSelector("#b"));
            WebElement linkC = driver.findElement(By.cssSelector("#c"));

            linkA.click();
            // Устаревший способ работы с alerts
            // Alert alert = driver.switchTo().alert();
            // Актуальный способ работы с alerts
            Alert alert1 = wait.until(alertIsPresent());
            Thread.sleep(1000); // Задержка, чтоб видеть модальное окно
            alert1.accept();
            Thread.sleep(1000); // Задержка, чтоб видеть модальное окно

            linkB.click();
            Alert prompt = wait.until(alertIsPresent());
            Thread.sleep(500); // Задержка, чтоб видеть модальное окно
            prompt.sendKeys("Тестовый ввод");
            Thread.sleep(500); // Задержка, чтоб видеть модальное окно
            prompt.accept();
            Thread.sleep(500); // Задержка, чтоб видеть модальное окно
            Alert alert2 = wait.until(alertIsPresent());
            Thread.sleep(500); // Задержка, чтоб видеть модальное окно
            alert2.accept();
            Thread.sleep(500); // Задержка, чтоб видеть модальное окно

            linkC.click();
            Alert alert3 = wait.until(alertIsPresent());
            Thread.sleep(1000); // Задержка, чтоб видеть модальное окно
            alert3.dismiss();
            Thread.sleep(1000); // Задержка, чтоб видеть модальное окно

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
