package pl.testeroprogramownia.tests;

import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.AccessoriesPage;
import pl.testeroprogramownia.pages.HomePage;

public class AkcesoriaTest extends BaseTest {

    @Test
    public void testAkcesoria() {
        HomePage homePage = new HomePage(driver);

        // Otwórz stronę akcesoriów w nowym oknie
        AccessoriesPage accessoriesPage = homePage.otworzAkcesoria();

        // Interakcje na stronie Accessories
        accessoriesPage.openAkcesoriaTab();
        accessoriesPage.openOpisy();
        accessoriesPage.openGalerie();
    }
}
