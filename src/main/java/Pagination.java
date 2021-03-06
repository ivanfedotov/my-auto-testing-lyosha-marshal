import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static Modules.WebDriverCreator.webDriverCreator;

/*
 * Тест 5 - Проход по пагинатору PAGINATION.JS с выводом всех значений с его страниц
 */
public class Pagination {
    // Идентификатор пагинатора со страницы проекта PAGINATION.JS
    String id = "demo1"; // demo1, demo7, demo8, demo12

    @DataProvider (name = "idPaginator")
    public static Object[][] idPaginator() {
        return new Object[][] {
            {"demo1"},
//            {"demo1"},
//            {"demo7"},
//            {"demo8"},
//            {"demo12"},
        };
    }

    @Test (groups = {"web", "pagination", "interactive"}, dataProvider = "idPaginator")
    public static void main(String id) {
        // Подключение веб-драйвера на выбор: "Chrome", "Firefox", "Edge"
        WebDriver driver = webDriverCreator("Chrome");

        // Ожидание для загрузки новой страницы пагинатора
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://pagination.js.org/");
            Thread.sleep(5000);

            List<WebElement> pages;     // Список страниц
            List<WebElement> elements;  // Список элементов страницы
            String text;                // Значние элемента
            int pageNext;               // Номера страниц
            int counter = 0;            // Счетчик

            // Проход по пагинатору и его страницам
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                // Вывод элементов страницы
                elements = driver.findElements(By.cssSelector("#" + id + " .data-container li"));
                for (WebElement element : elements) {
                    text = element.getText();
                    System.out.println(text);
                }
                // Поиск в пагинаторе следующей страницы
                pages = driver.findElements(By.cssSelector("#" + id + " .paginationjs-page a"));
                for (WebElement page : pages) {
                    pageNext = Integer.parseInt(page.getText());
                    if (pageNext == i + 1) {
                        // Переход на следующую страницу
                        page.click();
                        // Ожидание появления первого элемента новой страницы
                        wait.until(ExpectedConditions.stalenessOf(elements.get(0)));
                        break;
                    }
                    counter++;
                }
                // Досрочный выход при достижении конца пагинатора
                if (counter == pages.size())
                    break;
                else
                    counter = 0;
            }

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
