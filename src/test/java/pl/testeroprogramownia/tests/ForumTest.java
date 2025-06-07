package pl.testeroprogramownia.tests;

import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

public class ForumTest extends BaseTest {
    @Test
    public void forumButtonTest(){
        HomePage homePage = new HomePage(driver);
        homePage.forumIcon();



    }
}
