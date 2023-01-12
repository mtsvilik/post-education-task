package com.solvd.posteducationtasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='selectQuantity']/../../..//*[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(css = "[aria-labelledby='attach-sidesheet-view-cart-button-announce']")
    private WebElement cartButton;

    @FindBy(css ="#a-autoid-0")
    private WebElement chooseQuantityButton;

    @FindBy(css = "#quantity_4")
    private WebElement quantity;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public ShoppingCartPage addToCart() {
        clickButton(addToCartButton);
        clickButton(cartButton);
        return new ShoppingCartPage();
    }

    public void chooseQuantity() {
        clickButton(chooseQuantityButton);
        clickButton(quantity);
    }
}

