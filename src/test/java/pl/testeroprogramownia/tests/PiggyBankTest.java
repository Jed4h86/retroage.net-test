package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;
import pl.testeroprogramownia.pages.PiggyBankPage;

public class PiggyBankTest extends BaseTest {

    @Test
    public void piggyBankTest() {
        HomePage homePage = new HomePage(driver);
        homePage.skarbonkaIcon();

        PiggyBankPage piggyBankPage = new PiggyBankPage(driver);

        // Debug – pokaż co Selenium faktycznie zwraca
        System.out.println("Lista loginów:");
        piggyBankPage.getAllLogins().forEach(System.out::println);

        Assert.assertTrue(
                piggyBankPage.isLoginPresentStream("Kanarekkk"),
                "Login 'Kanarekkk' nie został znaleziony na liście! "
                        + "Pełna lista: " + piggyBankPage.getAllLogins()
        );
    }

}

