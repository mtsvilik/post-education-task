package com.solvd.posteducationtasks;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;

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
        Assert.assertEquals(homePage.getUserName(), ConfigProvider.USER_NAME, "Name of account should contains user name");
    }

    @Test
    public void checkSignInNonExistentEmailTest() {
        HomePage homePage = new HomePage();
        homePage.clickSignInButton();

        SignInPage signInPage = new SignInPage();
        signInPage.enterNonExistentEmail(ConfigProvider.USER2_EMAIL);
        Assert.assertEquals(signInPage.getSignInText(), ConfigProvider.SIGNIN_TEXT, "Sign In page should contains sign in text");
    }

    @Test
    public void checkAddCartButtonIsClickableTest() {
        HomePage homePage = new HomePage();
        homePage.clickShoppingCartButton();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        Assert.assertEquals(shoppingCartPage.getCartIsEmptyText(), ConfigProvider.CART_IS_EMPTY_TEXT, "Shopping cart page should contains add to cart is empty text");
    }

    @Test
    public void verifyProductIsAddedToCartTest() {
        HomePage homePage = new HomePage();
        homePage.openResultPage(ConfigProvider.SEARCH_TEXT2);

        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.clickFirstSearchResult();

        ProductPage productPage = new ProductPage();
        productPage.addToCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickShoppingCartButton();
        Assert.assertTrue(shoppingCartPage.getProductTitle().toLowerCase(Locale.ROOT).contains(ConfigProvider.PRODUCT_TITLE),
                "Product in shopping cart with incorrect title");
    }

    @Test
    public void checkIncreaseProductInCartTest() {
        HomePage homePage = new HomePage();
        homePage.openResultPage(ConfigProvider.SEARCH_TEXT2);

        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.clickFirstSearchResult();

        ProductPage productPage = new ProductPage();
        productPage.chooseQuantity();
        productPage.addToCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        Assert.assertEquals(shoppingCartPage.getValue(), ConfigProvider.QUANTITY, "Incorrect quantity product in shopping cart");
    }
}
