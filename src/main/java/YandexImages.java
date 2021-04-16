import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

/*
 * Тест 3 - Поиск похожих картинок на YANDEX.RU
 */
public class YandexImages {

    @Test (groups = {"web", "yandex", "interactive"})
    public static void main() {
        // Путь к картинке относительно папки проекта с названием файла
        String image = "\\src\\main\\resources\\ava.jpg";

        // Абсолютный путьк картинке
        File file = new File("");
        String path = file.getAbsolutePath() + image;

        // Подключение драйвера Google Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://yandex.ru/images/");

            // Выбор поиска по картинке
            driver.findElement(By.cssSelector("button[aria-label='Поиск по изображению']")).click();

            // Поиск по картинке
            WebElement inputImageSearch = driver.findElement(By.cssSelector(
                    "input.cbir-panel__file-input"
            ));
            inputImageSearch.sendKeys(path);

            Thread.sleep(5000);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
