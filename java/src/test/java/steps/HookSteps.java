package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import support.BaseSteps;

public class HookSteps extends BaseSteps {

    @After
    public void afterScenario() {
        driver.quit();
    }

    @Before
    public void beforeScenario() { }
}
