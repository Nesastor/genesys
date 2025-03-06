package com.genesys.web.onlinehtmleditor.e2e;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.genesys.web.common.BaseWebTest;
import com.genesys.web.onlinehtmleditor.po.EditorPage;
import com.genesys.web.onlinehtmleditor.utils.Defaults;

public class RichTextEditorTest extends BaseWebTest{
    protected static final Logger LOGGER = LogManager.getLogger(); // TODO Add logging to test steps

    public RichTextEditorTest() {
        super(Defaults.DEFAULT_WEBDRIVER, Defaults.ONLINE_HTML_EDITOR_URL);
    }

    @Test
    @DisplayName("Simple html editor test")
    public void simpleEditorTest() {
        String textPart1 = "Automation";
        String textPart2 = "Test";
        String textPart3 = "Example";
        String space = " ";
        String textFull = String.format("%s %s %s", textPart1, textPart2, textPart3);

        EditorPage editorPage = new EditorPage(driver);
        editorPage.clickBoldButton();
        editorPage.writeTextToTextbox(textPart1);
        editorPage.clickBoldButton();
        editorPage.writeTextToTextbox(space);
        editorPage.clickUnderlineButton();
        editorPage.writeTextToTextbox(textPart2);
        editorPage.clickUnderlineButton();
        editorPage.writeTextToTextbox(space);
        editorPage.writeTextToTextbox(textPart3);
        Assertions.assertEquals(
            textFull,
            editorPage.getTextFromTextbox(),
            "Text in editor does not match expected."
        );
    }
}
