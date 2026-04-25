package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class CheckBoxesTest {

    @Test
    public void checkBoxesActiveElement() {
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
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(checkbox1.isSelected(),"Чек-бокс активирован, не соответствует условию!");
        checkbox1.click();
        softAssert.assertTrue(checkbox1.isSelected(),"Чек-бокс не активирован, не соответствует условию!");
        softAssert.assertTrue(checkbox2.isSelected(), "Чек-бокс не активирован, не соответствует условию!");
        checkbox2.click();
        softAssert.assertFalse(checkbox2.isSelected(),"Чек-бокс активирован, не соответствует условию!");
        driver.quit();
        softAssert.assertAll();
    }
}