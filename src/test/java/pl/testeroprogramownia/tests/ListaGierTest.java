package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

public class ListaGierTest extends BaseTest {

    @Test
    public void GryTest(){

        HomePage homePage = new HomePage(driver);
        homePage.GryIcon();
                homePage.czyWszystkieElementyIstnieją();

        Assert.assertTrue(homePage.czyWszystkieElementyIstnieją(),"Nie wszystkie elementy gier są widoczne");
        homePage.recenzjeButton();
        homePage.homebrewIcon();


    }


}
