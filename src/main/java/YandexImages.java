import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

import static Modules.WebDriverCreator.webDriverCreator;

/*
 * Тест 3 - Поиск похожих картинок на YANDEX.RU
 */
public class YandexImages {

    @Test (groups = {"web", "yandex", "interactive"})
    public static void main() {
        // Путь к картинке относительно папки проекта с названием файла
        String image = "\\src\\main\\resources\\ava.jpg";

        // Абсолютный путь к картинке
        File file = new File("");
        String path = file.getAbsolutePath() + image;

        // Подключение веб-драйвера на выбор: "Chrome", "Firefox", "Edge"
        WebDriver driver = webDriverCreator("Chrome");

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
