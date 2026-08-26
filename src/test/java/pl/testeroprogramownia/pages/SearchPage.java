package pl.testeroprogramownia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramownia.utils.SeleniumHelper;

public class SearchPage {

    private WebDriver driver;

    @FindBy(xpath = "//h1[@class='page-title' and contains(text(),'Search Results for:')]")
    private WebElement searchResult;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Zwraca tekst nagłówka wyników wyszukiwania.
     */
    public String getSearchResultText() {
        SeleniumHelper.waitForElementToBeVisible(driver, searchResult);
        return searchResult.getText().trim();
    }

    /**
     * Sprawdza, czy wyniki wyszukiwania zawierają określony tekst.
     */
    public boolean isSearchResultContains(String text) {
        return getSearchResultText().contains(text);
    }
}
