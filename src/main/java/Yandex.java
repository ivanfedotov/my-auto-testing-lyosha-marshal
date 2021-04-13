import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

/*
 * Тест 3 - Поиск похожих картинок на YANDEX.RU
 */
public class Yandex {
    public static void main(String[] args) {
        // Путь к картинке относительно папки проекта с названием файла
        String image = "\\src\\main\\resources\\ava.jpg";

        // Абсолютный путьк картинке
        File file = new File("");
        String path = file.getAbsolutePath() + image;

        // Подключение драйвера Google Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");

        // Запрос
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://yandex.ru/images/");

        // Выбор поиска по картинке
        driver.findElement(By.cssSelector("button[aria-label='Поиск по изображению']")).click();

        // Поиск по картинке
        WebElement inputImageSearch = driver.findElement(By.cssSelector(
                "input.cbir-panel__file-input"
        ));
        inputImageSearch.sendKeys(path);

    }
}
