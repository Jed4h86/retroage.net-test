package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

import java.util.Set;

public class MenuBarTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setUpTest() {
        homePage = new HomePage(driver);
        homePage.clickMenuBar(); // zawsze otwieramy menu przed testem
    }

    @Test
    public void menuDropdownTest() {
        Assert.assertTrue(homePage.isDropdownVisible(),
                "Menu rozwijane nie jest widoczne!");
    }

    @Test
    public void facebookLinkTest() {
        String mainWindow = driver.getWindowHandle();
        homePage.clickFacebook();

        // Sprawdzenie, czy otworzyło się nowe okno
        Set<String> handles = driver.getWindowHandles();
        Assert.assertTrue(handles.size() > 1, "Nie otworzyło się nowe okno po kliknięciu Facebooka");
    }

    @Test
    public void youtubeLinkTest() {
        String mainWindow = driver.getWindowHandle();
        homePage.clickYoutube();

        // Sprawdzenie, czy otworzyło się nowe okno
        Set<String> handles = driver.getWindowHandles();
        Assert.assertTrue(handles.size() > 1, "Nie otworzyło się nowe okno po kliknięciu YouTube");
    }
}
