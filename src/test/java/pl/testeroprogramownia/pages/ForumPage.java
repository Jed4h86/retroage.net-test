package pl.testeroprogramownia.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ForumPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[contains(text(),'Zarejestruj się')]")
    private WebElement register;

    @FindBy(xpath = "//*[@id='agreement']/div[1]/div/div/h2")
    private WebElement registrationConditions;

    @FindBy(xpath = "//*[@id='agreed']")
    private WebElement agreeButton;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='password_confirm']")
    private WebElement passwordConfirm;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='submit']")
    private WebElement submit;

    public ForumPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickRegister() {
        register.click();
    }

    public void acceptAgreement() {
        //wait.until(ExpectedConditions.elementToBeClickable(agreeButton)).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", agreeButton);


    }

//    public String getRegistrationConditionsText() {
//        return wait.until(ExpectedConditions.visibilityOf(registrationConditions)).getText();
//    }

    public void fillUsername(String name) {
        // wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(name);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));", username, name);
        //username.sendKeys();
    }

    public void fillPassword(String name) {

        password.sendKeys();
    }

    public void fillPasswordConfirmation(String name) {
        passwordConfirm.sendKeys();
    }
    public void fillEmail(String name){
        email.sendKeys();
    }

}

