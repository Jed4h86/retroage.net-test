package pl.testeroprogramownia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsolePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='pt-cv-view-7c0fdafzm6']")
    private WebElement consoles;

    @FindBy(xpath = "//div[@data-pid='nintendo-konsola']")
    private WebElement nintendo;

    @FindBy(xpath = "//span[contains(text(),'Nintendo')]")
    private WebElement nintendoText;




    public ConsolePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public List<String> getAllConsoles() {
        String allText = consoles.getText();
        return Arrays.stream(allText.split("\\n")).map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }

    public boolean isConsolePresented(String console) {
        return getAllConsoles().stream()
                .anyMatch(l -> l.equalsIgnoreCase(console));
    }

    public void nintendoConsole() {
        nintendo.click();
    }

    public String nintendoName() {
        return nintendoText.getText();
    }



}
