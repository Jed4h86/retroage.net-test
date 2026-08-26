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
@Feature("Strona Główna")
public class LogoTest extends BaseTest {

    @Test(groups = {"home"})
    @Story("Wyświetlanie i klikalność Logo")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Sprawdza, czy logo serwisu jest widoczne na stronie głównej oraz czy jest klikalne.")
    public void customLogoTest() {
        verifyLogoVisibility();
        clickLogoStep();
    }

    @Step("Weryfikacja widoczności logo na stronie głównej")
    private void verifyLogoVisibility() {
        Assert.assertTrue(
                homePage.isLogoVisible(),
                "❌ Logo NIE jest widoczne na stronie głównej!"
        );
    }

    @Step("Kliknięcie w logo serwisu")
    private void clickLogoStep() {
        homePage.clickLogo();
    }
}