package com.solvd.posteducationtasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='a-row sc-your-amazon-cart-is-empty']")
    private WebElement cartIsEmptyText;

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    public String getCartIsEmptyText() {
        return cartIsEmptyText.getText();
    }
}
