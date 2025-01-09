package testUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sparkrock.utils.Driver;
import pages.IPage;

import java.time.Duration;


public class TestUtils {
    public static WebElement handlingStaleElement(IPage currentPage, String... elementInformation) {
        WaitForElements.waitFor(3);
        System.out.println("Handling Stale Element....");
        return currentPage.getSelector(elementInformation);
    }

    public static void click(IPage currentPage, WebElement element, String... elementInformation) {
        try {
            scrollToElement(element);
            WaitForElements.waitForWebElementToBeClickable(element);
            element.click();
        } catch (StaleElementReferenceException e) {
            element = handlingStaleElement(currentPage, elementInformation);
            scrollToElement(element);
            WaitForElements.waitForWebElementToBeClickable(element);
            element.click();
        }
    }


    public static void setElementValue(IPage currentPage, WebElement element, String value, String... elementInformation) {
        try {
            scrollToElement(element);
            WaitForElements.waitForElementToBeVisible(element);
            element.sendKeys(value);
        } catch (StaleElementReferenceException e) {
            element = handlingStaleElement(currentPage, elementInformation);
            scrollToElement(element);
            WaitForElements.waitForElementToBeVisible(element);
            element.sendKeys(value);
        }
    }

    public static String getText(WebElement element) {
        scrollToElement(element);
        WaitForElements.waitForElementToBeVisible(element);
        return element.getText();
    }

    public static String getValue(IPage currentPage, WebElement element, String searchParameter, String... elementInformation) {
        try {
            scrollToElement(element);
            WaitForElements.waitForElementToBeVisible(element);
            return element.getAttribute(searchParameter.toLowerCase());
        } catch (StaleElementReferenceException e) {
            element = handlingStaleElement(currentPage, elementInformation);
            scrollToElement(element);
            WaitForElements.waitForElementToBeVisible(element);
            return element.getAttribute(searchParameter.toLowerCase());
        }
    }

    public static void scrollToElement(WebElement currentElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", currentElement);
    }

    public static boolean isElementState(IPage currentPage, WebElement webElement, String state, String elementName, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutInSeconds));
            // Explicit Wait ile durum kontrolü
            WebElement finalWebElement = webElement;
            return wait.until(driver -> {
                switch (state.toLowerCase()) {
                    case "displayed":
                        return finalWebElement.isDisplayed();
                    case "not displayed":
                        return !finalWebElement.isDisplayed();
                    case "enabled":
                        return finalWebElement.isEnabled();
                    case "not enabled":
                        return !finalWebElement.isEnabled();
                    default:
                        throw new IllegalArgumentException(state + " is not a valid state for " + finalWebElement + ". Please check the state.");
                }
            });
        } catch (TimeoutException e) {
            throw new AssertionError("Element '" + elementName + "' did not reach the desired state '" + state + "' within " + timeoutInSeconds + " seconds.");
        } catch (StaleElementReferenceException e) {
            // Stale element durumu için yeniden deneme
            webElement = handlingStaleElement(currentPage, elementName);
            return isElementState(currentPage, webElement, state, elementName, timeoutInSeconds);
        }
    }
}
