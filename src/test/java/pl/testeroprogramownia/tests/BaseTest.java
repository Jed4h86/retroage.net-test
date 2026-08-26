package pl.testeroprogramownia.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.testeroprogramownia.pages.HomePage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod(alwaysRun = true) // <--- Dodano alwaysRun = true
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        if (isHeadless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        if (!isHeadless) {
            driver.manage().window().maximize();
        }

        driver.get("https://retroage.net/");

        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true) // <--- Dodano alwaysRun = true
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}