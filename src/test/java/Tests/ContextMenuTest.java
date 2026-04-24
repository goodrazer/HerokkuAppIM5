package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class ContextMenuTest extends BaseTest{

    @Test

    public void checkContextMenu() {
        SoftAssert softAssert = new SoftAssert();
        contextMenu.openPageContextMenu();
        contextMenu.clickContextMenu();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String actualTextAlert = alert.getText();
        String expectedTextAlert = "You selected a context menu";
        softAssert.assertEquals(expectedTextAlert, actualTextAlert,
                "Текст алерта не соответствует ожидаемому!");
        alert.accept();
        softAssert.assertEquals(contextMenu.getTextElementTitleContextMenu(),
                "Context Menu", "Модальное окно 'Alert' не закрылось!");
        softAssert.assertAll();
    }
}
