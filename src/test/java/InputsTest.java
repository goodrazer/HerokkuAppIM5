import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InputsTest {
    @Test
    public void InputsElement() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notfications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("100");
        inputField.sendKeys(Keys.ARROW_UP);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inputField.getAttribute("value"), "101", "Ошибка при нажатии ARROW_UP");
        inputField.sendKeys(Keys.ARROW_DOWN);
        inputField.sendKeys(Keys.ARROW_DOWN);
        softAssert.assertEquals(inputField.getAttribute("value"), "99", "Ошибка при нажатии ARROW_DOWN");
        inputField.clear();
        inputField.sendKeys("Ввожу текст на русском для примера");
        softAssert.assertEquals(inputField.getAttribute("value"), "", "Поле приняло кириллицу, а не должно");
        inputField.clear();
        inputField.sendKeys("I'm entering text in English as an example");
        softAssert.assertEquals(inputField.getAttribute("value"), "", "Поле приняло латиницу, а не должно");
        inputField.clear();
        inputField.sendKeys("%*&&%#*%&@&(*&@+@+$!+");
        softAssert.assertEquals(inputField.getAttribute("value"), "", "Поле приняло спецсимволы, а не должно");
        driver.quit();
        softAssert.assertAll();
    }
}