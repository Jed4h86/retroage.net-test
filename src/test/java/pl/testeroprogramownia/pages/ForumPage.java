package pl.testeroprogramownia.pages;

import io.qameta.allure.Step;
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
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id='agreement']/div[1]/div/div/h2")
    private WebElement registrationConditions;

    @FindBy(xpath = "//*[@id='agreed']")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='password_confirm']")
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='submit']")
    private WebElement submitButton;

    public ForumPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Kliknięcie przycisku 'Zarejestruj się'")
    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    @Step("Akceptacja regulaminu rejestracji")
    public void acceptAgreement() {
        wait.until(ExpectedConditions.elementToBeClickable(agreeCheckbox));
        // Jeśli zwykły click nie działa, używamy JS
        try {
            agreeCheckbox.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreeCheckbox);
        }
    }

    @Step("Pobranie nagłówka warunków rejestracji")
    public String getRegistrationConditionsText() {
        return wait.until(ExpectedConditions.visibilityOf(registrationConditions)).getText();
    }

    @Step("Wpisanie nazwy użytkownika: '{name}'")
    public void fillUsername(String name) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).clear();
        usernameInput.sendKeys(name);
    }

    @Step("Wpisanie hasła")
    public void fillPassword(String pwd) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).clear();
        passwordInput.sendKeys(pwd);
    }

    @Step("Potwierdzenie hasła")
    public void fillPasswordConfirmation(String pwd) {
        wait.until(ExpectedConditions.visibilityOf(passwordConfirmInput)).clear();
        passwordConfirmInput.sendKeys(pwd);
    }

    @Step("Wpisanie adresu e-mail: '{mail}'")
    public void fillEmail(String mail) {
        wait.until(ExpectedConditions.visibilityOf(emailInput)).clear();
        emailInput.sendKeys(mail);
    }

    @Step("Kliknięcie przycisku wysłania formularza rejestracji")
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
}