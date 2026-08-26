package pl.testeroprogramownia.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.PiggyBankPage;

import java.util.List;

@Epic("Retroage - Serwis Retro")
@Feature("Sekcja Skarbonki / Wsparcie")
public class PiggyBankTest extends BaseTest {

    @Test(groups = {"piggy-bank"})
    @Story("Lista Donatorów")
    @Severity(SeverityLevel.NORMAL)
    @Description("Weryfikacja załadowania listy donatorów oraz obecności kluczowych loginów wspierających serwis.")
    public void piggyBankTest() {
        navigateToPiggyBank();

        PiggyBankPage piggyBankPage = new PiggyBankPage(driver);

        List<String> allLogins = fetchAndLogDonators(piggyBankPage);

        verifyDonatorsListNotEmpty(allLogins);

        List<String> expectedLogins = List.of("Kanarekkk", "Axi0mat");
        for (String login : expectedLogins) {
            verifyDonatorPresence(piggyBankPage, login, allLogins);
        }
    }

    @Step("Przejście do sekcji Skarbonka ze strony głównej")
    private void navigateToPiggyBank() {
        homePage.skarbonkaIcon();
    }

    @Step("Pobranie i zalogowanie listy donatorów ze strony Skarbonki")
    private List<String> fetchAndLogDonators(PiggyBankPage piggyBankPage) {
        List<String> allLogins = piggyBankPage.getAllLogins();
        System.out.println("📸 Lista donatorów (" + allLogins.size() + "): " + allLogins);
        return allLogins;
    }

    @Step("Weryfikacja, czy lista donatorów nie jest pusta")
    private void verifyDonatorsListNotEmpty(List<String> allLogins) {
        Assert.assertFalse(allLogins.isEmpty(), "❌ Lista donatorów jest pusta!");
    }

    @Step("Weryfikacja obecności loginu donatora: '{login}'")
    private void verifyDonatorPresence(PiggyBankPage piggyBankPage, String login, List<String> allLogins) {
        Assert.assertTrue(
                piggyBankPage.isLoginPresentStream(login),
                "❌ Login '" + login + "' nie został znaleziony na liście! Pełna lista: " + allLogins
        );
    }
}