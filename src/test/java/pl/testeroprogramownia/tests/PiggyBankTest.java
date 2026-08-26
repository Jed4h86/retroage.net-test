package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;
import pl.testeroprogramownia.pages.PiggyBankPage;

import java.util.List;

public class PiggyBankTest extends BaseTest {

    @Test
    public void piggyBankTest() {
        // Otwórz stronę Skarbonki
        HomePage homePage = new HomePage(driver);
        homePage.skarbonkaIcon();

        // Utwórz PageObject
        PiggyBankPage piggyBankPage = new PiggyBankPage(driver);

        // Pobierz listę loginów
        List<String> allLogins = piggyBankPage.getAllLogins();

        // Debug – pokaż co Selenium faktycznie zwraca
        System.out.println("Lista loginów:");
        allLogins.forEach(System.out::println);

        // Sprawdzenie, że lista nie jest pusta
        Assert.assertFalse(allLogins.isEmpty(), "Lista donatorów jest pusta!");

        // Sprawdzenie, że konkretny login istnieje
        String loginToCheck = "Kanarekkk";
        Assert.assertTrue(
                piggyBankPage.isLoginPresentStream(loginToCheck),
                "Login '" + loginToCheck + "' nie został znaleziony na liście! Pełna lista: " + allLogins
        );

        // Dodatkowo można sprawdzić kilka loginów naraz
        List<String> loginsToCheck = List.of("Kanarekkk", "Axi0mat");
        for (String login : loginsToCheck) {
            Assert.assertTrue(
                    piggyBankPage.isLoginPresentStream(login),
                    "Login '" + login + "' nie został znaleziony na liście! Pełna lista: " + allLogins
            );
        }
    }
}
