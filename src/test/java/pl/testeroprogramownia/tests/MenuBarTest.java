package pl.testeroprogramownia.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

@Epic("Retroage - Serwis Retro")
@Feature("Pasek Nawigacyjny i Social Media")
public class MenuBarTest extends BaseTest {

    @BeforeMethod
    public void setUpTest() {
        openMenuBar();
    }

    @Step("Otwarcie rozwijanego paska nawigacyjnego (Menu Bar)")
    private void openMenuBar() {
        homePage.clickMenuBar();
    }

    @Test(groups = {"navigation"})
    @Story("Menu Rozwijane")
    @Severity(SeverityLevel.NORMAL)
    @Description("Weryfikacja, czy rozwijane menu nawigacyjne wyświetla się poprawnie po kliknięciu ikonki.")
    public void menuDropdownTest() {
        Assert.assertTrue(
                homePage.isDropdownVisible(),
                "❌ Menu rozwijane nie jest widoczne!"
        );
    }

    @Test(groups = {"social-media"})
    @Story("Odnośniki Social Media")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sprawdzenie, czy kliknięcie ikony Facebooka otwiera nową kartę/okno w przeglądarce.")
    public void facebookLinkTest() {
        clickFacebookStep();
        verifyNewTabOpened("Facebook");
    }

    @Step("Kliknięcie w odnośnik do profilu Facebook")
    private void clickFacebookStep() {
        homePage.clickFacebook();
    }

    @Test(groups = {"social-media"})
    @Story("Odnośniki Social Media")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sprawdzenie, czy kliknięcie ikony YouTube otwiera nową kartę/okno w przeglądarce.")
    public void youtubeLinkTest() {
        clickYoutubeStep();
        verifyNewTabOpened("YouTube");
    }

    @Step("Kliknięcie w odnośnik do kanału YouTube")
    private void clickYoutubeStep() {
        homePage.clickYoutube();
    }

    @Step("Weryfikacja, czy po kliknięciu linku do {platformName} otworzyła się nowa karta/okno")
    private void verifyNewTabOpened(String platformName) {
        Set<String> handles = driver.getWindowHandles();
        Assert.assertTrue(
                handles.size() > 1,
                "❌ Nie otworzyło się nowe okno po kliknięciu " + platformName + "!"
        );
    }
}