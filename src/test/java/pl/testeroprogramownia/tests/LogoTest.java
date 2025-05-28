package pl.testeroprogramownia.tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramownia.pages.HomePage;

public class LogoTest extends BaseTest {


    @Test
    @Epic("Strona główna")
    @Feature("Logo")
    @Story("Wyświetlanie logo")
    @Description("Sprawdza czy logo jest widoczne na stronie głównej")
    @Severity(SeverityLevel.CRITICAL)

    public void CustomLogoTest(){

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLogoVisible(), "Logo NIE jest widoczne na stronie głównej");
        homePage.clickLogo();



        }
    }

