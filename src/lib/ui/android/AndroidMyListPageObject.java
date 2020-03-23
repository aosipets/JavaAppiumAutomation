package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class AndroidMyListPageObject extends MyListsPageObject {

    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@text ='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text ='{TITLE}']";
        ARTICLE_TITLE_IN_LIST_TPL = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text='{TITLE_TEXT}']";
    }
    public AndroidMyListPageObject(AppiumDriver driver) {
        super(driver);
    }
}
