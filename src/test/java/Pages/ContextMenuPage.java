package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.*;
import java.time.Duration;

public class ContextMenuPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By CONTEXT_MENU = By.id("hot-spot");
    private final By ELEMENT_TITLE_CONTEXT_MENU = By.xpath("//H3");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPageContextMenu() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }

    public String getTextElementTitleContextMenu() {
        return driver.findElement(ELEMENT_TITLE_CONTEXT_MENU).getText();
    }

    public void clickContextMenu () {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(CONTEXT_MENU)).perform();
    }
}