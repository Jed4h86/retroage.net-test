package pl.testeroprogramownia.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccessoriesPage {
    private Actions actions;

    private WebDriver driver;

    @FindBy(xpath = "//li[@id='menu-item-22796']")
    private WebElement akcesoria;

    @FindBy(xpath = "//li[@id='menu-item-2175']")
    private WebElement opisy;

    @FindBy(xpath = "//li[@id='menu-item-22889']")
    private WebElement galerie;

    public AccessoriesPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
public void akcesoriaTab(){
    akcesoria.click();
}
    public void kliknijOpisy() {
        actions.keyDown(Keys.CONTROL).click(opisy).keyUp(Keys.CONTROL).build().perform();

    }
    public void kliknijGalerie(){
        actions.keyDown(Keys.CONTROL).click(galerie).keyUp(Keys.CONTROL).build().perform();
    }
//    public void switchToNextTab() {
//        String currentHandle = driver.getWindowHandle();
//        for (String handle : driver.getWindowHandles()) {
//            if (!handle.equals(currentHandle)) {
//                driver.switchTo().window(handle);
//                break;
//            }
        }



