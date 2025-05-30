package pl.testeroprogramownia.tests;

import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

public class MenuBarTest extends BaseTest {

    @Test
    public void MenuBarTest(){
        HomePage homePage = new HomePage(driver);
        homePage.clickMenuBar();
        //homePage.assertDropdownMenuItemsVisible();



    }
}
