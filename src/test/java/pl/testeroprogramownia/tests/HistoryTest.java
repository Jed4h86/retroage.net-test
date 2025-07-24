package pl.testeroprogramownia.tests;

import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

public class HistoryTest extends BaseTest {

    @Test
    public void historyTest() {
        HomePage homePage = new HomePage(driver);
        homePage.historiaIcon();
    }
}
