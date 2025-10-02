package pl.testeroprogramownia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GalleryPage {
    private WebDriver driver;


        @FindBy(xpath = "//div[@id='pt-cv-view-7c0fdafzm6']")
        private List<WebElement>galleryConsoles;

    @FindBy(xpath = "//span[contains(text(),'Galeria, Konsola')]")
    private WebElement galleryHeader;

    @FindBy(xpath="//div[@data-pid='microsoft-g_kon']")
    private WebElement microsoft;

    public GalleryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public boolean allGalleryListCheck() {
        return !galleryConsoles.isEmpty() && galleryConsoles.stream().allMatch(WebElement::isDisplayed);

    }

    public String headerName() {
        return galleryHeader.getText();
    }
    public void microsoftClick(){
        microsoft.click();


//        public List<String> getGallery () {
//            String allText = galleryConsoles.getText();
//            return Arrays.stream(allText.split("\\n")).map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());

        }

    }

