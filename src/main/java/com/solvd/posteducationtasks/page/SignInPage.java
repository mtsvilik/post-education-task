package com.solvd.posteducationtasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractPage {

    @FindBy(id = "ap_email")
    private WebElement emailField;

    @FindBy(css = ".a-button-input")
    private WebElement continueButton;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(id = "signInSubmit")
    private WebElement signInButton;

    @FindBy(css = ".a-list-item")
    private WebElement signInText;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        clickButton(emailField);
        sendKeys(emailField, email);
        clickButton(continueButton);
    }

    public void enterPassword(String password) {
        clickButton(passwordField);
        sendKeys(passwordField, password);
        clickButton(signInButton);
    }

    public void enterNonExistentEmail(String email) {
        clickButton(emailField);
        sendKeys(emailField, email);
        clickButton(continueButton);
    }

    public String getSignInText() {
        return signInText.getText();
    }
}
