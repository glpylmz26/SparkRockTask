package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sparkrock.utils.Driver;

public class InventoryPage extends BasePage implements IPage {


    public WebElement getSelector(String... elementInformation) {
//        elementName = elementInformation[0];
//        elementIdentifier = elementInformation[1];
//        elementIdentifierValue = elementInformation[2];

        return switch (elementInformation[0]) {
            case "Products Header" -> {
                yield Driver.getDriver().findElement(By.xpath("//span[@data-test='title'][contains(.,'Products')]"));
            }
            case "Sauce Labs Backpack Add to Cart Button" -> {
                yield Driver.getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack"));
            }
            case "Shopping Cart Badge" -> {
                yield Driver.getDriver().findElement(By.cssSelector("[data-test='shopping-cart-badge']"));
            }
            case "Sauce Labs Bike Light Add to Cart Button" -> {
                yield Driver.getDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light"));
            }
            case "Shopping Cart Button" -> {
                yield Driver.getDriver().findElement(By.cssSelector("[data-test='shopping-cart-link']"));
            }
            default -> {
                System.out.println(elementInformation[0] + " could not be found in " + this.getClass().getSimpleName()); yield null;
            }
        };
    }

}
