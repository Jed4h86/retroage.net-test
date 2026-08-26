package pl.testeroprogramownia.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.ForumPage;
import pl.testeroprogramownia.pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ForumTest extends BaseTest {

    @Test
    public void forumButtonTest() {
        HomePage homePage = new HomePage(driver);
        homePage.forumIcon();

        // Sprawdzenie URL forum
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.retroage.net/forum/",
                "Strona forum nie została poprawnie wyświetlona.");

        // Screenshot do folderu projektu
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("target/screenshots/forum-page.png");
            destination.getParentFile().mkdirs(); // upewniamy się, że folder istnieje
            Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Inicjalizacja ForumPage
        ForumPage forumPage = new ForumPage(driver);

        // Rejestracja
        forumPage.clickRegister();
        Assert.assertTrue(forumPage.getRegistrationConditionsText().contains("Rejestracja"),
                "Warunki rejestracji nie są poprawne.");

        forumPage.acceptAgreement();

        // Generowanie unikalnych danych
        String timestamp = String.valueOf(System.currentTimeMillis());
        String username = "Ania" + timestamp;
        String email = "michal" + timestamp + "@gmail.com";

        forumPage.fillUsername(username);
        forumPage.fillPassword("Lantis86!");
        forumPage.fillPasswordConfirmation("Lantis86!");
        forumPage.fillEmail(email);
        forumPage.clickSubmit();

        // Można dodać asercję po submit, np. sprawdzenie komunikatu lub URL
        String newUrl = driver.getCurrentUrl();
        Assert.assertTrue(newUrl.contains("forum"), "Po rejestracji nie nastąpiło przekierowanie na forum.");
    }
}
