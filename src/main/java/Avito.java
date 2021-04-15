import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

/*
 * Тест 2 - Поиск по марке автомобиля количества объявлений на AVITO.RU
 */
public class Avito {

    @Test (groups = {"web", "avito", "interactive", "grabber"})
    public static void main() {
        // Марка автомобиля
        String brand = "BMW"; // Audi, BMW, Chevrolet, Ford, Hyundai, Nissan, Skoda, Subaru, Toyota, Volvo, ВАЗ (LADA)

        // Подключение драйвера Google Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");

        // Запрос
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Неявное ожидание
        driver.get("https://www.avito.ru/rossiya/avtomobili");

        System.out.println("Бренд: \"" + brand + "\"");

        // Поиск ссылки на категорию
        WebElement categoryURL = driver.findElement(By.cssSelector(
                "a[title='" + brand + "']"
        ));
        String url = categoryURL.getAttribute("href");
        System.out.println("Ссылка на категорию: " + url);

        // Поиск количества объявлений в категории
        WebElement categoryCount = driver.findElement(By.cssSelector(
                "a[title='" + brand + "']+span[data-marker='popular-rubricator/count']"
        ));
        String count = categoryCount.getText();
        System.out.println("Количество объявлений: " + count);

        driver.quit();
    }
}
