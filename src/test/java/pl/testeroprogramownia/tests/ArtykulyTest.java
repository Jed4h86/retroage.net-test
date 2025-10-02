package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pl.testeroprogramownia.pages.ArticlesPage;
import pl.testeroprogramownia.pages.HomePage;

import java.util.List;
import java.util.stream.Collectors;

public class ArtykulyTest extends BaseTest {

    @Test
    public void articleTests() {
        HomePage homePage = new HomePage(driver);
        homePage.articlesIcon();

        ArticlesPage articlesPage = new ArticlesPage(driver);

        // sprawdzenie, że lista artykułów jest widoczna
        Assert.assertTrue(articlesPage.allArticlesListCheck(), "Lista wszystkich artykułów nie jest widoczna!");

    }

    @Test
    public void articleSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.articlesIcon();

        ArticlesPage articlesPage = new ArticlesPage(driver);

        // szukanie konkretnego artykułu po stronach
        articlesPage.reSearch();

        Assert.assertEquals(articlesPage.getTitle(),"Resident Evil Sega Mega Drive demake – wywiad");

    }

    @Test
    public void sortingTest() {
        HomePage homePage = new HomePage(driver);
        homePage.articlesIcon();

        ArticlesPage articlesPage = new ArticlesPage(driver);

        // pobierz tytuły przed sortowaniem
        List<String> beforeSort = articlesPage.getArticleTitles();

        // kliknij sortowanie po tytule DESC
        articlesPage.sortingDesc();

        // pobierz tytuły po sortowaniu
        List<String> afterSort = articlesPage.getArticleTitles();

        // sprawdź, że kolejność jest inna
        Assert.assertNotEquals(afterSort, beforeSort,
                "Lista artykułów nie zmieniła kolejności po sortowaniu!");

        // sprawdź, że lista jest posortowana malejąco
        List<String> sortedDesc = afterSort.stream()
                .sorted((a, b) -> b.compareToIgnoreCase(a))
                .collect(Collectors.toList());

        Assert.assertEquals(afterSort, sortedDesc,
                "Artykuły nie są posortowane malejąco według tytułu!");

        // sortowanie po dacie (najnowsze)
        articlesPage.sortingDateAsc();

        // pobierz tytuły po sortowaniu po dacie
        List<String> afterDateSort = articlesPage.getArticleTitles();

        // sprawdź, że lista po dacie różni się od oryginalnej
        Assert.assertNotEquals(afterDateSort, beforeSort,
                "Lista artykułów nie zmieniła kolejności po sortowaniu po dacie!");

        // jeśli chcesz sprawdzić kolejność dat, trzeba użyć odpowiedniego kryterium
        // na razie sprawdzimy tylko, że lista nie jest pusta i zmieniła kolejność
        Assert.assertFalse(afterDateSort.isEmpty(), "Lista artykułów po sortowaniu po dacie jest pusta!");
    }




    @Test
    public void categoriesTest() {
        HomePage homePage = new HomePage(driver);
        homePage.articlesIcon();

        ArticlesPage articlesPage = new ArticlesPage(driver);

        // sprawdzenie czy kategorie są widoczne
        Assert.assertTrue(articlesPage.categories(), "Kategorie nie są widoczne!");

        // weryfikacja tekstu przykładowej kategorii
        Assert.assertEquals(articlesPage.categoryText(),
                "Retrospekcje", "Tekst kategorii nie zgadza się!");

        // klik w kategorię Okolicznościowy
        articlesPage.clickCategoryByName("Okolicznościowy");
        Assert.assertTrue(articlesPage.getArticlesCount() > 0,
                "Brak artykułów w kategorii Okolicznościowy!");

         //klik w kategorię Poradnik Techniczny
        articlesPage.clickCategoryByName("Poradnik techniczny");
        Assert.assertTrue(articlesPage.getArticlesCount() > 0,
                "Brak artykułów w kategorii Poradnik techniczny!");

        // klik w inne kategorie i sprawdzenie liczby artykułów
        articlesPage.clickCategoryByName("Publicystyka");
        Assert.assertTrue(articlesPage.getArticlesCount() > 0,
                "Brak artykułów w kategorii Publicystyka!");

        articlesPage.clickCategoryByName("Recenzja");
        Assert.assertTrue(articlesPage.getArticlesCount() > 0,
                "Brak artykułów w kategorii Recenzja!");

        articlesPage.clickCategoryByName("Recenzja książki");
        Assert.assertTrue(articlesPage.getArticlesCount() > 0,
                "Brak artykułów w kategorii Recenzja książki!");

        articlesPage.clickCategoryByName("Recenzja prasy");
        Assert.assertTrue(articlesPage.getArticlesCount()>0,
                "Brak artykułów w kategorii Recenzja prasy!");

        articlesPage.clickCategoryByName("Relacja");
        Assert.assertTrue(articlesPage.getArticlesCount()>0,
                "Brak artykułów w kategorii Relacja");

        articlesPage.clickCategoryByName("Retrospekcje");
        Assert.assertTrue(articlesPage.getArticlesCount()>0,
                "Brak artykułów w kategorii Retrospekcje");

        articlesPage.clickCategoryByName("Varia");
        Assert.assertTrue(articlesPage.getArticlesCount()>0,
                "Brak artykułów w kategorii Varia");

        articlesPage.clickCategoryByName("Wywiad");
        Assert.assertTrue(articlesPage.getArticlesCount()>0,
                "Brak artykułów w kategorii Wywiad");
    }
}
