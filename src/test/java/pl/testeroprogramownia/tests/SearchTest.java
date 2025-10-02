package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;
import pl.testeroprogramownia.pages.SearchPage;

import static org.testng.AssertJUnit.assertTrue;

public class SearchTest extends BaseTest{

    @Test
    public void searchTest() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        homePage.searchIcon();
        homePage.fillSearchText("Terminator");
        homePage.searchValue();
        searchPage.getSearchResultText();

        assertTrue(searchPage.getSearchResultText().contains("Search Results for:"));
    }
}
