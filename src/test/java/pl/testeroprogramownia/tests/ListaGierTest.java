package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

public class ListaGierTest extends BaseTest {

    @Test
    public void GryTest(){

        HomePage homePage = new HomePage(driver);
        homePage.gryIcon();
                homePage.czyWszystkieElementyGierIstnieją();

        Assert.assertTrue(homePage.czyWszystkieElementyGierIstnieją(),"Nie wszystkie elementy gier są widoczne");
        homePage.recenzjeButton();
        homePage.homebrewIcon();
        homePage.niewydaneIcon();
        homePage.solucjeIcon();

    }


}
