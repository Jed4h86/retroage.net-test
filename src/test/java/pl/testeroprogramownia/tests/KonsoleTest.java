package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.ConsolePage;
import pl.testeroprogramownia.pages.GalleryPage;
import pl.testeroprogramownia.pages.HomePage;

public class KonsoleTest extends BaseTest {

    private HomePage homePage;
    private ConsolePage consolePage;
    private GalleryPage galleryPage;

    @BeforeMethod
    public void setUpTest() {
        homePage = new HomePage(driver);
        System.out.println("🔧 Start testu – otwarto stronę główną.");
    }

    @AfterMethod
    public void tearDownTest() {
        driver.manage().deleteAllCookies();
        System.out.println("🧹 Koniec testu – wyczyszczono cookies.");
    }

    // ========================
    // 🔹 GRUPA: CONSOLE TESTS
    // ========================

    @Test(groups = {"console"})
    public void shouldDisplayAllConsolesOnHomePage() {
        homePage.konsoleIcon();

        Assert.assertTrue(
                homePage.czyWszystkieKonsoleSa(),
                "❌ Nie wszystkie konsole są widoczne na stronie głównej!"
        );

        homePage.opisyKonsolIcon();
        homePage.galerieKonsol();
    }

    @Test(groups = {"console"})
    public void shouldContainNintendoInConsoleList() {
        homePage.otworzOpisyKonsol();
        consolePage = new ConsolePage(driver);

        Assert.assertTrue(
                consolePage.isConsolePresented("Nintendo"),
                "❌ Konsola 'Nintendo' nie została znaleziona! Pełna lista: "
                        + consolePage.getAllConsoles()
        );
    }

    @Test(groups = {"console"})
    public void shouldOpenNintendoConsolePage() {
        homePage.otworzOpisyKonsol();
        consolePage = new ConsolePage(driver);

        consolePage.nintendoConsole();

        Assert.assertTrue(
                consolePage.nintendoName().contains("Nintendo"),
                "❌ Tekst 'Nintendo' nie został znaleziony na stronie konsoli!"
        );
    }

    // ========================
    // 🔹 GRUPA: GALLERY TESTS
    // ========================

    @Test(groups = {"gallery"})
    public void shouldDisplayAllItemsInGallery() {
        homePage.otworzGalerieKonsol();
        galleryPage = new GalleryPage(driver);

        Assert.assertTrue(
                galleryPage.allGalleryListCheck(),
                "❌ Lista wszystkich pozycji w galerii nie jest widoczna!"
        );
    }

    @Test(groups = {"gallery"})
    public void shouldDisplayCorrectGalleryHeader() {
        homePage.otworzGalerieKonsol();
        galleryPage = new GalleryPage(driver);

        Assert.assertTrue(
                galleryPage.headerName().contains("Galeria, Konsola"),
                "❌ Nagłówek galerii nie został znaleziony!"
        );
    }

    @Test(groups = {"gallery"})
    public void shouldDisplayMicrosoftGallery() {
        homePage.otworzGalerieKonsol();
        galleryPage = new GalleryPage(driver);

        galleryPage.clickMicrosoft();

        Assert.assertTrue(
                galleryPage.allMicrosoftGalleryListCheck(),
                "❌ Lista elementów Microsoft nie jest widoczna!"
        );
    }

    @Test(groups = {"gallery"})
    public void shouldDisplayXboxGalleryItems() {
        homePage.otworzGalerieKonsol();
        galleryPage = new GalleryPage(driver);

        galleryPage.clickMicrosoft();
        galleryPage.clickXbox();

        int count = galleryPage.getXboxGalleryCount();
        System.out.println("📸 Liczba elementów w galerii Xbox: " + count);

        Assert.assertTrue(count > 0, "❌ Galeria Xbox jest pusta!");
    }

    @Test(groups = {"gallery"})
    public void shouldDisplayNintendoGalleryItems() {
        homePage.otworzGalerieKonsol();
        galleryPage = new GalleryPage(driver);

        galleryPage.clickNintendo();

        int count = galleryPage.getNintendoGalleryCount();
        System.out.println("📸 Liczba elementów w galerii Nintendo: " + count);

        Assert.assertTrue(count > 0, "❌ Galeria Nintendo jest pusta!");
    }
}
