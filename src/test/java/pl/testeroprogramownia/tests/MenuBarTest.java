package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

public class MenuBarTest extends BaseTest {

    @Test
    public void MenuBarTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMenuBar();
        Assert.assertTrue(homePage.isDropdownVisible());


    }

    @Test
    public void FacebookTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMenuBar();
        homePage.clickFacebook();
    }

    @Test
    public void YoutubeTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMenuBar();
        homePage.clickYoutube();

    }
}
