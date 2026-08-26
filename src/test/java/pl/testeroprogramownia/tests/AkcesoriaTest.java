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
import pl.testeroprogramownia.pages.AccessoriesPage;

@Epic("Retroage - Serwis Retro")
@Feature("Sekcja Akcesoriów")
public class AkcesoriaTest extends BaseTest {

    @Test(groups = {"accessories"})
    @Story("Nawigacja i Przeglądanie Akcesoriów")
    @Severity(SeverityLevel.NORMAL)
    @Description("Weryfikacja przechodzenia między zakładkami w sekcji akcesoriów (Opisy oraz Galerie).")
    public void testAkcesoria() {
        AccessoriesPage accessoriesPage = openAccessoriesSection();

        interactWithAccessoriesTabs(accessoriesPage);

        // Asercja weryfikująca, że strona/sekcja załadowała się poprawnie
        Assert.assertNotNull(
                accessoriesPage,
                "❌ Obiekt AccessoriesPage nie został poprawnie zainicjalizowany!"
        );
    }

    @Step("Przejście ze strony głównej do sekcji Akcesoriów")
    private AccessoriesPage openAccessoriesSection() {
        return homePage.otworzAkcesoria();
    }

    @Step("Przeklikanie zakładek w sekcji Akcesoriów: Główne Akcesoria -> Opisy -> Galerie")
    private void interactWithAccessoriesTabs(AccessoriesPage accessoriesPage) {
        accessoriesPage.openAkcesoriaTab();
        accessoriesPage.openOpisy();
        accessoriesPage.openGalerie();
    }
}