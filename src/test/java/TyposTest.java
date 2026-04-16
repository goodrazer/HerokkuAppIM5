import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.List;

public class TyposTest {
    @Test
    public void TyposElement() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notfications");
        WebDriver driver = new ChromeDriver(options);
        for (int i = 1; i <= 10; i++) {
            driver.get("https://the-internet.herokuapp.com/typos");
            driver.navigate().refresh();
            List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
            String actualText = paragraphs.get(1).getText();
            String expectedText = "Sometimes you'll see a typo, other times you won,t.";
            if (actualText.equals(expectedText)) {
                System.out.println(actualText);
                System.out.println("Параграф не содержит орфографических ошибок.");
                System.out.println();
            } else {
                System.out.println(actualText);
                System.out.println("В параграфе есть ошибка!");
                System.out.println();
            }
        }
        driver.quit();
    }
}
