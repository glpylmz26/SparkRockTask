package step_defs.actionStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.sparkrock.utils.Driver;
import pages.BasePage;
import pages.IPage;
import testUtils.TestUtils;

import static pages.BasePage.getThePageUrl;


public class ActionSteps {
    @Given("I have navigated to the {string} URL")
    public void i_have_navigated_to_the_url(String pageName) throws InterruptedException {
        String pageUrl = getThePageUrl(pageName); Driver.getDriver().get(pageUrl); Thread.sleep(2000);
    }

    @When("I set the {string} to {string}")
    public void i_set_the_to(String elementName, String value) {
        String pageName = BasePage.getPageNameFromCurrentUrl(); IPage currentPage = BasePage.getPage(pageName);
        TestUtils.setElementValue(currentPage, currentPage.getSelector(elementName), value, elementName);
    }

    @When("I click the {string}")
    public void i_click_the(String elementName) {
        String pageName = BasePage.getPageNameFromCurrentUrl();
        IPage currentPage = BasePage.getPage(pageName);
        TestUtils.click(currentPage, currentPage.getSelector(elementName), elementName);
    }
    @When("I refresh the page")
    public void i_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
    }

}
