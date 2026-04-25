package Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DynamicControlsTest extends BaseTest{

    @Test
    public void checkDynamicControls() {
        dynamicControlsPage.openDynamicControlsPage();
        dynamicControlsPage.getTextElementTitleDynamicControls();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dynamicControlsPage.getTextElementTitleDynamicControls(),
                "Dynamic Controls", "Переход на страницу Dynamic Controls не выполнен!");
        dynamicControlsPage.clickButtonRemove();
        dynamicControlsPage.getTextElementItsGone();
        boolean isGoneElementCheckbox = dynamicControlsPage.checkElementCheckboxDisplayed();
        softAssert.assertTrue(isGoneElementCheckbox, "Элемент Checkbox не пропал со страницы!");
        boolean isGoneElementInput = dynamicControlsPage.checkElementInputDisplayed();
        softAssert.assertFalse(isGoneElementInput, "Элемент Input не отображен на странице!");
        dynamicControlsPage.clickButtonEnable();
        dynamicControlsPage.getTextElementItsEnabled();
        boolean isGoneElementInputEnable = dynamicControlsPage.checkElementInputDisplayed();
        softAssert.assertFalse(isGoneElementInputEnable, "Элемент Input не пропал со страницы!");
        softAssert.assertAll();
    }
}