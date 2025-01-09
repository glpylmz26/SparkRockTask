package step_defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.sparkrock.utils.Driver;

import java.time.Duration;

public class Hooks {

    @Before
    public void setupTestData(Scenario scenario) {
        WebDriver driver = Driver.getDriver();
        if (driver.manage().window().getPosition().getX() == 0 && driver.manage().window().getPosition().getY() == 0) {
            // Window is already maximized, do nothing
        } else {
            driver.manage().window().maximize();
        } driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        } Driver.closeDriver();
    }
}
