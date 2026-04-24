package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FileUploaderPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By INPUT_FILE_UPLOAD = By.id("file-upload");
    private final By TITLE_PAGE_FILE_UPLOADER = By.xpath("//H3");
    private final By BUTTON_UPLOAD = By.id("file-submit");
    private final By ELEMENT_UPLOADED_FILES_NAME = By.id("uploaded-files");

    public FileUploaderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openFileUploaderPage() {
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    public String getTextElementTitleFileUploader() {
        return driver.findElement(TITLE_PAGE_FILE_UPLOADER).getText();
    }

    public void uploadFile(String filePath) {
        driver.findElement(INPUT_FILE_UPLOAD).sendKeys(filePath);
    }

    public void clickSubmit() {
        driver.findElement(BUTTON_UPLOAD).click();
    }

    public String getUploadedFileName() {
        return driver.findElement(ELEMENT_UPLOADED_FILES_NAME).getText();
    }
}
