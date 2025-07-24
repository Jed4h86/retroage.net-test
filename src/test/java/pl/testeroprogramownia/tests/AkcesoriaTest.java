package pl.testeroprogramownia.tests;

import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.AccessoriesPage;
import pl.testeroprogramownia.pages.HomePage;

public class AkcesoriaTest extends BaseTest {

    @Test
    public void testAkcesoria() {
        HomePage homePage = new HomePage(driver);
        AccessoriesPage accessoriesPage = homePage.otworzAkcesoria();
        accessoriesPage.akcesoriaTab();
        accessoriesPage.kliknijOpisy();
        accessoriesPage.kliknijGalerie();

    }
}

