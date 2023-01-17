package com.solvd.posteducationtasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='a-row sc-your-amazon-cart-is-empty']")
    private WebElement cartIsEmptyText;

    @FindBy(css = "#nav-cart")
    private WebElement shoppingCartButton;

    @FindBy(css = "[data-csa-c-content-id='sw-gtc_CONTENT']")
    private WebElement smallShoppingCartButton;

    @FindBy(xpath = "//*[@class='a-truncate-cut' and contains(text(), 'iPhone')]")
    private WebElement title;

    @FindBy(css = ".a-dropdown-prompt")
    private WebElement value;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getCartIsEmptyText() {
        return cartIsEmptyText.getText();
    }

    public void clickShoppingCartButton() {
        clickButton(shoppingCartButton);
    }

    public String getProductTitle() {
        return title.getText();
    }

    public String getValue() {
        return value.getText();
    }
}
