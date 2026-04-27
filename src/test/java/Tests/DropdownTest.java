package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
        SoftAssert softAssert = new SoftAssert();
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> dropdownsAllOptions = dropdown.getOptions();
        softAssert.assertEquals(dropdownsAllOptions.size(), 3, "Количество элементов не равно 3!");
        dropdown.selectByIndex(1);
        String firstSelected = dropdown.getFirstSelectedOption().getText();
        softAssert.assertEquals(firstSelected, "Option 1", "Первый элемент не выбран!");
        dropdown.selectByIndex(2);
        String secondSelected = dropdown.getFirstSelectedOption().getText();
        softAssert.assertEquals(secondSelected, "Option 2", "Второй элемент не выбран!");
        driver.quit();
        softAssert.assertAll();
    }
}