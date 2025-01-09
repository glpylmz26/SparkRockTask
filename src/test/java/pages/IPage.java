package pages;

import org.openqa.selenium.WebElement;

public interface IPage {
    WebElement getSelector(String ...elementInformation);
}
