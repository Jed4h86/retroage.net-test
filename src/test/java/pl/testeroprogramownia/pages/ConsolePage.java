package pl.testeroprogramownia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ConsolePage {

    private WebDriver driver;

    // 🔹 Lista wszystkich konsol
    @FindBy(xpath = "//div[@id='pt-cv-view-7c0fdafzm6']//div[contains(@class,'pt-cv-content-item')]")
    private List<WebElement> consoleList;

    // 🔹 Konsola Nintendo
    @FindBy(xpath = "//div[@data-pid='nintendo-konsola']")
    private WebElement nintendo;

    // 🔹 Tekst nagłówka / tytułu konsoli Nintendo
    @FindBy(xpath = "//span[contains(text(),'Nintendo')]")
    private WebElement nintendoText;

    // 🔹 Konstruktor
    public ConsolePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Pobiera wszystkie konsole z listy.
     * @return lista nazw konsol jako String
     */
    public List<String> getAllConsoles() {
        return consoleList.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    /**
     * Sprawdza, czy dana konsola znajduje się na liście.
     * @param console nazwa konsoli, np. "Nintendo"
     * @return true jeśli znajduje się na liście
     */
    public boolean isConsolePresented(String console) {
        return getAllConsoles().stream()
                .anyMatch(name -> name.equalsIgnoreCase(console));
    }

    /**
     * Kliknięcie w konsolę Nintendo.
     */
    public void nintendoConsole() {
        nintendo.click();
    }

    /**
     * Zwraca tekst nagłówka / tytułu konsoli Nintendo.
     */
    public String nintendoName() {
        return nintendoText.getText().trim();
    }
}
