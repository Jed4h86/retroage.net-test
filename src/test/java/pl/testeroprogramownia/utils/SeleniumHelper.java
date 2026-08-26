package pl.testeroprogramownia.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumHelper {

    private static final int TIMEOUT = 10;

    /**
     * Czeka, aż element będzie obecny w DOM (nawet jeśli niewidoczny).
     */
    public static void waitForElementToExist(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Czeka, aż element będzie widoczny (WebElement).
     */
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Czeka, aż element będzie widoczny (By).
     */
    public static void waitForElementToBeVisible(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Czeka, aż element będzie klikalny (WebElement).
     */
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Czeka, aż element będzie klikalny (By).
     */
    public static void waitForElementToBeClickable(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Czeka, aż lista elementów nie będzie pusta.
     */
    public static void waitForNotEmptyList(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(browser -> browser.findElements(locator).size() > 0);
    }

    /**
     * Czeka, aż wszystkie elementy z listy będą widoczne.
     */
    public static void waitForElementsToBeVisible(WebDriver driver, List<WebElement> elements) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
