import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class DropdownTest {
    @Test
    public void DropdownElement() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notfications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> dropdowns = dropdown.getOptions();
        System.out.println("Всего элементов в выпадающем списке: " + dropdowns.size());
        dropdown.selectByIndex(1);
        System.out.println("Успешно выбран первый элемент: " + dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Option 2");
        System.out.println("Успешно выбран второй элемент: " + dropdown.getFirstSelectedOption().getText());
        driver.quit();
    }
}
