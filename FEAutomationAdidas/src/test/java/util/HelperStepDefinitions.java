package util;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

import pages.PageCart;
import pages.PageIndex;
import pages.PageItem;

public class HelperStepDefinitions {
	static WebDriver driver;
	static PageIndex pageIndex;
	static PageItem pageItem;
	static PageCart pageCart;
	private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(HelperStepDefinitions.class);
	static String url = "https://www.demoblaze.com/index.html";

	public static void logInfo(String s) {
		LOG.info(s);

	}

	public static void logError(String s, Throwable e) {
		LOG.error(s,e);

	}

	public static void setUp() {
		driver = util.Utilities.startDriver("Chrome");
		driver.get(url);
		pageIndex = new PageIndex(driver);

	}

	public static void pageIndexAssertHome() {
		pageIndex.AssertHome();
	}

	public static void pageIndexClickCategory(String category) {
		pageIndex.NavigationToCategorySelection(category);
	}

	public static void pageIndexAssertCategory(String category) {
		pageIndex.AssertCategory(category);
	}

	public static void setDown() {
		util.Utilities.closeDriver(driver);
	}
	
	public static void pageIndexNavigateToItem(String element) {
		pageItem = pageIndex.NavigateToItem(element);
	}
	
	public static void pageItemAssertItem(String element) {
		pageItem.AssertPageItem(element);
	}
	
	public static void pageItemAddToCart() {
		pageItem.addToCart();
	}
	
	public static void pageItemAcceptConfirmationPopUp() {
		pageItem.acceptConfirmationPopUp();
	}
	public static void pageItemNavigateToCart() {
		pageCart = pageItem.NavigateToCart(driver);
	}
	
	
	public static void pageCartAssertingPageCart() {
		pageCart.assertPageCart();
	}
	
	public static void navigateHome() {
		pageIndex.NavigateToHome();
	}

	public static void pageCartDeleteItem(String item) {
		pageCart.deleteItem(item);
	}
	

	public static void pageCartAssertItemDeletion(String item) {
		pageCart.assertDeletion(item);
	}
	

	public static void pageCartFillPurchaseForm(String name, String country, String city, String creditCard, String month, String year) {
		pageCart.fillPurchaseForm(name, country, city, creditCard, month, year);
	}

	
	public static String recoverPurchaseID() {
		return pageCart.recoverID();
	}

	public static String recoverAmountPaid() {
		return pageCart.recoverAmount();
	}
	
	public static void assertErrorFillingForm() {
		pageCart.assertErrorFillingForm();
	}
	
	public static void pageCartPlaceOrder() {
		pageCart.placeOrder();
	}
	
	public static void pageCartAssertPurchaseForm() {
		pageCart.assertPurchaseForm();
	}
	
	public static void pageCartPlacePurchase() {
		pageCart.clickConfirmForm();
	}
	
	public static void pageCartAssertPurchasePlaced() {
		pageCart.assertOrderPlaced();
		pageCart.confirmPurchase();
	}
	
	public static void goToLaptopItemPage(String item) {
		pageIndexAssertHome();
		logInfo("Automated driver is in Homepage");

		logInfo("Accesing "+"Laptops"+" category");
		pageIndexClickCategory("Laptops");

		pageIndexAssertCategory("Laptops");
		logInfo("Visualizing only "+"Laptops"+" elements");

		pageIndexNavigateToItem(item);
		HelperStepDefinitions.logInfo("Accesing "+"Laptops"+" category");
		
		pageItemAssertItem(item);
		logInfo("Automated driver is in "+item+" page");
	}
	
	
	public static void addItemToCartAndConfirm(String item) {
		goToLaptopItemPage(item);
		
		pageItemAddToCart();
		logInfo("Adding item to cart");
		
		pageItemAcceptConfirmationPopUp();
		logInfo("Accepting confirmation");
		
	}
	

}
