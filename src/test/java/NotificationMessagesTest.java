import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class NotificationMessagesTest {
    @Test
    public void NotificationMessages() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notfications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        WebElement button = driver.findElement(By.linkText("Click here"));
        button.click();
        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        String alertText = flash.getText();
        System.out.println("Ожидаем, что выведен текст: 'Action successful'.");
        System.out.println("В информационном окне отображен текст: " + alertText);
        if (alertText.contains("Action successful")) {
            System.out.println("Тест пройден, информациооное окно отображено, текст соответствует!");
        } else {
            System.out.println("Тест не пройден! Информациооное окно не отображено, либо текст не соответствует! " + alertText);
        }
        driver.quit();
    }

}
