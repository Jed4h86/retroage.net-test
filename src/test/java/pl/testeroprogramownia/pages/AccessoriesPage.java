package pl.testeroprogramownia.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccessoriesPage {
    private Actions actions;

    private WebDriver driver;

    @FindBy(xpath = "//li[@id='menu-item-22796']")
    private WebElement akcesoria;

    @FindBy(xpath = "//li[@id='menu-item-2175']")
    private WebElement opisy;

    @FindBy(xpath = "//li[@id='menu-item-22889']")
    private WebElement galerie;

    private WebDriverWait wait;
    public AccessoriesPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void akcesoriaTab() {
        wait.until(ExpectedConditions.elementToBeClickable(akcesoria)).click();
    }

    public void kliknijOpisy() {
        wait.until(ExpectedConditions.elementToBeClickable(opisy));
        actions.keyDown(Keys.CONTROL).click(opisy).keyUp(Keys.CONTROL).build().perform();

    }

    public void kliknijGalerie() {
        wait.until(ExpectedConditions.elementToBeClickable(galerie));
        actions.keyDown(Keys.CONTROL).click(galerie).keyUp(Keys.CONTROL).build().perform();
    }
}

