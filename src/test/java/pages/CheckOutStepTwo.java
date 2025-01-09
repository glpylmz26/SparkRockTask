package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sparkrock.utils.Driver;

public class CheckOutStepTwo extends BasePage implements IPage {


    public WebElement getSelector(String... elementInformation) {
//        elementName = elementInformation[0];
//        elementIdentifier = elementInformation[1];
//        elementIdentifierValue = elementInformation[2];

        return switch (elementInformation[0]) {
            case "Finish Button" -> {
                yield Driver.getDriver().findElement(By.id("finish"));
            }

            default -> {
                System.out.println(elementInformation[0] + " could not be found in " + this.getClass().getSimpleName()); yield null;
            }
        };
    }

}
