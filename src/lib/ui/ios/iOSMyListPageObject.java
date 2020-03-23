package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class iOSMyListPageObject extends MyListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
        //ARTICLE_TITLE_IN_LIST_TPL = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text='{TITLE_TEXT}']";
        CLOSE_BUTTON_SYNC_POPUP = "id:Close";
    }

    public iOSMyListPageObject(AppiumDriver driver) {
        super(driver);
    }
}
