package pl.testeroprogramownia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PiggyBankPage {

    private WebDriver driver;

    // Łapiemy jeden element <strong>, bo Selenium zamienia <br> na \n
    @FindBy(xpath = "//h6[@class='wp-block-heading'][2]")
    private WebElement donatorsStrong;

    public PiggyBankPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Zwraca wszystkie loginy jako listę Stringów.
     * Selenium zamienia <br> na \n, więc rozdzielamy tekst po \n.
     */
    public List<String> getAllLogins() {
        String allText = donatorsStrong.getText();
        return Arrays.stream(allText.split("\\n"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    /**
     * Sprawdza obecność loginu - klasyczna pętla for
     */
    public boolean isLoginPresentForLoop(String login) {
        for (String l : getAllLogins()) {
            if (l.equalsIgnoreCase(login)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sprawdza obecność loginu - Stream + Lambda
     */
    public boolean isLoginPresentStream(String login) {
        return getAllLogins().stream()
                .anyMatch(l -> l.equalsIgnoreCase(login));
    }

    /**
     * Zwraca liczbę wszystkich donatorów
     */
    public int getDonatorsCount() {
        return getAllLogins().size();
    }

    /**
     * Sprawdza obecność wielu loginów naraz
     */
    public boolean areAllLoginsPresent(List<String> logins) {
        List<String> allLogins = getAllLogins();
        return logins.stream()
                .allMatch(login -> allLogins.stream()
                        .anyMatch(l -> l.equalsIgnoreCase(login)));
    }
}
