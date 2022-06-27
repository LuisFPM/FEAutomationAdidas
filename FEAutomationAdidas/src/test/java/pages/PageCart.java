package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.HelperStepDefinitions;

public class PageCart {

	private WebDriver driver;
	private By field_Name;
	private By field_Country;
	private By field_CreditCard;
	private By field_City;
	private By field_Month;
	private By field_Year;
	private By button_PlaceOrder;
	private By button_Purchase;
	private By button_OK;
	private WebDriverWait wait;
	private By table_ShoppingList;

	private String txt_PageTotal;
	private String txt_PurchaseID;
	private String txt_PaidAmount;
	private Integer elementsInTable;

	public PageCart(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		this.button_PlaceOrder = By.xpath("//button[normalize-space()='Place Order']");
		this.button_Purchase = By.xpath("//button[normalize-space()='Purchase']");
		this.button_OK = By.xpath("//button[contains(text(),'OK')]");

		this.field_Name = By.xpath("//input[@id='name']");
		this.field_Country = By.xpath("//input[@id='country']");
		this.field_City = By.xpath("//input[@id='city']");
		this.field_CreditCard = By.xpath("//input[@id='card']");
		this.field_Month = By.xpath("//input[@id='year']");
		this.field_Year = By.xpath("//input[@id='month']");

		this.table_ShoppingList = By.tagName("table");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(button_PlaceOrder));

	}

	public void deleteItem(String item) {
		elementsInTable = driver.findElements(By.xpath("//tr")).size();
		String path = "//td[text()='" + item + "']/following-sibling::td[2]/a[text()='Delete']";
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(path)));
		driver.findElement(By.xpath(path)).click();

	}

	public void assertDeletion(String item) {
		if (elementsInTable > 1) {
			String path = "//a[normalize-space()='Delete']";
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(path)));
			try {
				assertNotEquals(driver.findElements(By.xpath(path)).size(), 0);
			} catch (AssertionError e) {
				HelperStepDefinitions.logError("Assertion error", e);
				assertNotEquals(driver.findElements(By.xpath(path)).size(), 0);
			}
		} else {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(button_PlaceOrder));
		}

	}

	public void placeOrder() {
		driver.findElement(button_PlaceOrder).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_Purchase));
	}

	public void assertPurchaseForm() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_Purchase));
		try {
			assertNotEquals(driver.findElements(button_Purchase), 0);
		} catch (AssertionError e) {
			HelperStepDefinitions.logError("Assertion error", e);
			assertNotEquals(driver.findElements(button_Purchase), 0);
		}
	}

	public void fillPurchaseForm(String name, String country, String city, String creditCard, String month,
			String year) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_Purchase));
		driver.findElement(field_Name).sendKeys(name);
		driver.findElement(field_Country).sendKeys(country);
		driver.findElement(field_City).sendKeys(city);
		driver.findElement(field_CreditCard).sendKeys(creditCard);
		driver.findElement(field_Month).sendKeys(month);
		driver.findElement(field_Year).sendKeys(year);

	}

	public void clickConfirmForm() {
		driver.findElement(button_Purchase).click();
	}

	public void confirmPurchase() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@id='totalp']")));
		this.txt_PageTotal = driver.findElement(By.xpath("//h3[@id='totalp']")).getText();

		String path = "//p[@class='lead text-muted ']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String InfoCompra = driver.findElement(By.xpath(path)).getText();
		recoverIDAndAmount(InfoCompra);
		driver.findElement(button_OK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Laptops')]")));
	}

	public void assertOrderPlaced() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_OK));
		try {
			assertNotEquals(driver.findElements(button_OK), 0);
		} catch (AssertionError e) {
			HelperStepDefinitions.logError("Assertion error", e);
			assertNotEquals(driver.findElements(button_OK), 0);
		}
	}

	public void assertAmountPaid() {
		try {
			assertEquals(txt_PaidAmount.trim(), txt_PageTotal.trim());
		} catch (AssertionError e) {
			HelperStepDefinitions.logError("Assertion error", e);
			assertEquals(txt_PaidAmount.trim(), txt_PageTotal.trim());
		}
	}

	private void recoverIDAndAmount(String info) {
		String[] data = info.split("Card");
		data = data[0].split("Amount: ");

		this.txt_PurchaseID = data[0].replace("Id: ", "").toString();
		this.txt_PaidAmount = data[1].replace(" USD", "").toString();

	}

	public String recoverID() {
		return this.txt_PurchaseID;
	}

	public String recoverAmount() {
		return this.txt_PaidAmount;
	}

	public boolean assertPageCart() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(table_ShoppingList)));
		return null != driver.findElement(table_ShoppingList);

	}

	public void assertErrorFillingForm() {
		try {
			driver.switchTo().alert().accept();
			HelperStepDefinitions.logInfo("Error found while filling the form");
		} catch (Exception exception) {
			try {
				assertTrue("Expected error that has not been found", false);
			} catch (AssertionError e) {
				HelperStepDefinitions.logError("Assertion error", e);
				assertTrue("Expected error that has not been found", false);
			}
		}

	}

}
