package pl.testeroprogramownia.tests;

import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;
import pl.testeroprogramownia.pages.SearchPage;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        // Wyszukiwanie
        homePage.searchIcon();
        homePage.fillSearchText("Terminator");
        homePage.searchValue();

        // Sprawdzenie wyniku wyszukiwania
        assertTrue(
                searchPage.isSearchResultContains("Search Results for:"),
                "Nagłówek wyników wyszukiwania nie zawiera oczekiwanego tekstu!"
        );
    }
}
