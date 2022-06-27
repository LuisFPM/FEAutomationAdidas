package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.HelperStepDefinitions;

public class StepsCommon {

	@Before
	public void setUp() {
		HelperStepDefinitions.logInfo("-------------------");
		HelperStepDefinitions.logInfo("Automated Scenary Start up");
		HelperStepDefinitions.setUp();
		HelperStepDefinitions.logInfo("WebDriver initialized");
	}

	@After
	public void closeUp() {
		HelperStepDefinitions.setDown();
		HelperStepDefinitions.logInfo("WebDriver closed");
		HelperStepDefinitions.logInfo("Automated Scenary Finished");
		HelperStepDefinitions.logInfo("-------------------\n\n");

	}

	
}
