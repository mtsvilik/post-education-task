package com.solvd.posteducationtasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {

    @FindBy(css = "data-csa-c-item-id")
    private List<WebElement> resultProductList;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public List<String> findResults() {
        return resultProductList.stream()
                .map(title -> title.toString().toLowerCase(Locale.ROOT))
                .collect(Collectors.toList());
    }
}
