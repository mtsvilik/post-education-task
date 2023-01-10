package com.solvd.posteducationtasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchBar;

    @FindBy(css = "#nav-search-submit-button")
    private WebElement searchButton;

    public HomePage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage openResultPage(String searchText) {
        searchBar.sendKeys(searchText);
        searchButton.click();
        return new SearchResultPage();
    }
}
