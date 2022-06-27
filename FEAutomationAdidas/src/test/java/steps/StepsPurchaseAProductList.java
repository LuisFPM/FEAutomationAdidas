package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.HelperStepDefinitions;

public class StepsPurchaseAProductList {
	WebDriver driver;

	// Feature PurchaseAProductList

	@Given("The user is the cart page after adding some items to the cart in the web application")
	public void the_user_is_the_cart_page_after_adding_some_items_to_the_cart_in_the_web_application() {
		HelperStepDefinitions.addItemToCartAndConfirm("Sony vaio i5");
		
		HelperStepDefinitions.pageItemNavigateToCart();
		HelperStepDefinitions.logInfo("Navigating to Cart");
	}

	@When("The user clicks the Place Order button")
	public void the_user_clicks_the_place_order_button() {
		HelperStepDefinitions.pageCartPlaceOrder();
		HelperStepDefinitions.logInfo("Placing Order");
	}

	@Then("A form pop up shows up")
	public void a_form_pop_up_shows_up() {
		HelperStepDefinitions.pageCartAssertPurchaseForm();
		HelperStepDefinitions.logInfo("Purchase form opened");
	}

	@Given("the user has placed an order in the web application")
	public void the_user_has_placed_an_order_in_the_web_application() {
		HelperStepDefinitions.addItemToCartAndConfirm("Sony vaio i5");
		
		HelperStepDefinitions.pageItemNavigateToCart();
		HelperStepDefinitions.logInfo("Navigating to Cart");

		HelperStepDefinitions.pageCartPlaceOrder();
		HelperStepDefinitions.logInfo("Placing Order");

		HelperStepDefinitions.pageCartAssertPurchaseForm();
		HelperStepDefinitions.logInfo("Purchase form opened");
	}

	@When("The user fills in the user information {string} {string} {string} {string} {string} {string}")
	public void the_user_fills_in_the_user_information(String string, String string2, String string3, String string4,
			String string5, String string6) {
		HelperStepDefinitions.pageCartFillPurchaseForm(string, string2, string3, string4, string5, string6);
		HelperStepDefinitions.logInfo("Purchase form filled");

	}


	@Then("A confirmation pop up shows up.")
	public void a_confirmation_pop_up_shows_up() {
		HelperStepDefinitions.pageCartAssertPurchasePlaced();
		HelperStepDefinitions.logInfo("Purchase confirmation popup opened");

	}

	@Given("the user has filled the purchase form with the user information  the user information {string} {string} {string} {string} {string} {string}")
	public void the_user_has_filled_the_purchase_form_with_the_user_information_the_user_information(String string,
			String string2, String string3, String string4, String string5, String string6) {

		HelperStepDefinitions.addItemToCartAndConfirm("Sony vaio i5");
		
		HelperStepDefinitions.pageItemNavigateToCart();
		HelperStepDefinitions.logInfo("Navigating to Cart");

		HelperStepDefinitions.pageCartPlaceOrder();
		HelperStepDefinitions.logInfo("Placing Order");

		HelperStepDefinitions.pageCartAssertPurchaseForm();
		HelperStepDefinitions.logInfo("Purchase form opened");

		HelperStepDefinitions.pageCartFillPurchaseForm(string, string2, string3, string4, string5, string6);
		HelperStepDefinitions.logInfo("Purchase form filled");
		
}

	@When("The user clicks the OK button")
	public void the_user_clicks_the_ok_button() {
		
		HelperStepDefinitions.pageCartAssertPurchasePlaced();
		String purchaseID =HelperStepDefinitions.recoverPurchaseID();
		String amountPaid =HelperStepDefinitions.recoverAmountPaid();
		HelperStepDefinitions.logInfo("Purchase ID is: "+purchaseID.trim());
		HelperStepDefinitions.logInfo("Total Amount paid is: "+amountPaid.trim());
	}


	@When("clicks the Purchase button")
	public void clicks_the_purchase_button() {
		HelperStepDefinitions.pageCartPlacePurchase();
		HelperStepDefinitions.logInfo("Confirming purchase");
	}
	
	@Then("The user returns to the Home Page")
	public void the_user_returns_to_the_home_page() {
		HelperStepDefinitions.pageIndexAssertHome();
		HelperStepDefinitions.logInfo("Returned to home page");
	}

	@When("The user fills in the user information wrong {string} {string} {string} {string} {string} {string}")
	public void the_user_fills_in_the_user_information_wrong(String string, String string2, String string3,
			String string4, String string5, String string6) {
		HelperStepDefinitions.pageCartFillPurchaseForm(string, string2, string3, string4, string5, string6);
		HelperStepDefinitions.logInfo("Purchase form filled");

	}

	@Then("A error message shows up in the form.")
	public void a_error_message_shows_up_in_the_form() {
		HelperStepDefinitions. assertErrorFillingForm();
		
	}

}
