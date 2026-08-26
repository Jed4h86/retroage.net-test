package pl.testeroprogramownia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GalleryPage {

    private WebDriver driver;

    // 🔹 Elementy strony
    @FindBy(xpath = "//div[@id='pt-cv-view-7c0fdafzm6']//div[contains(@class,'pt-cv-content-item')]")
    private List<WebElement> galleryConsoles;

    @FindBy(xpath = "//span[contains(text(),'Galeria, Konsola')]")
    private WebElement galleryHeader;

    @FindBy(xpath = "//div[@data-pid='microsoft-g_kon']")
    private WebElement microsoft;

    @FindBy(xpath = "//div[@id='pt-cv-view-7c0fdafzm6']//div[contains(@class,'pt-cv-content-item')]")
    private List<WebElement> microsoftGallery;

    @FindBy(xpath = "//div[@data-pid='xbx-microsoft-g_kon']")
    private WebElement xbox;

    @FindBy(xpath = "//div[@id='pt-cv-view-41301e9w0i']//div[contains(@class,'pt-cv-content-item')]")
    private List<WebElement> microsoftList;

    @FindBy(xpath = "//img[@alt='Nintendo']")
    private WebElement nintendo;

    @FindBy(xpath = "//div[@class='pt-cv-view pt-cv-grid pt-cv-colsys pt-cv-show-taxonomy']//div[contains(@class,'pt-cv-content-item')]")
    private List<WebElement> nintendoList;


    // 🔹 Konstruktor
    public GalleryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 🔹 Metody

    public boolean allGalleryListCheck() {
        return !galleryConsoles.isEmpty() && galleryConsoles.stream().allMatch(WebElement::isDisplayed);
    }

    public String headerName() {
        return galleryHeader.getText().trim();
    }

    public void clickMicrosoft() {
        microsoft.click();
    }

    public boolean allMicrosoftGalleryListCheck() {
        return !microsoftGallery.isEmpty() && microsoftGallery.stream().allMatch(WebElement::isDisplayed);
    }

    public void clickXbox() {
        xbox.click();
    }

    public int getXboxGalleryCount() {
        return microsoftList.size();
    }

    public void clickNintendo() {
        nintendo.click();
    }

    public int getNintendoGalleryCount() {
        return nintendoList.size();
    }
}
