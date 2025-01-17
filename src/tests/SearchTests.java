package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testAmountOfEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "kuyfjyflyflyfly";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();


    }
    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }
    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.waitCancelSearchAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitCancelSearchDisappear();
    }
    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        String search_line = "Linkin park Discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found too few results!",
                amount_of_search_results > 0
        );
    }
//    @Test
//    public void testResultAndClear()
//    {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        String search_line = "Good";
//        SearchPageObject.typeSearchLine(search_line);
//        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
//
//        Assert.assertTrue(
//                "We found too few results!",
//                amount_of_search_results > 1
//        );
//        SearchPageObject.clickCancelSearch();
//        SearchPageObject.waitSearchResultDisappear();
//
//    }
}
