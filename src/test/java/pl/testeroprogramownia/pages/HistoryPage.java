package pl.testeroprogramownia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.testeroprogramownia.utils.SeleniumHelper;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

import static pl.testeroprogramownia.utils.SeleniumHelper.waitForElementsToBeVisible;

public class HistoryPage {
    private WebDriver driver;

    public HistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[contains(@class,'ngg-gallery-thumbnail-box')]")
    private List<WebElement> pictures;

    @FindBy(xpath = "//img[@title='nw_1']")
    private WebElement firstPicture;


    public boolean picturesList() {
        // ⏳ Czekamy aż lista nie będzie pusta i elementy będą widoczne
        waitForElementsToBeVisible(driver, pictures);
        SeleniumHelper.scrollToBottom(driver);
        if (pictures.isEmpty()) {
            System.out.println("⚠ Brak obrazków na stronie.");
            return false;
        }

        // ✅ Sprawdzamy, czy wszystkie są widoczne
        boolean allVisible = pictures.stream().allMatch(WebElement::isDisplayed);
        System.out.println("📸 Liczba znalezionych obrazków: " + pictures.size());
        return allVisible;
    }

    public void checkPictures() {
        SeleniumHelper.scrollToElement(driver, firstPicture);
        firstPicture.click();
    }

    //klikaj strzalke az przeklikasz do ostaniego elementu listy
    public void clickThroughAllPictures() {
        boolean hasNext = true;

        while (hasNext) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement next = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@id='nextpic']")
                ));
                next.click();
                System.out.println("➡ Kliknięto przycisk NEXT");

            } catch (Exception e) {
                System.out.println("🚪 Nie znaleziono przycisku NEXT — koniec galerii");
                hasNext = false;
            }
        }
    }
    public boolean isNextButtonPresent() {
        return !driver.findElements(By.xpath("//a[@id='nextpic']")).isEmpty();
    }
}


