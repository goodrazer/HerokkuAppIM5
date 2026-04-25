package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicControlsPage {

    WebDriver driver;
    WebDriverWait wait;
    private final By BUTTON_REMOVE = By.xpath("//button[text()='Remove']");
    private final By ELEMENT_ITS_GONE = By.id("message");
    private final By ELEMENT_CHECKBOX = By.cssSelector("#checkbox");
    private final By ELEMENT_INPUT = By.xpath("//input[@type='text']");
    private final By BUTTON_ENABLE = By.xpath("//button[text()='Enable']");
    private final By ELEMENT_ITS_ENABLED = By.id("message");
    private final By ELEMENT_TITLE_DYNAMIC_CONTROLS = By.xpath("//H4");

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openDynamicControlsPage() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    public String getTextElementTitleDynamicControls() {
        return driver.findElement(ELEMENT_TITLE_DYNAMIC_CONTROLS).getText();
    }

    public void clickButtonRemove() {
        driver.findElement(BUTTON_REMOVE).click();
    }

    public String getTextElementItsGone() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ELEMENT_ITS_GONE)).getText();
    }

    public boolean checkElementCheckboxDisplayed() {
        return driver.findElements(ELEMENT_CHECKBOX).isEmpty();
    }

    public boolean checkElementInputDisplayed() {
        return driver.findElements(ELEMENT_INPUT).isEmpty();
    }

    public void clickButtonEnable() {
        driver.findElement(BUTTON_ENABLE).click();
    }

    public String getTextElementItsEnabled() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ELEMENT_ITS_ENABLED)).getText();
    }
}