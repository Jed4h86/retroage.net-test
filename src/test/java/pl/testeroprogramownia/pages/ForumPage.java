package pl.testeroprogramownia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForumPage {

    private WebDriver driver;

    @FindBy(xpath = ("//span[contains(text(),'Zarejestruj się')]"))
    private WebElement register;

    @FindBy(xpath =("//*[@id='agreement']/div[1]/div/div/h2"))
    private WebElement registrationConditions;

    public ForumPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void registration() {
        register.click();
    }

    public WebElement getRegistrationConditions() {
        return registrationConditions;
    }
}
