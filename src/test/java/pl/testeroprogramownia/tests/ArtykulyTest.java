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
import pl.testeroprogramownia.pages.ArticlesPage;

import java.util.List;
import java.util.stream.Collectors;

@Epic("Retroage - Serwis Retro")
@Feature("Sekcja Artykułów")
public class ArtykulyTest extends BaseTest {

    private ArticlesPage articlesPage;

    @BeforeMethod
    public void setupArticlesTest() {
        navigateToArticlesSection();
    }

    @Step("Przejście ze strony głównej do sekcji Artykułów")
    private void navigateToArticlesSection() {
        homePage.articlesIcon();
        articlesPage = new ArticlesPage(driver);
    }

    @Test(groups = {"articles"})
    @Story("Lista Artykułów")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Weryfikacja widoczności głównej listy wszystkich artykułów.")
    public void articleListVisibilityTest() {
        Assert.assertTrue(
                articlesPage.allArticlesListCheck(),
                "❌ Lista wszystkich artykułów nie jest widoczna!"
        );
    }

    @Test(groups = {"articles"})
    @Story("Wyszukiwanie Artykułów")
    @Severity(SeverityLevel.NORMAL)
    @Description("Wyszukiwanie konkretnego artykułu po tytule i sprawdzanie nagłówka na stronie docelowej.")
    public void articleSearchTest() {
        String articleTitle = "Resident Evil Sega Mega Drive demake – wywiad";

        searchAndOpenArticle(articleTitle);

        Assert.assertEquals(
                articlesPage.getTitle(),
                articleTitle,
                "❌ Tytuł artykułu nie zgadza się!"
        );
    }

    @Step("Wyszukiwanie artykułu po tytule: '{title}'")
    private void searchAndOpenArticle(String title) {
        articlesPage.searchArticleByTitle(title);
    }

    @Test(groups = {"articles"})
    @Story("Sortowanie Artykułów")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testowanie mechanizmu sortowania artykułów po tytule (malejąco) oraz po dacie (rosnąco).")
    public void sortingTest() {
        List<String> beforeSort = articlesPage.getArticleTitles();

        // Sortowanie po tytule malejąco
        performSortByTitleDesc();
        List<String> afterSort = articlesPage.getArticleTitles();

        Assert.assertNotEquals(
                afterSort,
                beforeSort,
                "❌ Lista artykułów nie zmieniła kolejności po sortowaniu malejącym!"
        );

        List<String> sortedDesc = afterSort.stream()
                .sorted((a, b) -> b.compareToIgnoreCase(a))
                .collect(Collectors.toList());

        Assert.assertEquals(
                afterSort,
                sortedDesc,
                "❌ Artykuły nie są posortowane malejąco według tytułu!"
        );

        // Sortowanie po dacie rosnąco
        performSortByDateAsc();
        List<String> afterDateSort = articlesPage.getArticleTitles();

        Assert.assertNotEquals(
                afterDateSort,
                beforeSort,
                "❌ Lista artykułów nie zmieniła kolejności po sortowaniu po dacie!"
        );
        Assert.assertFalse(
                afterDateSort.isEmpty(),
                "❌ Lista artykułów po sortowaniu po dacie jest pusta!"
        );
    }

    @Step("Wykonanie sortowania artykułów po tytule malejąco (Z-A)")
    private void performSortByTitleDesc() {
        articlesPage.sortByTitleDesc();
    }

    @Step("Wykonanie sortowania artykułów po dacie rosnąco")
    private void performSortByDateAsc() {
        articlesPage.sortByDateAsc();
    }

    @Test(groups = {"articles"})
    @Story("Kategorie Artykułów")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sprawdzenie widoczności kategorii oraz filtrowanie artykułów po dostępnych kategoriach.")
    public void categoriesTest() {
        Assert.assertTrue(
                articlesPage.categoriesAreVisible(),
                "❌ Kategorie nie są widoczne!"
        );

        Assert.assertEquals(
                articlesPage.getCategoryText("Retrospekcje"),
                "Retrospekcje",
                "❌ Tekst kategorii nie zgadza się!"
        );

        String[] categories = {
                "Okolicznościowy", "Poradnik techniczny", "Publicystyka", "Recenzja",
                "Recenzja książki", "Recenzja prasy", "Relacja", "Retrospekcje", "Varia", "Wywiad"
        };

        for (String category : categories) {
            verifyCategoryArticlesCount(category);
        }
    }

    @Step("Filtrowanie i weryfikacja liczby artykułów dla kategorii: '{category}'")
    private void verifyCategoryArticlesCount(String category) {
        articlesPage.clickCategoryByName(category);
        Assert.assertTrue(
                articlesPage.getArticlesCount() > 0,
                "❌ Brak artykułów w kategorii " + category + "!"
        );
    }
}