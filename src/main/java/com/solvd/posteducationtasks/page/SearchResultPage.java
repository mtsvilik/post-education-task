package com.solvd.posteducationtasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {

    @FindBy(css = "data-csa-c-item-id")
    private List<WebElement> resultProductList;

    @FindBy(css = "[data-image-index='2']")
    private WebElement searchResult;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> findResults() {
        return resultProductList.stream()
                .map(title -> title.toString().toLowerCase(Locale.ROOT))
                .collect(Collectors.toList());
    }

    public ProductPage clickSearchResult() {
        clickButton(searchResult);
        return new ProductPage(driver);
    }
}
