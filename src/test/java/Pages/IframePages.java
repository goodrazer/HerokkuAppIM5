package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class IframePages {

    public IframePages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    WebDriver driver;
    WebDriverWait wait;

    private final By TITLE_IFRAME_PAGE = By.xpath("//H3");
    private final By IFRAME_PARAGRAPH = By.tagName("textarea");

    public void isIframesPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_IFRAME_PAGE));
    }

    public String getTextElementTitleIframesPages() {
        return driver.findElement(TITLE_IFRAME_PAGE).getText();
    }

    public String getTextParagraphInIframe() {
        return driver.findElement(IFRAME_PARAGRAPH).getText();
    }
}