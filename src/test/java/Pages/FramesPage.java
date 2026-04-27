package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FramesPage {

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    WebDriver driver;
    WebDriverWait wait;

    private final By TITLE_FRAMES_PAGE = By.xpath("//H3");
    private final By HYPERLINK_IFRAME = By.xpath("//a[text()='iFrame']");

    public void openFramesPage() {
        driver.get("https://the-internet.herokuapp.com/frames");
    }

    public void isFramesPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_FRAMES_PAGE));
    }

    public String getTextElementTitleFramesPages() {
        return driver.findElement(TITLE_FRAMES_PAGE).getText();
    }

    public void clickHyperlinkIframe() {
        driver.findElement(HYPERLINK_IFRAME).click();
    }
}