package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class TyposTest {
    @Test
    public void TyposElement() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notfications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/typos");
        String expectedText = "Sometimes you'll see a typo, other times you won't.";
        SoftAssert softAssert = new SoftAssert();
        for (int i = 1; i <= 10; i++) {
            driver.navigate().refresh();
            WebElement paragraph = driver.findElement(By.xpath("//*[@id='content']/div/p[2]"));
            String actualText = paragraph.getText();
            softAssert.assertEquals(actualText, expectedText,
                    "Ошибка на итерации " + i + ". Текст не совпадает!");
        }
        driver.quit();
        softAssert.assertAll();
    }
}
