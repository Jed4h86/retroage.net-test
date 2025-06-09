package pl.testeroprogramownia.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = ("//div[@class ='logo-wrapper ']//a[@class='custom-logo-link']"))
    private WebElement customLogo;

    @FindBy(xpath = "//a[@class='gum-slidein-menu-toggle top']//i[@class='fa fa-bars']")
    private WebElement menuBar;

    @FindBy(xpath = ("//li[@id ='menu-item-2203']//a[@href='https://pl-pl.facebook.com/pages/Retroagenet/159265417444224']"))
    private WebElement facebook;

    @FindBy(xpath = ("//*[@id='menu-item-2202']//a[@href='https://www.youtube.com/channel/UCxRRvixxr6Ib0kR0y41_KpQ/videos']"))
    private WebElement youtube;

    @FindBy(xpath = ("//div[@class='toggle-menu-wrapper show-slidein']"))
    private List<WebElement> dropDownMenuList;

    @FindBy(xpath = ("//*[@id='menu-item-5']/a"))
    private WebElement forum;

    @FindBy(xpath = ("//li[@id='menu-item-2174']"))
    private WebElement gry;

    @FindBy(xpath = ("//li[@id='menu-item-2178' or @id='menu-item-4330' or @id='menu-item-5765' or @id='menu-item-17796']"))
    private List<WebElement> listaGier;

    public List<WebElement> getListaGier() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//li[@id='menu-item-2178' or @id='menu-item-4330' or @id='menu-item-5765' or @id='menu-item-17796']")
        ));
        return listaGier;
    }




    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getCustomLogo() {
        return customLogo;

    }

    @Step("Sprawdzam, czy logo jest widoczne")
    public boolean isLogoVisible() {
        return customLogo.isDisplayed();
    }

    @Step("Klikam logo")
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

    public void GryIcon() {
        gry.click();

    }

    public boolean czyWszystkieElementyIstnieją() {
        return getListaGier().size() == 4;


    }
}


