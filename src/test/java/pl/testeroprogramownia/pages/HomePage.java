package pl.testeroprogramownia.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramownia.utils.SeleniumHelper;

import java.util.List;

public class HomePage {

    private WebDriver driver;
    private Actions actions;
    private String mainWindowHandle;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        this.mainWindowHandle = driver.getWindowHandle();
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

    @FindBy(xpath = "//li[@id='menu-item-2174']/a")
    private WebElement gry;

    @FindBy(xpath = "//li[@id='menu-item-2178']/a")
    private WebElement recenzje;

    @FindBy(xpath = "//li[@id='menu-item-4330']")
    private WebElement homebrew;

    @FindBy(xpath = "//li[@id='menu-item-5765']/a")
    private WebElement niewydane;

    @FindBy(xpath = "//li[@id='menu-item-17796']/a")
    private WebElement solucje;

    @FindBy(xpath = "//li[@id='menu-item-2190']/a")
    private WebElement konsole;

    @FindBy(xpath = "//li[@id='menu-item-22796']/a")
    private WebElement akcesoria;

    @FindBy(xpath = "//li[@id='menu-item-22889']/a")
    private WebElement opisyAkcesoriów;

    @FindBy(xpath = "//li[@id='menu-item-2178' or @id='menu-item-4330' or @id='menu-item-5765' or @id='menu-item-17796']")
    private List<WebElement> listaGier;

    @FindBy(xpath = "//li[@id='menu-item-2177']")
    private WebElement opisyKonsol;

    @FindBy(xpath = "//li[@id='menu-item-22855']")
    private WebElement galerieKonsol;

    @FindBy(xpath = "//li[@id='menu-item-2177' or @id='menu-item-22855']")
    private List<WebElement> listaKonsol;

    @FindBy(xpath = "//div[@class='toggle-menu-wrapper show-slidein']")
    private List<WebElement> dropDownMenuList;

    @FindBy(xpath = "//li[@id='menu-item-2176']/a")
    private WebElement artykuly;

    @FindBy(xpath = "//li[@id='menu-item-2179']/a")
    private WebElement wiadomosci;

    @FindBy(xpath = "//li[@id='menu-item-24889']/a")
    private WebElement o_stronie;

    @FindBy(xpath = "//li[@id='menu-item-24888']/a")
    private WebElement historia;

    @FindBy(xpath = "//li[@id='menu-item-7934']/a")
    private WebElement skarbonka;

    @FindBy(xpath = "//a[@id='gum_search_icon']")
    private WebElement search;

    @FindBy(xpath = "//div[@class='seach-box displayBlock']//input[@placeholder='Wpisz i naciśnij Enter']")
    private WebElement searchText;

    @FindBy(xpath = "//li[@id='menu-item-2203']//a[contains(@href,'facebook')]")
    private WebElement facebook;

    @FindBy(xpath = "//*[@id='menu-item-2202']//a[contains(@href,'youtube')]")
    private WebElement youtube;

    // AKCJE

    @Step("Sprawdzam, czy logo jest widoczne")
    public boolean isLogoVisible() {
        return customLogo.isDisplayed();
    }

    @Step("Klikam w logo strony")
    public void clickLogo() {
        customLogo.click();
    }

    @Step("Otwieram menu nawigacyjne (hamburger menu)")
    public void clickMenuBar() {
        menuBar.click();
    }

    @Step("Klikam w odnośnik do Facebooka")
    public void clickFacebook() {
        facebook.click();
    }

    @Step("Klikam w odnośnik do YouTube")
    public void clickYoutube() {
        youtube.click();
    }

    @Step("Sprawdzam, czy rozwijane menu jest widoczne")
    public boolean isDropdownVisible() {
        return dropDownMenuList.stream().allMatch(WebElement::isDisplayed);
    }

    @Step("Klikam w ikonę Forum")
    public void forumIcon() {
        forum.click();
    }

    @Step("Klikam w ikonę Gry")
    public void gryIcon() {
        gry.click();
    }

    @Step("Otwieram podstronę Recenzje w nowej karcie (CTRL + click)")
    public void recenzjeButton() {
        actions.keyDown(Keys.CONTROL).click(recenzje).keyUp(Keys.CONTROL).build().perform();
    }

    @Step("Otwieram podstronę Homebrew w nowej karcie za pomocą JavaScript")
    public void homebrewIcon() {
        WebElement link = homebrew.findElement(By.tagName("a"));
        String href = link.getAttribute("href");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open(arguments[0], '_blank');", href);
    }

    @Step("Otwieram podstronę Niewydane w nowej karcie (CTRL + click)")
    public void niewydaneIcon() {
        actions.keyDown(Keys.CONTROL).click(niewydane).keyUp(Keys.CONTROL).build().perform();
    }

    @Step("Otwieram podstronę Solucje w nowej karcie (CTRL + click)")
    public void solucjeIcon() {
        actions.keyDown(Keys.CONTROL).click(solucje).keyUp(Keys.CONTROL).build().perform();
    }

    @Step("Sprawdzam, czy wszystkie 4 elementy w sekcji Gry istnieją")
    public boolean czyWszystkieElementyGierIstnieją() {
        SeleniumHelper.waitForElementsToBeVisible(driver, listaGier);
        return listaGier.size() == 4;
    }

    @Step("Klikam w ikonę Konsole")
    public void konsoleIcon() {
        try {
            konsole.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", konsole);
        }
    }

    @Step("Sprawdzam, czy wszystkie podkategorie konsol są widoczne")
    public boolean czyWszystkieKonsoleSa() {
        return listaKonsol.stream().allMatch(WebElement::isDisplayed);
    }

    @Step("Otwieram podstronę Opisy Konsol w nowej karcie (CTRL + click)")
    public void opisyKonsolIcon() {
        actions.keyDown(Keys.CONTROL).click(opisyKonsol).keyUp(Keys.CONTROL).build().perform();
    }

    @Step("Otwieram podstronę Galerie Konsol w nowej karcie (CTRL + click)")
    public void galerieKonsol() {
        actions.keyDown(Keys.CONTROL).click(galerieKonsol).keyUp(Keys.CONTROL).build().perform();
    }

    @Step("Otwieram Opisy Konsol w nowej karcie i przełączam się na nią")
    public ConsolePage otworzOpisyKonsol() {
        String href = opisyKonsol.findElement(By.tagName("a")).getAttribute("href");
        driver.switchTo().newWindow(WindowType.TAB).get(href);
        return new ConsolePage(driver);
    }

    @Step("Otwieram Galerie Konsol w nowej karcie i przełączam się na nią")
    public ConsolePage otworzGalerieKonsol() {
        String href = galerieKonsol.findElement(By.tagName("a")).getAttribute("href");
        driver.switchTo().newWindow(WindowType.TAB).get(href);
        return new ConsolePage(driver);
    }

    @Step("Otwieram Akcesoria w nowym oknie i przełączam kontekst")
    public AccessoriesPage otworzAkcesoria() {
        String href = akcesoria.findElement(By.tagName("a")).getAttribute("href");
        driver.switchTo().newWindow(WindowType.WINDOW).get(href);

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        return new AccessoriesPage(driver);
    }

    @Step("Klikam w ikonę Artykuły")
    public void articlesIcon() {
        artykuly.click();
    }

    @Step("Klikam w ikonę Wiadomości")
    public void wiadomosciIcon() {
        wiadomosci.click();
    }

    @Step("Klikam w podstronę O stronie")
    public void oStronieIcon() {
        o_stronie.click();
    }

    @Step("Klikam w podstronę Historia")
    public void historiaIcon() {
        historia.click();
    }

    @Step("Klikam w podstronę Skarbonka")
    public void skarbonkaIcon() {
        skarbonka.click();
    }

    @Step("Klikam w ikonę wyszukiwania")
    public void searchIcon() {
        search.click();
    }

    @Step("Wpisuję frazę w wyszukiwarkę: '{text}'")
    public void fillSearchText(String text) {
        searchText.sendKeys(text);
    }

    @Step("Zatwierdzam wyszukiwanie przyciskiem ENTER")
    public void searchValue() {
        searchText.sendKeys(Keys.ENTER);
    }
}