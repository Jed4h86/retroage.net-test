package pl.testeroprogramownia.tests;

import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

public class ForumTest extends BaseTest {
    @Test
    public void forumButtonTest(){
        new HomePage(driver)
        .forumIcon();



    }
}
