package pl.testeroprogramownia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.ForumPage;
import pl.testeroprogramownia.pages.HomePage;

public class ForumTest extends BaseTest {
    @Test
    public void forumButtonTest(){
       HomePage homePage = new HomePage(driver);
        homePage.forumIcon();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.retroage.net/forum/", "Strona forum nie została poprawnie wyświetlona.");

        ForumPage forumPage = new ForumPage(driver);
        forumPage.registration();

        Assert.assertEquals(forumPage.getRegistrationConditions().getText(),"retroage.net - Rejestracja");


    }

}
