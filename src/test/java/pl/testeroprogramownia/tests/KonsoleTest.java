package pl.testeroprogramownia.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.ConsolePage;
import pl.testeroprogramownia.pages.GalleryPage;

@Epic("Retroage - Serwis Retro")
public class KonsoleTest extends BaseTest {

    private ConsolePage consolePage;
    private GalleryPage galleryPage;

    // ========================
    // 🔹 GRUPA: CONSOLE TESTS
    // ========================

    @Test(groups = {"console"})
    @Feature("Opisy i Lista Konsol")
    @Story("Strona Główna Konsol")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Weryfikacja widoczności ikon konsol oraz przechodzenie do sekcji opisów/galerii.")
    public void shouldDisplayAllConsolesOnHomePage() {
        navigateAndVerifyConsoles();
    }

    @Step("Otwieranie ikon konsol i sprawdzanie ich widoczności na stronie głównej")
    private void navigateAndVerifyConsoles() {
        homePage.konsoleIcon();

        Assert.assertTrue(
                homePage.czyWszystkieKonsoleSa(),
                "❌ Nie wszystkie konsole są widoczne na stronie głównej!"
        );

        homePage.opisyKonsolIcon();
        homePage.galerieKonsol();
    }

    @Test(groups = {"console"})
    @Feature("Opisy i Lista Konsol")
    @Story("Wyszukiwanie Konsoli")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sprawdzenie, czy producent 'Nintendo' znajduje się na pełnej liście opisywanych konsol.")
    public void shouldContainNintendoInConsoleList() {
        openConsoleDescriptions();
        verifyConsolePresence("Nintendo");
    }

    @Step("Przejście do sekcji opisów konsol ze strony głównej")
    private void openConsoleDescriptions() {
        // Zamiast założyć, że consolePage istnieje, upewnij się, że przechodzisz na stronę
        // Jeśli otworzOpisyKonsol() zwraca nową instancję ConsolePage:
        // consolePage = homePage.otworzOpisyKonsol();

        homePage.otworzOpisyKonsol();
        consolePage = new ConsolePage(driver); // Tworzymy obiekt dopiero PO przejściu na stronę
    }

    @Step("Sprawdzenie, czy na liście konsol znajduje się producent: {consoleName}")
    private void verifyConsolePresence(String consoleName) {
        Assert.assertTrue(
                consolePage.isConsolePresented(consoleName),
                "❌ Konsola '" + consoleName + "' nie została znaleziona! Pełna lista: "
                        + consolePage.getAllConsoles()
        );
    }

    @Test(groups = {"console"})
    @Feature("Opisy i Lista Konsol")
    @Story("Nawigacja do Konsoli")
    @Severity(SeverityLevel.NORMAL)
    @Description("Wejście na dedykowaną stronę marki Nintendo i weryfikacja nagłówka strony.")
    public void shouldOpenNintendoConsolePage() {
        openConsoleDescriptions();
        openNintendoPageAndVerify();
    }

    @Step("Wybór konsoli Nintendo i weryfikacja nagłówka strony")
    private void openNintendoPageAndVerify() {
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
    @Feature("Galeria Sprzętu")
    @Story("Widok Ogólny Galerii")
    @Severity(SeverityLevel.NORMAL)
    @Description("Weryfikacja, czy sekcja galerii poprawnie wyświetla wszystkie dostępne pozycje.")
    public void shouldDisplayAllItemsInGallery() {
        openConsoleGallery();

        Assert.assertTrue(
                galleryPage.allGalleryListCheck(),
                "❌ Lista wszystkich pozycji w galerii nie jest widoczna!"
        );
    }

    @Step("Przejście do głównej sekcji galerii konsol")
    private void openConsoleGallery() {
        homePage.otworzGalerieKonsol();
        galleryPage = new GalleryPage(driver); // Inicjalizacja PO przejściu na stronę galerii
    }

    @Test(groups = {"gallery"})
    @Feature("Galeria Sprzętu")
    @Story("Widok Ogólny Galerii")
    @Severity(SeverityLevel.MINOR)
    @Description("Sprawdzenie poprawności tekstu nagłówkowego w sekcji galerii.")
    public void shouldDisplayCorrectGalleryHeader() {
        openConsoleGallery();

        Assert.assertTrue(
                galleryPage.headerName().contains("Galeria, Konsola"),
                "❌ Nagłówek galerii nie został znaleziony!"
        );
    }

    @Test(groups = {"gallery"})
    @Feature("Galeria Sprzętu")
    @Story("Galeria Microsoft")
    @Severity(SeverityLevel.NORMAL)
    @Description("Filtrowanie galerii do marki Microsoft i weryfikacja listy elementów.")
    public void shouldDisplayMicrosoftGallery() {
        openConsoleGallery();
        selectMicrosoftGallery();

        Assert.assertTrue(
                galleryPage.allMicrosoftGalleryListCheck(),
                "❌ Lista elementów Microsoft nie jest widoczna!"
        );
    }

    @Step("Filtrowanie galerii dla marki Microsoft")
    private void selectMicrosoftGallery() {
        galleryPage.clickMicrosoft();
    }

    @Test(groups = {"gallery"})
    @Feature("Galeria Sprzętu")
    @Story("Galeria Microsoft")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Sprawdzenie, czy galeria dedykowana dla marki Xbox zawiera przynajmniej jeden element.")
    public void shouldDisplayXboxGalleryItems() {
        openConsoleGallery();
        selectMicrosoftGallery();
        selectXboxGallery();

        int count = logAndGetCount("Xbox", galleryPage.getXboxGalleryCount());

        Assert.assertTrue(count > 0, "❌ Galeria Xbox jest pusta!");
    }

    @Step("Wybór podkategorii Xbox w galerii Microsoft")
    private void selectXboxGallery() {
        galleryPage.clickXbox();
    }

    @Test(groups = {"gallery"})
    @Feature("Galeria Sprzętu")
    @Story("Galeria Nintendo")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Sprawdzenie, czy galeria dla platform Nintendo zawiera zdjęcia/elementy.")
    public void shouldDisplayNintendoGalleryItems() {
        openConsoleGallery();
        selectNintendoGallery();

        int count = logAndGetCount("Nintendo", galleryPage.getNintendoGalleryCount());

        Assert.assertTrue(count > 0, "❌ Galeria Nintendo jest pusta!");
    }

    @Step("Filtrowanie galerii dla marki Nintendo")
    private void selectNintendoGallery() {
        galleryPage.clickNintendo();
    }

    @Step("Pobieranie i logowanie liczby elementów dla galerii: {galleryName}")
    private int logAndGetCount(String galleryName, int count) {
        System.out.println("📸 Liczba elementów w galerii " + galleryName + ": " + count);
        return count;
    }
}