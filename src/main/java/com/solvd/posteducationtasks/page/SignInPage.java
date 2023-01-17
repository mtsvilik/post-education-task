package com.solvd.posteducationtasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractPage {

    @FindBy(css = "#ap_email")
    private WebElement emailField;

    @FindBy(css = ".a-button-input")
    private WebElement continueButton;

    @FindBy(css = "#ap_password")
    private WebElement passwordField;

    @FindBy(css = "#signInSubmit")
    private WebElement signInButton;

    @FindBy(css = ".a-list-item")
    private WebElement signInText;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SignInPage enterEmail(String email) {
        clickButton(emailField);
        sendKeys(emailField, email);
        clickButton(continueButton);
        return new SignInPage(driver);
    }

    public SignInPage enterPassword(String password) {
        clickButton(passwordField);
        sendKeys(passwordField, password);
        clickButton(signInButton);
        return new SignInPage(driver);
    }

    public SignInPage enterNonExistentEmail(String email) {
        clickButton(emailField);
        sendKeys(emailField, email);
        clickButton(continueButton);
        return new SignInPage(driver);
    }

    public String getSignInText() {
        return signInText.getText();
    }
}
