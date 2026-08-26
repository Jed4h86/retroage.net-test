package pl.testeroprogramownia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ArticlesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//li[@id='menu-item-2176']")
    private WebElement artykuly;

    @FindBy(xpath = "//div[@id='pt-cv-view-4ca2d12ai2']")
    private List<WebElement> articlesList;

    @FindBy(xpath = "//h1[@class='entry-title']")
    private WebElement title;

    @FindBy(xpath = "//a[@title='Go to next page']")
    private List<WebElement> nextPage;

    @FindBy(xpath= "//div[@data-sid='4ca2d12ai2'][1]")
    private List<WebElement> categories;

    @FindBy(xpath = "//select[@name='_orderby']")
    private WebElement sortingList;

    public ArticlesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Sprawdzenie czy lista artykułów jest widoczna
    public boolean allArticlesListCheck() {
        return !articlesList.isEmpty() && articlesList.stream().allMatch(WebElement::isDisplayed);
    }

    // Kliknięcie w kategorię po nazwie
    public void clickCategoryByName(String categoryName) {
        WebElement category = driver.findElement(
                By.xpath("//div[normalize-space(text())='" + categoryName + "']")
        );
        category.click();
    }

    // Pobranie liczby artykułów w aktualnie wybranej kategorii
    public int getArticlesCount() {
        return articlesList.size();
    }

    // Szukanie artykułu po tytule (przewijanie po stronach)
    public void searchArticleByTitle(String articleTitle) {
        boolean found = false;

        while (!found) {
            List<WebElement> foundElements = driver.findElements(
                    By.xpath("//a[contains(text(),'" + articleTitle + "')]")
            );

            if (!foundElements.isEmpty()) {
                foundElements.get(0).click();
                found = true;
            } else {
                if (nextPage.isEmpty()) {
                    System.out.println("Nie znaleziono artykułu: " + articleTitle);
                    break;
                } else {
                    nextPage.get(0).click();
                }
            }
        }
    }

    // Sortowanie po tytule malejąco
    public void sortByTitleDesc() {
        sortingList.click();
        WebElement sortingDesc = driver.findElement(By.xpath("//option[@value='title,desc']"));
        sortingDesc.click();
    }

    // Sortowanie po dacie (najnowsze)
    public void sortByDateAsc() {
        Select dropdown = new Select(sortingList);
        dropdown.selectByVisibleText("Data (Najnowsze)");
    }

    // Pobranie listy tytułów artykułów
    public List<String> getArticleTitles() {
        return articlesList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    // Sprawdzenie, czy kategorie są widoczne
    public boolean categoriesAreVisible() {
        return !categories.isEmpty() && categories.stream().allMatch(WebElement::isDisplayed);
    }

    // Pobranie tekstu kategorii po nazwie
    public String getCategoryText(String categoryName) {
        WebElement category = driver.findElement(
                By.xpath("//div[normalize-space(text())='" + categoryName + "']")
        );
        return category.getText();
    }

    // Pobranie tytułu aktualnie otwartego artykułu
    public String getTitle() {
        return title.getText();
    }
}
