package pl.testeroprogramownia.tests;

import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

public class SearchTest extends BaseTest{

    @Test
    public void searchTest(){
        HomePage homePage = new HomePage(driver);
        homePage.searchIcon();
    }
}
