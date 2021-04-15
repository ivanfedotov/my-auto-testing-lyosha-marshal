import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*
 * Тест 4 - Перетаскивание одного элемента на другой (DRAG-AND-DROP)
 */
public class DragAndDrop {

    @Test (groups = {"web", "crossbrowsertesting", "interactive"})
    public static void main() throws InterruptedException {

        // Подключение драйвера Google Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            Thread.sleep(2000); // Ожидание 2 секунды
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");

            // Элементы для манипуляций
            WebElement element1 = driver.findElement(By.cssSelector("#draggable"));
            WebElement element2 = driver.findElement(By.cssSelector("#droppable"));

            Actions actions = new Actions(driver);

            // Вариант 1 - перетаскивание через набор действий
            /*
             actions
                     .moveToElement(element1)        // навести курсор на элемент 1
                     .clickAndHold()                 // кликнуть и держать
                     .pause(1000)                    // ждать 1 секунду
                     .moveToElement(element2)        // навести курсор на элемент 2
                     .release()                      // отпустить
                     .build()                        // собрать действия
                     .perform();                     // выполнить действия
            */

            // Вариант 2 - перетаскивание через функцию перетаскивания объектов
            actions.dragAndDrop(element1, element2).build().perform();

            // Вариант 3 - перетаскивание через функцию перетаскивания по смещению
            /*
             String offsetLeft = element2.getDomAttribute("offsetLeft");
             System.out.println(Integer.parseInt(offsetLeft));
             actions.dragAndDropBy(
                     element1,
                     Integer.parseInt(offsetLeft),
                     0
             ).build().perform();
            */

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(10000); // Ожидание 10 секунд
            driver.quit();
        }

    }
}
