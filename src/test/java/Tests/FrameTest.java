package Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FrameTest extends BaseTest{

    @Test
    public void checkIframePage() {
        framesPage.openFramesPage();
        framesPage.isFramesPageOpened();
        framesPage.getTextElementTitleFramesPages();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(framesPage.getTextElementTitleFramesPages(),
                "Frames",
                "Заголовок страницы Frames не найден!");
        framesPage.clickHyperlinkIframe();
        iframePages.isIframesPageOpened();
        softAssert.assertEquals(iframePages.getTextElementTitleIframesPages(),
                "An iFrame containing the TinyMCE WYSIWYG Editor",
                "Заголовок страницы iFrames не найден!");
        softAssert.assertEquals(iframePages.getTextParagraphInIframe(),
                "Your content goes here.",
                "Параграф, содержащий текст 'Your content goes here.' - не найден!");
        softAssert.assertAll();
    }
}