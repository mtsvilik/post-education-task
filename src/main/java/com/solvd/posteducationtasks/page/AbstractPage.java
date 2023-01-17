package com.solvd.posteducationtasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    private static final Duration TIMEOUT = Duration.ofSeconds(20);
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButton(WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickButton(WebElement element, int multiplier) {
        new WebDriverWait(driver, TIMEOUT.multipliedBy(multiplier))
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeys(WebElement element, String input) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element)).sendKeys(input);
    }
}
