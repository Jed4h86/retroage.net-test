package pl.testeroprogramownia.tests;

import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.ArticlesPage;
import pl.testeroprogramownia.pages.HomePage;

public class ArtykulyTest extends BaseTest{

    @Test
    public void articleTests(){
        HomePage homePage = new HomePage(driver);
        homePage.articlesIcon();


    }
}
