package com.solvd.posteducationtasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='a-row sc-your-amazon-cart-is-empty']")
    private WebElement cartIsEmptyText;

    @FindBy(css = "#nav-cart")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//*[@class='a-truncate-cut' and contains(text(), 'iPhone')]")
    private WebElement title;

    @FindBy(css = ".a-dropdown-prompt")
    private WebElement value;

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    public String getCartIsEmptyText() {
        return cartIsEmptyText.getText();
    }

    public void clickShoppingCartButton() {
        shoppingCartButton.click();
    }

    public String getProductTitle() {
        return title.getText();
    }

    public String getValue() {
        return value.getText();
    }
}
