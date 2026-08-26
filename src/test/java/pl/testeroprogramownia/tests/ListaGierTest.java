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

@Epic("Retroage - Serwis Retro")
@Feature("Sekcja Gier")
public class ListaGierTest extends BaseTest {

    @Test(groups = {"games"})
    @Story("Nawigacja i Przeglądanie Sekcji Gier")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Przejście do sekcji gier, weryfikacja obecności kluczowych elementów oraz przeklikanie podsekcji (recenzje, homebrew, niewydane, solucje).")
    public void gryTest() {
        navigateToGamesSection();
        verifyGamesElementsPresence();
        navigateThroughGamesSubsections();
    }

    @Step("Przejście do sekcji Gier ze strony głównej")
    private void navigateToGamesSection() {
        homePage.gryIcon();
    }

    @Step("Weryfikacja widoczności wszystkich wymaganych elementów sekcji Gier")
    private void verifyGamesElementsPresence() {
        Assert.assertTrue(
                homePage.czyWszystkieElementyGierIstnieją(),
                "❌ Nie wszystkie elementy gier są widoczne na stronie!"
        );
    }

    @Step("Przeklikanie podsekcji: Recenzje -> Homebrew -> Niewydane -> Solucje")
    private void navigateThroughGamesSubsections() {
        homePage.recenzjeButton();
        homePage.homebrewIcon();
        homePage.niewydaneIcon();
        homePage.solucjeIcon();
    }
}