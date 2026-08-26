package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.ArticlesPage;
import pl.testeroprogramownia.pages.HomePage;

import java.util.List;
import java.util.stream.Collectors;

public class ArtykulyTest extends BaseTest {

    @Test
    public void articleListVisibilityTest() {
        HomePage homePage = new HomePage(driver);
        homePage.articlesIcon();

        ArticlesPage articlesPage = new ArticlesPage(driver);

        // Sprawdzenie, że lista artykułów jest widoczna
        Assert.assertTrue(articlesPage.allArticlesListCheck(), "Lista wszystkich artykułów nie jest widoczna!");
    }

    @Test
    public void articleSearchTest() {
        HomePage homePage = new HomePage(driver);
        homePage.articlesIcon();

        ArticlesPage articlesPage = new ArticlesPage(driver);

        // Szukanie konkretnego artykułu
        String articleTitle = "Resident Evil Sega Mega Drive demake – wywiad";
        articlesPage.searchArticleByTitle(articleTitle);

        // Sprawdzenie tytułu artykułu
        Assert.assertEquals(articlesPage.getTitle(), articleTitle, "Tytuł artykułu nie zgadza się!");
    }

    @Test
    public void sortingTest() {
        HomePage homePage = new HomePage(driver);
        homePage.articlesIcon();

        ArticlesPage articlesPage = new ArticlesPage(driver);

        // Pobierz tytuły przed sortowaniem
        List<String> beforeSort = articlesPage.getArticleTitles();

        // Sortowanie po tytule malejąco
        articlesPage.sortByTitleDesc();

        // Pobierz tytuły po sortowaniu
        List<String> afterSort = articlesPage.getArticleTitles();

        // Sprawdzenie, że kolejność jest inna
        Assert.assertNotEquals(afterSort, beforeSort, "Lista artykułów nie zmieniła kolejności po sortowaniu!");

        // Sprawdzenie, że lista jest posortowana malejąco
        List<String> sortedDesc = afterSort.stream()
                .sorted((a, b) -> b.compareToIgnoreCase(a))
                .collect(Collectors.toList());

        Assert.assertEquals(afterSort, sortedDesc, "Artykuły nie są posortowane malejąco według tytułu!");

        // Sortowanie po dacie (najnowsze)
        articlesPage.sortByDateAsc();

        // Pobierz tytuły po sortowaniu po dacie
        List<String> afterDateSort = articlesPage.getArticleTitles();

        // Sprawdzenie, że lista po dacie różni się od oryginalnej
        Assert.assertNotEquals(afterDateSort, beforeSort, "Lista artykułów nie zmieniła kolejności po sortowaniu po dacie!");
        Assert.assertFalse(afterDateSort.isEmpty(), "Lista artykułów po sortowaniu po dacie jest pusta!");
    }

    @Test
    public void categoriesTest() {
        HomePage homePage = new HomePage(driver);
        homePage.articlesIcon();

        ArticlesPage articlesPage = new ArticlesPage(driver);

        // Sprawdzenie widoczności kategorii
        Assert.assertTrue(articlesPage.categoriesAreVisible(), "Kategorie nie są widoczne!");

        // Weryfikacja tekstu przykładowej kategorii
        Assert.assertEquals(articlesPage.getCategoryText("Retrospekcje"), "Retrospekcje", "Tekst kategorii nie zgadza się!");

        // Kliknięcie i sprawdzenie liczby artykułów w różnych kategoriach
        String[] categories = {"Okolicznościowy", "Poradnik techniczny", "Publicystyka", "Recenzja",
                "Recenzja książki", "Recenzja prasy", "Relacja", "Retrospekcje", "Varia", "Wywiad"};

        for (String category : categories) {
            articlesPage.clickCategoryByName(category);
            Assert.assertTrue(articlesPage.getArticlesCount() > 0, "Brak artykułów w kategorii " + category + "!");
        }
    }
}
