package pl.testeroprogramownia.tests;

import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

public class WiadomosciTest extends BaseTest {

    @Test
    public void newsTest(){
        HomePage homePage = new HomePage(driver);
        homePage.wiadomosciIcon();
    }
}
