package tests;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class ArticleTests extends CoreTestCase
{
    @Test
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                 article_title
        );
    }
    @Test
    public void testSwipeArticle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);;
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();


    }
//    @Test
//    public void checkTitleInTopic()  {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
//
//        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
//        ArticlePageObject.presentTitleInArticle();
//    }
//    @Test
//    public void testCheckDeletedSecondTopicAndCheckTitleFirstTopic() throws InterruptedException
//    {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
//
//        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
//        ArticlePageObject.waitForTitleElement();
//        String title = ArticlePageObject.getArticleTitle();
//        String name_of_folder = "Learning programming";
//        ArticlePageObject.addArticleToMyList(name_of_folder);
//        ArticlePageObject.closeArticle();
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("JavaScript");
//        SearchPageObject.clickByArticleWithSubstring("Programming language");
//        ArticlePageObject.addNewArticleToMyList(name_of_folder);
//        ArticlePageObject.closeArticle();
//
//
//        NavigationUI NavigationUI = new NavigationUI(driver);
//        NavigationUI.clickMyLists();
//
//        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
//        MyListPageObject.openFolderByName(name_of_folder);
//        MyListPageObject.swipeByArticleToDelete(title);
//        String title_article_in_list = "JavaScript";
//        MyListPageObject.checkArticleTitleInMyListAndClick(title_article_in_list);
//
//        String article_title = ArticlePageObject.getArticleTitle();
//        Assert.assertEquals(
//                "We see unexpected title",
//                title_article_in_list,
//                article_title
//        );
//    }
}
