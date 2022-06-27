package steps;

import io.cucumber.java.en.*;
import util.HelperStepDefinitions;

public class StepsCategoryNav {

	// Feature : Category Nav

	@Given("The user is in the web application")
	public void the_user_is_in_the_web_application() {
		HelperStepDefinitions.pageIndexAssertHome();
		HelperStepDefinitions.logInfo("Automated driver is in Homepage");
	}

	@When("The user clicks {string} category")
	public void the_user_clicks_element_category(String category) {
		HelperStepDefinitions.logInfo("Accesing " + category + " category");
		HelperStepDefinitions.pageIndexClickCategory(category);

	}

	@Then("The user only visualize objects from the {string} category")
	public void the_user_only_visualize_objects_from_the_element_category(String category) {
		HelperStepDefinitions.pageIndexAssertCategory(category);
		HelperStepDefinitions.logInfo("Visualizing only " + category + " elements");
	}

}
