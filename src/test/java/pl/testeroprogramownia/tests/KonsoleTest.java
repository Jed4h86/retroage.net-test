package pl.testeroprogramownia.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.ConsolePage;
import pl.testeroprogramownia.pages.GalleryPage;
import pl.testeroprogramownia.pages.HomePage;

public class KonsoleTest extends BaseTest {

    @Test
    public void Konsole() {
        HomePage homePage = new HomePage(driver);
        homePage.konsoleIcon();
        homePage.czyWszystkieKonsoleSa();
        Assert.assertTrue(homePage.czyWszystkieKonsoleSa());
        homePage.opisyKonsolIcon();
        homePage.galerieKonsol();
    }

    @Test
    public void ConsolesList() {
        HomePage homePage = new HomePage(driver);
        homePage.otworzOpisyKonsol();
        ConsolePage consolePage = new ConsolePage(driver);

        Assert.assertTrue(
                consolePage.isConsolePresented("Nintendo"),
                "Konsola 'Nintendo' nie została znaleziona na liście! "
                        + "Pełna lista: " + consolePage.getAllConsoles());

    }

    @Test
    public void NintendoChoose() {
        HomePage homePage = new HomePage(driver);
        homePage.otworzOpisyKonsol();

        ConsolePage consolePage = new ConsolePage(driver);
        consolePage.nintendoConsole();

        Assert.assertTrue(consolePage.nintendoName().contains("Nintendo"),
                "Tekst 'Nintendo' nie został znaleziony!");
    }
    @Test
    public void ConsoleGalleryList(){
        HomePage homePage = new HomePage(driver);
        homePage.otworzGalerieKonsol();
        GalleryPage galleryPage = new GalleryPage(driver);

        Assert.assertTrue(galleryPage.allGalleryListCheck(), "Lista wszystkich pozycji nie jest widoczna!");
    }
    @Test
    public void checkGalleryHeader(){
        HomePage homePage = new HomePage(driver);
        homePage.otworzGalerieKonsol();
        GalleryPage galleryPage = new GalleryPage(driver);

        Assert.assertTrue(galleryPage.headerName().contains("Galeria, Konsola"),
                "Header nie znaleziony");
    }

    @Test
    public void microsoftIcon(){
        HomePage homePage = new HomePage(driver);
        homePage.otworzGalerieKonsol();
        GalleryPage galleryPage = new GalleryPage(driver);
        galleryPage.microsoftClick();

    }
}
