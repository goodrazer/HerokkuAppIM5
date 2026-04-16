import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        System.out.println("Поле 'Input' успешно заполнено значением: 100.");
        inputField.sendKeys(Keys.ARROW_UP);
        String valAfterUp = inputField.getAttribute("value");
        System.out.println("После нажатия стрелки 'Вверх', поле 'Input' изменило значение на расчитанное по формуле: 100 + 1 = " + valAfterUp);
        Assert.assertEquals(valAfterUp, "101");
        inputField.sendKeys(Keys.ARROW_DOWN);
        inputField.sendKeys(Keys.ARROW_DOWN);
        String valAfterDown = inputField.getAttribute("value");
        System.out.println("После нажатия стрелки 'Вниз', поле 'Input' изменило значение на расчитанное по формуле: 100 - 1 = " + valAfterDown);
        Assert.assertEquals(valAfterDown, "99");
        inputField.clear();
        inputField.sendKeys("Ввожу текст на русском для примера");
        String valueAfterText1 = inputField.getAttribute("value");
        System.out.println("После ввода текста 'Ввожу текст на русском для примера' значение поля 'Input' не изменилось и = '" + valueAfterText1 + "'");
        Assert.assertEquals(valueAfterText1, "");
        inputField.clear();
        inputField.sendKeys("I'm entering text in English as an example");
        String valueAfterText2 = inputField.getAttribute("value");
        System.out.println("После ввода текста 'I'm entering text in English as an example' значение поля 'Input' не изменилось и = '" + valueAfterText2 + "'");
        Assert.assertEquals(valueAfterText2, "");
        inputField.clear();
        inputField.sendKeys("%*&&%#*%&@&(*&@+@+$!+");
        String valueAfterSymbol = inputField.getAttribute("value");
        System.out.println("После ввода ряда символов '%*&&%#*%&@&(*&@+@+$!+' значение поля 'Input' не изменилось и = '" + valueAfterSymbol + "'");
        Assert.assertEquals(valueAfterSymbol, "");
        driver.quit();
    }
}
