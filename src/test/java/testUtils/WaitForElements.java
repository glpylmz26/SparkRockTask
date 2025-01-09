package testUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sparkrock.utils.Driver;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WaitForElements {
    private static Duration timeout = Duration.ofSeconds(60);

    public static void waitUntilElementDisplayed(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Element is not displayed " + e.getMessage());
        }
    }

    public static void waitForWebElementToBeClickable(WebElement webElement) {
        new WebDriverWait(Driver.getDriver(), timeout)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static Boolean waitForTextTobePresentInWebElement(WebElement webElement, String text) {
        return new WebDriverWait(Driver.getDriver(), timeout)
                .until(textToBePresentInElement(webElement, text));
    }

    public static WebElement waitForElementToBeVisible(WebElement webElement) {
        return new WebDriverWait(Driver.getDriver(), timeout)
                .until(visibilityOf(webElement));
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
