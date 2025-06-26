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
        //accessoriesPage.switchToNextTab();
        // dodaj tę metodę w klasie AccessoriesPage

// tutaj możesz zrobić jakieś asercje lub interakcje na nowej zakładce
        accessoriesPage.kliknijGalerie();

        // ewentualnie wróć do głównego okna, jeśli chcesz:
        //driver.close(); // zamknij nowe okno
        //driver.switchTo().window(homePage.getMainWindowHandle()); // metoda musi być dodana
    }
}

