package pl.testeroprogramownia.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage {

    @FindBy(xpath = ("//div[@class ='logo-wrapper ']//a[@class='custom-logo-link']"))
    private WebElement customLogo;

    @FindBy(xpath = "//a[@class='gum-slidein-menu-toggle top']//i[@class='fa fa-bars']")
    private WebElement menuBar;

    @FindBy(xpath = ("//li[@id ='menu-item-2203']//a[@href='https://pl-pl.facebook.com/pages/Retroagenet/159265417444224']"))
    private WebElement Facebook;

    @FindBy(xpath=("//*[@id='menu-item-2202']//a[@href='https://www.youtube.com/channel/UCxRRvixxr6Ib0kR0y41_KpQ/videos']"))
    private WebElement Youtube;

    @FindBy(xpath = ("//div[@class='toggle-menu-wrapper show-slidein']"))
    private List<WebElement> dropDownMenuList;

    @FindBy(xpath = ("//*[@id='menu-item-5']/a"))
    private WebElement Forum;


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
        public WebElement getCustomLogo() {
            return customLogo;

    }
    public boolean isLogoVisible(){
        Assert.assertTrue(customLogo.isDisplayed(),"Logo widoczne");
        return customLogo.isDisplayed();
    }
@Step("Sprawdzam, czy logo jest widoczne")
public void clickLogo() {
    customLogo.click();
}
public void clickMenuBar(){
    menuBar.click();
    //Facebook.click();
    Youtube.click();


}
public void assertDropdownMenuItemsVisible(){
        for (WebElement item: dropDownMenuList){
            Assert.assertTrue(item.isDisplayed(),"Element jest niewidoczny " + item.getText());
        }

}
public void forumIcon(){
        Forum.click();
}

}

