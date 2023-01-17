package com.solvd.posteducationtasks;

import com.solvd.posteducationtasks.page.*;
import com.solvd.posteducationtasks.service.ConfigProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;

public class AmazonTest extends AbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(AmazonTest.class);

    @Test
    public void verifySearchResultsTest() {
        LOGGER.info("VerifySearchResultsTest - Started! " + "Thread Id: " + Thread.currentThread().getId());

        HomePage homePage = new HomePage(getDriver());
        SearchResultPage searchResultPage = homePage.openResultPage(ConfigProvider.SEARCH_TEXT);
        List<String> titles = searchResultPage.findResults();

        SoftAssert softAssert = new SoftAssert();
        titles
                .forEach(title -> softAssert.assertTrue(title.contains(ConfigProvider.SEARCH_TEXT)));
        softAssert.assertAll();
        LOGGER.info("VerifySearchResultsTest - Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    public void verifySignInTest() {
        LOGGER.info("VerifySignInTest - Started! " + "Thread Id: " + Thread.currentThread().getId());
        HomePage homePage = new HomePage(getDriver());

        SignInPage signInPage = homePage.clickSignInButton();
        signInPage.enterEmail(ConfigProvider.USER1_EMAIL);
        signInPage.enterPassword(ConfigProvider.USER1_PASSWORD);

        Assert.assertEquals(homePage.getUserName(), ConfigProvider.USER_NAME, "Name of account should contains user name");
    }

    @Test
    public void checkSignInNonExistentEmailTest() {
        HomePage homePage = new HomePage(getDriver());

        SignInPage signInPage = homePage.clickSignInButton();
        signInPage.enterNonExistentEmail(ConfigProvider.USER2_EMAIL);
        Assert.assertEquals(signInPage.getSignInText(), ConfigProvider.SIGNIN_TEXT, "Sign In page should contains sign in text");
    }

    @Test
    public void checkAddCartButtonIsClickableTest() {
        HomePage homePage = new HomePage(getDriver());

        ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartButton();
        Assert.assertEquals(shoppingCartPage.getCartIsEmptyText(), ConfigProvider.CART_IS_EMPTY_TEXT, "Shopping cart page should contains add to cart is empty text");
    }

    @Test
    public void verifyProductIsAddedToCartTest() {
        HomePage homePage = new HomePage(getDriver());

        SearchResultPage searchResultPage = homePage.openResultPage(ConfigProvider.SEARCH_TEXT2);

        ProductPage productPage = searchResultPage.clickSearchResult();

        ShoppingCartPage shoppingCartPage = productPage.addToCart();
        shoppingCartPage.clickShoppingCartButton();
        Assert.assertTrue(shoppingCartPage.getProductTitle().toLowerCase(Locale.ROOT).contains(ConfigProvider.PRODUCT_TITLE),
                "Product in shopping cart with incorrect title");
    }

    @Test
    public void checkIncreaseProductInCartTest() {
        HomePage homePage = new HomePage(getDriver());

        SearchResultPage searchResultPage = homePage.openResultPage(ConfigProvider.SEARCH_TEXT2);

        ProductPage productPage = searchResultPage.clickSearchResult();
        productPage.chooseQuantity();

        ShoppingCartPage shoppingCartPage = productPage.addToCart();
        shoppingCartPage.clickShoppingCartButton();
        Assert.assertEquals(shoppingCartPage.getValue(), ConfigProvider.QUANTITY, "Incorrect quantity product in shopping cart");
    }
}
