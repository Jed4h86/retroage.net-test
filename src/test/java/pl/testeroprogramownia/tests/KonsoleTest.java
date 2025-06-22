package pl.testeroprogramownia.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

public class KonsoleTest extends BaseTest {

    @Test
    public void Konsole() {
        HomePage homePage = new HomePage(driver);
        homePage.konsoleIcon();
        homePage.czyWszystkieKonsoleSa();
        Assert.assertTrue(homePage.czyWszystkieKonsoleSa());
    }
}
