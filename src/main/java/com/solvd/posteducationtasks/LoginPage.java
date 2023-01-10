package com.solvd.posteducationtasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(css = "#ap_email")
    private WebElement emailField;

    @FindBy(css = ".a-button-input")
    private WebElement continueButton;

    @FindBy(css = "#ap_password")
    private WebElement passwordButton;

    @FindBy(css = "#signInSubmit")
    private WebElement signInButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public UserPage enterEmail(String email) {
        emailField.sendKeys(email);
        continueButton.click();
        return new UserPage();
    }
}
