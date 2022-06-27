package steps;

import io.cucumber.java.en.*;
import util.HelperStepDefinitions;

public class StepsVisualizeItemInformation {
	// Feature Visualize Item Info

	@Given("The user is in the Laptop Category of the web application")
	public void the_user_is_in_the_laptop_category_of_the_web_application() {
		HelperStepDefinitions.pageIndexAssertHome();
		HelperStepDefinitions.logInfo("Automated driver is in Homepage");

		HelperStepDefinitions.logInfo("Accesing "+"Laptops"+" category");
		HelperStepDefinitions.pageIndexClickCategory("Laptops");

		HelperStepDefinitions.pageIndexAssertCategory("Laptops");
		HelperStepDefinitions.logInfo("Visualizing only "+"Laptops"+" elements");
	
	}

	@When("The user clicks {string} item")
	public void the_user_clicks_element_item(String element) {
		HelperStepDefinitions.pageIndexNavigateToItem(element);
		HelperStepDefinitions.logInfo("Accesing "+"Laptops"+" category");
		
	}

	@Then("The user navigates to that {string} specific page")
	public void the_user_navigates_to_that_element_specific_page(String element) {
		HelperStepDefinitions.pageItemAssertItem(element);
		HelperStepDefinitions.logInfo("Automated driver is in "+element+" page");
		
	}
}
