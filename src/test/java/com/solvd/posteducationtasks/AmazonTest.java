package com.solvd.posteducationtasks;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AmazonTest extends AbstractTest {

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

        SignInPage signInPage = new SignInPage();
        signInPage.enterEmail(ConfigProvider.USER1_EMAIL);
        signInPage.enterPassword(ConfigProvider.USER1_PASSWORD);

        String userName = homePage.getUserName();
        Assert.assertEquals(userName, ConfigProvider.USER_NAME, "Name of account should contains user name");
    }

    @Test
    public void checkSignInNonExistentEmail() {
        HomePage homePage = new HomePage();
        homePage.clickSignInButton();

        SignInPage signInPage = new SignInPage();
        signInPage.enterNonExistentEmail(ConfigProvider.USER2_EMAIL);

        String signInText = signInPage.getSignInText();
        Assert.assertEquals(signInText, ConfigProvider.SIGNIN_TEXT, "Sign In page doesn't contain sign In text");
    }

    @Test
    public void checkAddCartButtonIsClickable() {
        HomePage homePage = new HomePage();
        homePage.clickShoppingCartButton();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        String cartIsEmptyText = shoppingCartPage.getCartIsEmptyText();
        Assert.assertEquals(cartIsEmptyText, ConfigProvider.CART_IS_EMPTY_TEXT, "Shopping cart page doesn't contain Add to cart is empty text");
    }
}
