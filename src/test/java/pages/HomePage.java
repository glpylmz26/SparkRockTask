package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.sparkrock.utils.Driver;

public class HomePage extends BasePage implements IPage {

    /**
     * Returns a selector for an element which is local to the Home Page
     * //    * @param element User-friendly name of the element we would like to identify (e.g "Login Button")
     */
    public WebElement getSelector(String... elementInformation) {
//        elementName = elementInformation[0];
//        elementIdentifier = elementInformation[1];
//        elementIdentifierValue = elementInformation[2];

        return switch (elementInformation[0]) {
            case "Username Field" -> {
                yield Driver.getDriver().findElement(By.id("user-name"));
            } case "Password Field" -> {
                yield Driver.getDriver().findElement(By.id("password"));
            } case "Login Button" -> {
                yield Driver.getDriver().findElement(By.id("login-button"));
            } case "Swag Labs Logo" -> {
                yield Driver.getDriver().findElement(By.xpath("//*[contains(@class, 'logo')]"));
            } case "Error Message" -> {
                switch (elementInformation[1]) {
                    case "Error Message":
                        yield Driver.getDriver().findElement(By.xpath("//*[@data-test='error'][contains(.,'" + elementInformation[2] + "')]"));
                    default:
                        throw new NoSuchElementException("Element not found: " + elementInformation[0] + " for " + elementInformation[1] + " as " + elementInformation[2]);
                }
            }
            default -> {
                System.out.println(elementInformation[0] + " could not be found in " + this.getClass().getSimpleName()); yield null;
            }
        };
    }
}