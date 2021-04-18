import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static Modules.WebDriverCreator.webDriverCreator;

/*
 * Тест 1 - ввод запроса на GOOGLE.COM через экранную клавиатуру
 */
public class GoogleKeyboard {

    @Test (groups = {"web", "google", "interactive"})
    public static void main() {
        // Подключение веб-драйвера на выбор: "Chrome", "Firefox", "Edge"
        WebDriver driver = webDriverCreator("Chrome");

        try {
            Thread.sleep(2000);
            driver.get("http://google.com");

            // Клик в кнопку вызова экранной клавиатуры
            driver.findElement(By.cssSelector("div[aria-label='Экранная клавиатура']")).click();
            // Явное ожидание появления экранной клавиатуры
            WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(5))).until(ExpectedConditions
                    .presenceOfElementLocated(By.cssSelector("div.ita-container.ita-container-vertical.notranslate.vk-box")));
            // Неявное ожидание
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Набор текста запроса на экранной клавиатуре
            driver.findElement(By.cssSelector("#K78")).click();
            driver.findElement(By.cssSelector("#K84")).click();
            driver.findElement(By.cssSelector("#K67")).click();
            driver.findElement(By.cssSelector("#K78")).click();

            // Закрыть экранную клавиатуру
            driver.findElement(By.cssSelector(".vk-t-btns")).click();

            // Старт поиска
            driver.findElement(By.cssSelector("input[aria-label='Найти']")).sendKeys("", Keys.ENTER);

            Thread.sleep(3000);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
