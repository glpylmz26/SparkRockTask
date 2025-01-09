package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sparkrock.utils.Driver;

public class CheckOutStepOne extends BasePage implements IPage {


    public WebElement getSelector(String... elementInformation) {
//        elementName = elementInformation[0];
//        elementIdentifier = elementInformation[1];
//        elementIdentifierValue = elementInformation[2];

        return switch (elementInformation[0]) {
            case "First Name Field" -> {
                yield Driver.getDriver().findElement(By.id("first-name"));
            }
            case "Last Name Field" -> {
                yield Driver.getDriver().findElement(By.id("last-name"));
            }
            case "Zip/Postal Code Field" -> {
                yield Driver.getDriver().findElement(By.id("postal-code"));
            }
            case "Continue Button" -> {
                yield Driver.getDriver().findElement(By.id("continue"));
            }

            default -> {
                System.out.println(elementInformation[0] + " could not be found in " + this.getClass().getSimpleName()); yield null;
            }
        };
    }

}
