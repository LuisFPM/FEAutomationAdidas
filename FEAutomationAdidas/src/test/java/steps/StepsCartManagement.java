package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.HelperStepDefinitions;

public class StepsCartManagement {
	// Feature Cart Management

	@Given("The user is in the {string} page")
	public void the_user_is_in_the_element_page(String element) {
		HelperStepDefinitions.goToLaptopItemPage(element);
	}

	@When("The user clicks Add to Cart button")
	public void the_user_clicks_add_to_cart_button() {
		HelperStepDefinitions.pageItemAddToCart();
		HelperStepDefinitions.logInfo("Adding item to cart");

	}

	@Then("A confirmation pop up shows up for user to accept")
	public void a_confirmation_pop_up_shows_up_for_user_to_accept() {
		HelperStepDefinitions.pageItemAcceptConfirmationPopUp();
		HelperStepDefinitions.logInfo("Accepting confirmation");
	}

	@Given("The user has added an item to the cart in the web application")
	public void the_user_has_added_an_item_to_the_cart_in_the_web_application() {
		HelperStepDefinitions.addItemToCartAndConfirm("Dell i7 8gb");
	}

	@When("The user clicks the Cart button on the top of the page")
	public void the_user_clicks_the_cart_button_on_the_top_of_the_page() {
		HelperStepDefinitions.pageItemNavigateToCart();
		HelperStepDefinitions.logInfo("Accesing Cart page");
	}

	@Then("The user navigates to the List of items he previously added to the cart")
	public void the_user_navigates_to_the_list_of_items_he_previously_added_to_the_cart() {
		HelperStepDefinitions.pageCartAssertingPageCart();
	}

	@Given("The user is in the cart page after adding some items to the cart in the web application")
	public void the_user_is_in_the_cart_page_after_adding_some_items_to_the_cart_in_the_web_application() {
		
		HelperStepDefinitions.addItemToCartAndConfirm("Dell i7 8gb");

		HelperStepDefinitions.navigateHome();
		HelperStepDefinitions.logInfo("Returning Home");
		HelperStepDefinitions.pageIndexAssertHome();

		HelperStepDefinitions.addItemToCartAndConfirm("Sony vaio i5");

		HelperStepDefinitions.pageItemNavigateToCart();
		HelperStepDefinitions.logInfo("Navigating to Cart");

	}

	@When("The user clicks the Delete button in one item")
	public void the_user_clicks_the_delete_button_in_one_item() {
		HelperStepDefinitions.pageCartDeleteItem("Sony vaio i5");
		HelperStepDefinitions.logInfo("Deleting laptop");
	}

	@Then("The item is removed from the products lists")
	public void the_item_is_removed_from_the_products_lists() {
		HelperStepDefinitions.pageCartDeleteItem("Sony vaio i5");
		HelperStepDefinitions.logInfo("Asserting deletion");
	}

}
