package pl.testeroprogramownia.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private Actions actions;
    private String mainWindowHandle;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        this.mainWindowHandle = driver.getWindowHandle(); // zapisujemy uchwyt głównego okna
    }

    public String getMainWindowHandle() {
        return mainWindowHandle;
    }

    // ELEMENTY

    @FindBy(xpath = "//div[@class='logo-wrapper ']//a[@class='custom-logo-link']")
    private WebElement customLogo;

    @FindBy(xpath = "//a[@class='gum-slidein-menu-toggle top']//i[@class='fa fa-bars']")
    private WebElement menuBar;

    @FindBy(xpath = "//*[@id='menu-item-5']/a")
    private WebElement forum;

    @FindBy(xpath = "//li[@id='menu-item-2174']")
    private WebElement gry;

    @FindBy(xpath = "//li[@id='menu-item-2178']")
    private WebElement recenzje;

    @FindBy(xpath = "//li[@id='menu-item-4330']")
    private WebElement homebrew;

    @FindBy(xpath = "//li[@id='menu-item-5765']")
    private WebElement niewydane;

    @FindBy(xpath = "//li[@id='menu-item-17796']")
    private WebElement solucje;

    @FindBy(xpath = "//li[@id='menu-item-2190']")
    private WebElement konsole;

    @FindBy(xpath = "//li[@id='menu-item-22796']")
    private WebElement akcesoria;

    @FindBy(xpath = "//li[@id='menu-item-22889']")
    private WebElement opisyAkcesoriów;


    @FindBy(xpath = "//li[@id='menu-item-2178' or @id='menu-item-4330' or @id='menu-item-5765' or @id='menu-item-17796']")
    private List<WebElement> listaGier;

    @FindBy(xpath = "//li[@id='menu-item-2177']")
    private WebElement opisyKonsol;

    @FindBy (xpath = "//li[@id='menu-item-22855']")
    private WebElement galerieKonsol;

    @FindBy(xpath = "//li[@id='menu-item-2177 or menu-item-22855']")
    private List<WebElement> listaKonsol;

    @FindBy(xpath = "//div[@class='toggle-menu-wrapper show-slidein']")
    private List<WebElement> dropDownMenuList;

    @FindBy(xpath = "//li[@id='menu-item-2176']")
    private WebElement artykuly;

    @FindBy(xpath ="//li[@id='menu-item-2179']")
    private WebElement wiadomosci;

    @FindBy(xpath ="//li[@id='menu-item-24889']")
    private WebElement o_stronie;

    @FindBy(xpath ="//li[@id='menu-item-24888']")
    private WebElement historia;

    @FindBy(xpath ="//li[@id='menu-item-7934']")
    private WebElement skarbonka;

    @FindBy(xpath = "//a[@id='gum_search_icon']")
    private WebElement search;

    @FindBy(xpath = "//div[@class='seach-box displayBlock']//input[@placeholder='Wpisz i naciśnij Enter']")
    private WebElement searchText;

    @FindBy(xpath = "//li[@id ='menu-item-2203']//a[contains(@href,'facebook')]")
    private WebElement facebook;

    @FindBy(xpath = "//*[@id='menu-item-2202']//a[contains(@href,'youtube')]")
    private WebElement youtube;



    // AKCJE

    @Step("Sprawdzam, czy logo jest widoczne")
    public boolean isLogoVisible() {
        return customLogo.isDisplayed();
    }

    public void clickLogo() {
        customLogo.click();
    }

    public void clickMenuBar() {
        menuBar.click();
    }

    public void clickFacebook() {
        facebook.click();
    }

    public void clickYoutube() {
        youtube.click();
    }

    public boolean isDropdownVisible() {
        return dropDownMenuList.stream().allMatch(WebElement::isDisplayed);
    }

    public void forumIcon() {
        forum.click();
    }

    public void gryIcon() {
        gry.click();
    }

    public void recenzjeButton() {
        actions.keyDown(Keys.CONTROL).click(recenzje).keyUp(Keys.CONTROL).build().perform();
    }

    public void homebrewIcon() {
        WebElement link = homebrew.findElement(By.tagName("a"));
        String href = link.getAttribute("href");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open(arguments[0], '_blank');", href);
    }

    public void niewydaneIcon() {
        actions.keyDown(Keys.CONTROL).click(niewydane).keyUp(Keys.CONTROL).build().perform();
    }

    public void solucjeIcon() {
        actions.keyDown(Keys.CONTROL).click(solucje).keyUp(Keys.CONTROL).build().perform();
    }

    public boolean czyWszystkieElementyIstnieją() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(listaGier));
        return listaGier.size() == 4;
    }

    public void konsoleIcon() {
        konsole.click();
    }

    public boolean czyWszystkieKonsoleSa() {
        return listaKonsol.stream().allMatch(WebElement::isDisplayed);
    }

    public void opisyKonsolIcon() {
        actions.keyDown(Keys.CONTROL).click(opisyKonsol).keyUp(Keys.CONTROL).build().perform();

    }
    public void galerieKonsol(){
        actions.keyDown(Keys.CONTROL).click(galerieKonsol).keyUp(Keys.CONTROL).build().perform();
    }
    // Otwórz stronę akcesoriów w nowym oknie i zwróć PageObject do pracy dalej

    public AccessoriesPage otworzAkcesoria() {
        String href = akcesoria.findElement(By.tagName("a")).getAttribute("href");
        driver.switchTo().newWindow(WindowType.WINDOW).get(href);

        // przełącz się na nowe okno
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        return new AccessoriesPage(driver);
    }

    public void articlesIcon(){
        artykuly.click();
    }
    public void  wiadomosciIcon(){
        wiadomosci.click();
    }
    public void oStronieIcon(){
        o_stronie.click();
    }

    public void historiaIcon(){
        historia.click();
    }
    public void skarbonkaIcon(){
        skarbonka.click();
    }
    public void searchIcon(){
    search.click();
    searchText.sendKeys("Terminator");
    searchText.sendKeys(Keys.ENTER);

    }
}
