package pl.testeroprogramownia.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.SearchPage;

@Epic("Retroage - Serwis Retro")
@Feature("Wyszukiwarka Serwisu")
public class SearchTest extends BaseTest {

    @Test(groups = {"search"})
    @Story("Wyszukiwanie Frazy")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test weryfikuje działanie wyszukiwarki głównej – wprowadzenie frazy 'Terminator' i sprawdzenie nagłówka na stronie wyników.")
    public void searchTest() {
        String searchQuery = "Terminator";

        performSearch(searchQuery);

        SearchPage searchPage = new SearchPage(driver);

        verifySearchResultsHeader(searchPage);
    }

    @Step("Wykonanie wyszukiwania frazy: '{query}'")
    private void performSearch(String query) {
        homePage.searchIcon();
        homePage.fillSearchText(query);
        homePage.searchValue();
    }

    @Step("Weryfikacja obecności nagłówka wyników wyszukiwania")
    private void verifySearchResultsHeader(SearchPage searchPage) {
        Assert.assertTrue(
                searchPage.isSearchResultContains("Search Results for:"),
                "❌ Nagłówek wyników wyszukiwania nie zawiera oczekiwanego tekstu!"
        );
    }
}