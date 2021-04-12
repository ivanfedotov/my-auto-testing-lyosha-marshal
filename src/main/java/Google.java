import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
 * Тест 1 - ввод запроса на GOOGLE.COM через экранную клавиатуру
 */
public class Google {
    public static void main(String[] args) {
        // Подключение драйвера Google Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");

        // Запрос
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        // Клик в строку поиска
        // WebElement input = driver.findElement(By.xpath("input[@aria-label='Найти']"));
        // input.click();

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
    }
}
