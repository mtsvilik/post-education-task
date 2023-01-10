package com.solvd.posteducationtasks;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AmazonTest extends BaseTest {

    @Test
    public void verifySearchResultsTest() {
        String searchText = "umbrella";
        HomePage homePage = new HomePage();
        homePage.openResultPage(searchText);

        SearchResultPage searchResultPage = new SearchResultPage();
        List<String> titles = searchResultPage.findResults();

        SoftAssert softAssert = new SoftAssert();
        titles
                .forEach(title -> softAssert.assertTrue(title.contains(searchText)));
        softAssert.assertAll();
    }
}
