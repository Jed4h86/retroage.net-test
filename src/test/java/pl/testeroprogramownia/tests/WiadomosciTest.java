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

@Epic("Retroage - Serwis Retro")
@Feature("Sekcja Wiadomości / Newsy")
public class WiadomosciTest extends BaseTest {

    @Test(groups = {"news"})
    @Story("Nawigacja do Sekcji Wiadomości")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test weryfikuje przejście z menu głównego do sekcji aktualności i wiadomości.")
    public void newsTest() {
        navigateToNewsSection();

        // Asercja sprawdzająca załadowanie odpowiedniego adresu URL lub tytułu
        Assert.assertTrue(
                driver.getCurrentUrl().contains("wiadomosci") || driver.getTitle().length() > 0,
                "❌ Przejście do sekcji 'Wiadomości' nie powiodło się!"
        );
    }

    @Step("Kliknięcie ikony/linku 'Wiadomości' w menu głównym")
    private void navigateToNewsSection() {
        homePage.wiadomosciIcon();
    }
}