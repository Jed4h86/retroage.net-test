package pl.testeroprogramownia.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HistoryPage;

@Epic("Retroage - Serwis Retro")
@Feature("Sekcja Historii")
public class HistoryTest extends BaseTest {

    private HistoryPage historyPage;

    @BeforeMethod
    public void setupHistoryTest() {
        navigateToHistorySection();
    }

    @Step("Przejście ze strony głównej do sekcji Historii")
    private void navigateToHistorySection() {
        homePage.historiaIcon();
        historyPage = new HistoryPage(driver);
    }

    @Test(groups = {"history"})
    @Story("Nawigacja do Sekcji Historii")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test weryfikuje poprawne przejście z menu głównego do podstrony historii na podstawie adresu URL.")
    public void historyTest() {
        Assert.assertTrue(
                driver.getCurrentUrl().contains("historia"),
                "❌ Strona historii nie została załadowana!"
        );
    }

    @Test(groups = {"history"})
    @Story("Galeria Obrazków w Historii")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sprawdzenie widoczności listy obrazków w sekcji historii.")
    public void shouldContainPictures() {
        Assert.assertTrue(
                historyPage.picturesList(),
                "❌ Nie wszystkie obrazki są widoczne"
        );
    }

    @Test(groups = {"history"})
    @Story("Galeria Obrazków w Historii")
    @Severity(SeverityLevel.MINOR)
    @Description("Weryfikacja dostępności obrazków w sekcji historii.")
    public void checkPicturesList() {
        verifyPictures();
    }

    @Step("Inicjalizacja i sprawdzenie obrazków")
    private void verifyPictures() {
        historyPage.checkPictures();
    }

    @Test(groups = {"history"})
    @Story("Galeria Obrazków w Historii")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Przeklikanie całej galerii historii i upewnienie się, że przycisk 'NEXT' znika na ostatnim zdjęciu.")
    public void next() {
        verifyPictures();
        clickThroughGallery();

        Assert.assertFalse(
                historyPage.isNextButtonPresent(),
                "❌ Przycisk NEXT nadal widoczny — galeria nie została przeklikana do końca"
        );
    }

    @Step("Przeklikanie wszystkich elementów galerii przyciskiem NEXT")
    private void clickThroughGallery() {
        historyPage.clickThroughAllPictures();
    }
}