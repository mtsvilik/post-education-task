package com.solvd.posteducationtasks;

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

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    public SignInPage enterEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
        continueButton.click();
        return new SignInPage();
    }

    public SignInPage enterPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
        signInButton.click();
        return new SignInPage();
    }

    public SignInPage enterNonExistentEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
        continueButton.click();
        return new SignInPage();
    }

    public String getSignInText() {
        return signInText.getText();
    }
}
