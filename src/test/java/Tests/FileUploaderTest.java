package Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FileUploaderTest extends BaseTest{

    @Test
    public void checkFileUploaderPage() {
        fileUploaderPage.openFileUploaderPage();
        fileUploaderPage.getTextElementTitleFileUploader();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(fileUploaderPage.getTextElementTitleFileUploader(),
                "File Uploader", "Переход на страницу File Uploader не выполнен!");
        java.io.File file = new java.io.File("src/test/resources/File007.txt");
        String absolutePath = file.getAbsolutePath();
        fileUploaderPage.uploadFile(absolutePath);
        fileUploaderPage.clickSubmit();
        softAssert.assertEquals(fileUploaderPage.getUploadedFileName(),
                "File007.txt", "Имя загруженного файла не совпадает!");
        softAssert.assertAll();
    }
}