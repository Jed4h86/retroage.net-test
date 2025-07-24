package pl.testeroprogramownia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlesPage {
    private WebDriver driver;

    @FindBy(xpath = "//li[@id='menu-item-2176']")
    private WebElement artykuly;

    public ArticlesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
        public void articlesIcon () {
            artykuly.click();
        }

    }

