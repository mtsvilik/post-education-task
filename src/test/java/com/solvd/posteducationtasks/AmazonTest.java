package com.solvd.posteducationtasks;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AmazonTest extends BaseTest {

    @Test
    public void verifySearchResultsTest() {
        HomePage homePage = new HomePage();
        homePage.openResultPage(ConfigProvider.SEARCH_TEXT);

        SearchResultPage searchResultPage = new SearchResultPage();
        List<String> titles = searchResultPage.findResults();

        SoftAssert softAssert = new SoftAssert();
        titles
                .forEach(title -> softAssert.assertTrue(title.contains(ConfigProvider.SEARCH_TEXT)));
        softAssert.assertAll();
    }
    @Test
    public void verifySignInTest() {
        HomePage homePage = new HomePage();
        homePage.clickSignInButton();

        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(ConfigProvider.USER1_EMAIL);
        loginPage.enterPassword(ConfigProvider.USER1_PASSWORD);

        String username = homePage.getUserName();
        Assert.assertEquals(username, ConfigProvider.USER_NAME, "Name of account contains user name");
    }
}
