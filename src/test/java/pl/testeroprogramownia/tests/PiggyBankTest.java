package pl.testeroprogramownia.tests;

import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

@Test
public class PiggyBankTest extends BaseTest {
    public void piggyBankTest() {
        HomePage homePage = new HomePage(driver);
        homePage.skarbonkaIcon();

    }
}