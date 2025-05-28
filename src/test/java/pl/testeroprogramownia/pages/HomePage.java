package pl.testeroprogramownia.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    @FindBy(xpath = ("//div[@class ='logo-wrapper ']//a[@class='custom-logo-link']"))
    private WebElement customLogo;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
        public WebElement getCustomLogo() {
            return customLogo;

    }
    public boolean isLogoVisible(){
        Assert.assertTrue(customLogo.isDisplayed(),"Logo widoczne");
        return customLogo.isDisplayed();
    }
@Step("Sprawdzam, czy logo jest widoczne")
public void clickLogo() {
    customLogo.click();
}

}

