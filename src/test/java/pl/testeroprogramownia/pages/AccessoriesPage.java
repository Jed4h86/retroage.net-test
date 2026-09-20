package pl.testeroprogramownia.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pl.testeroprogramownia.utils.SeleniumHelper.waitForElementToBeClickable;

public class AccessoriesPage {

    private WebDriver driver;
    private Actions actions;

    @FindBy(xpath = "//li[@id='menu-item-22796']")
    private WebElement akcesoriaTab;

    @FindBy(xpath = "//li[@id='menu-item-2175']")
    private WebElement opisy;

    @FindBy(xpath = "//li[@id='menu-item-22889']")
    private WebElement galerie;

    public AccessoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    @Step("Przejście do zakładki 'Akcesoria'")
    public void openAkcesoriaTab() {
        waitForElementToBeClickable(driver, akcesoriaTab);
        akcesoriaTab.click();
    }

    @Step("Otwarcie podstrony 'Opisy' w nowej karcie (CTRL + click)")
    public void openOpisy() {
        clickWithCtrl(opisy);
    }

    @Step("Otwarcie podstrony 'Galerie' w nowej karcie (CTRL + click)")
    public void openGalerie() {
        clickWithCtrl(galerie);
    }

    @Step("Kliknięcie w element z przytrzymanym klawiszem CTRL")
    private void clickWithCtrl(WebElement element) {
        waitForElementToBeClickable(driver, element);
        actions.keyDown(Keys.CONTROL)
                .click(element)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
    }
}