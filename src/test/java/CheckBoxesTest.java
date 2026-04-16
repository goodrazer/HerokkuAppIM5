import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class CheckBoxesTest {

    @Test
    public void CheckBoxesActiveElement() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notfications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement checkbox1 = checkboxes.get(0);
        WebElement checkbox2 = checkboxes.get(1);
        Assert.assertFalse(checkbox1.isSelected());
        System.out.println("Проверка, что первый чек-бокс деактивирован (по-дефолту) - Успешна!");
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
        System.out.println("Проверка, что первый чек-бокс активирован - Успешна!");
        Assert.assertTrue(checkbox2.isSelected());
        System.out.println("Проверка, что второй чек-бокс активирован (по-дефолту) - Успешна!");
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());
        System.out.println("Проверка, что второй чек-бокс деактивирован - Успешна!");
        driver.quit();
    }
}
