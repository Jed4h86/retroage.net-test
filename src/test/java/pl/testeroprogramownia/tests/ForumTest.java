package pl.testeroprogramownia.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.testeroprogramownia.pages.ForumPage;
import pl.testeroprogramownia.pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ForumTest extends BaseTest {
//    SoftAssert softAssert = new SoftAssert();
@Test
public void forumButtonTest() {
    HomePage homePage = new HomePage(driver);
    homePage.forumIcon();

    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals(currentUrl, "https://www.retroage.net/forum/", "Strona forum nie została poprawnie wyświetlona.");



    // ROBIMY SCREENSHOT
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
        Files.copy(screenshot.toPath(),
                new File("C:/Users/Użytkownik/IdeaProjects/retroage.net/target/forum-page.png").toPath(),
                StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
        e.printStackTrace();
    }
    ForumPage forumPage = new ForumPage(driver);
    forumPage.clickRegister();

//    SoftAssert softAssert = new SoftAssert();
//    String registrationTitle = forumPage.getRegistrationConditionsText();
//    softAssert.assertEquals(registrationTitle, "retroage.net - Rejestracja", "Warunki rejestracji nie są poprawne.");

    forumPage.acceptAgreement();
    forumPage.fillUsername("Ania");

//    softAssert.assertAll();


    }

}
