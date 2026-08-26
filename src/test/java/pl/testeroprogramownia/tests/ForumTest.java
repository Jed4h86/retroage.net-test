package pl.testeroprogramownia.tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.ForumPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Epic("Retroage - Serwis Retro")
@Feature("Sekcja Forum")
public class ForumTest extends BaseTest {

    @Test(groups = {"forum"})
    @Story("Rejestracja Nowego Użytkownika")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Przejście do forum, akceptacja regulaminu oraz proces rejestracji konta z dynamicznym loginem i e-mailem.")
    public void forumButtonTest() {
        navigateToForum();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.retroage.net/forum/",
                "❌ Strona forum nie została poprawnie wyświetlona!"
        );

        saveScreenshotToAllureAndDisk("target/screenshots/forum-page.png");

        ForumPage forumPage = new ForumPage(driver);

        openRegistrationForm(forumPage);

        long timestamp = System.currentTimeMillis();
        String username = "User" + timestamp;
        String email = "testuser" + timestamp + "@gmail.com";

        fillRegistrationForm(forumPage, username, email, "Lantis86!");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("forum"),
                "❌ Po rejestracji nie nastąpiło przekierowanie na forum!"
        );
    }

    @Step("Przejście do sekcji Forum ze strony głównej")
    private void navigateToForum() {
        homePage.forumIcon();
    }

    @Step("Otwarcie formularza rejestracji i zaakceptowanie regulaminu")
    private void openRegistrationForm(ForumPage forumPage) {
        forumPage.clickRegister();
        Assert.assertTrue(
                forumPage.getRegistrationConditionsText().contains("Rejestracja"),
                "❌ Warunki rejestracji nie są poprawne!"
        );
        forumPage.acceptAgreement();
    }

    @Step("Wypełnienie formularza rejestracyjnego dla użytkownika: '{username}'")
    private void fillRegistrationForm(ForumPage forumPage, String username, String email, String password) {
        forumPage.fillUsername(username);
        forumPage.fillPassword(password);
        forumPage.fillPasswordConfirmation(password);
        forumPage.fillEmail(email);
        forumPage.clickSubmit();
    }

    @Step("Zapis zrzutu ekranu na dysku oraz podpięcie pod raport Allure")
    private void saveScreenshotToAllureAndDisk(String filePath) {
        takeScreenshotToDisk(filePath);
        attachScreenshotToAllure();
    }

    @Attachment(value = "Zrzut ekranu po wejściu na forum", type = "image/png")
    private byte[] attachScreenshotToAllure() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private void takeScreenshotToDisk(String filePath) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath);
            destination.getParentFile().mkdirs();
            Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("❌ Nie udało się zapisać zrzutu ekranu: " + e.getMessage());
        }
    }
}