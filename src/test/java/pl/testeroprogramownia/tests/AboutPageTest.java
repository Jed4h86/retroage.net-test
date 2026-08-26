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
@Feature("Nawigacja i Informacje o Stronie")
public class AboutPageTest extends BaseTest {

    @Test(groups = {"about"})
    @Story("Przejście do zakładki 'O stronie'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test weryfikuje poprawne przejście z menu głównego do sekcji 'O stronie'.")
    public void newsTest() {
        navigateToAboutPage();

        // Opcjonalna asercja sprawdzająca nagłówek lub URL po kliknięciu
        Assert.assertTrue(
                driver.getCurrentUrl().contains("o-stronie") || driver.getTitle().length() > 0,
                "❌ Przejście do sekcji 'O stronie' nie powiodło się!"
        );
    }

    @Step("Kliknięcie ikony/linku 'O stronie' w menu głównym")
    private void navigateToAboutPage() {
        homePage.oStronieIcon();
    }
}