package step_defs.assertStepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.sparkrock.utils.ConfigurationReader;
import pages.BasePage;
import pages.IPage;

import static testUtils.TestUtils.isElementState;

public class AssertionSteps {
    IPage currentPage;

    @Then("the {string} should be {string} in {int} seconds")
    public void the_should_be_in_seconds(String elementName, String state,int timeoutInSeconds) {
        String pageName = BasePage.getPageNameFromCurrentUrl();
        currentPage = BasePage.getPage(pageName);
        Assert.assertTrue(isElementState(currentPage,currentPage.getSelector(elementName),state,elementName,timeoutInSeconds));
    }
    @Then("the {string} should be {string}")
    public void the_should_be(String elementName, String state) {
        String pageName = BasePage.getPageNameFromCurrentUrl();
        currentPage = BasePage.getPage(pageName);
        Assert.assertTrue(isElementState(currentPage, currentPage.getSelector(elementName), state, elementName, Integer.parseInt(ConfigurationReader.get("defaultTimeOut"))));
    }

    @Then("the {string} is {string} where the {string} is {string}")
    public void the_is_where_the_is(String elementName, String state, String elementText, String elementTextValue) {
        String pageName = BasePage.getPageNameFromCurrentUrl();
        currentPage = BasePage.getPage(pageName);
        Assert.assertTrue(isElementState(currentPage, currentPage.getSelector(elementName,elementText,elementTextValue), state, elementName, Integer.parseInt(ConfigurationReader.get("defaultTimeOut"))));
    }

}
