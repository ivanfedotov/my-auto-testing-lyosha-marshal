import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Modules.WebDriverCreator.webDriverCreator;

/*
 * Тест 2 - Поиск по марке автомобиля количества объявлений на AVITO.RU
 */
public class AvitoAuto {
    // Бренды автомобилей
    @DataProvider (name = "autoBrands")
    public static Object[][] autoBrands () {
        return new Object[][] {
                {"Audi"},
//                {"BMW"},
//                {"Chevrolet"},
//                {"Ford"},
//                {"Hyundai"},
//                {"Nissan"},
//                {"Skoda"},
//                {"Subaru"},
//                {"Toyota"},
//                {"Volvo"},
//                {"ВАЗ (LADA)"}
        };
    }

    @Test (groups = {"web", "avito", "interactive", "grabber"}, dataProvider = "autoBrands")
    public static void main(String brand) {
        // Подключение веб-драйвера на выбор: "Chrome", "Firefox", "Edge"
        WebDriver driver = webDriverCreator("Chrome");

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
