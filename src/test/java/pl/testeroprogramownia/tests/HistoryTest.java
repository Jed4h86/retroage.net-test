package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HistoryPage;
import pl.testeroprogramownia.pages.HomePage;

public class HistoryTest extends BaseTest {

    private HomePage homePage;
    private HistoryPage historypage;

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

    @Test
    public void historyTest() {

        homePage.historiaIcon();
    }

    @Test
    public void shouldContainPictures() {
        historypage = new HistoryPage(driver);
        homePage.historiaIcon();
        Assert.assertTrue(historypage.picturesList(), "Nie wszystkie obrazki są widoczne");

    }

    @Test
    public void checkPicturesList() {
        homePage.historiaIcon();
        historypage = new HistoryPage(driver);
        historypage.checkPictures();
    }

    @Test
    public void next() {
        homePage.historiaIcon();
        historypage = new HistoryPage(driver);
        historypage.checkPictures();
        historypage.clickThroughAllPictures();

        Assert.assertFalse(historypage.isNextButtonPresent(),
                "❌ Przycisk NEXT nadal widoczny — galeria nie została przeklikana do końca");
    }
}
