package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.HelperStepDefinitions;

public class PageIndex {

	private WebDriver driver;
	private By txt_categoryPhones;
	private By txt_categoryLaptops;
	private By txt_categoryMonitors;
	private String path;
	private By assert_testPhone;
	private By assert_testLaptop;
	private By assert_testMonitor;
	private WebDriverWait wait;

	public PageIndex(WebDriver driver) {

		this.driver = driver;

		this.assert_testLaptop = By.xpath("//a[normalize-space()='Sony vaio i7']");
		this.assert_testMonitor = By.xpath("//a[normalize-space()='ASUS Full HD']");
		this.assert_testPhone = By.xpath("//a[text()='Nokia lumia 1520']");
		this.txt_categoryLaptops = By.xpath("//a[contains(text(),'Laptops')]");
		this.txt_categoryMonitors = By.xpath("//a[contains(text(),'Monitors')]");
		this.txt_categoryPhones = By.xpath("//a[contains(text(),'Phones')]");

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		AssertHome();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'CATEGORIES')]")));
	}

	// Navigate into an specific item category

	public void NavigationToCategorySelection(String categor) {
		switch (categor) {
		case "Phones":
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Phones')]"))));
			driver.findElement(txt_categoryPhones).click();
			break;
		case "Laptops":
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Laptops')]"))));
			driver.findElement(txt_categoryLaptops).click();
			break;
		case "Monitors":
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Monitors')]"))));
			driver.findElement(txt_categoryMonitors).click();
			break;
		default:
			driver.get("https://www.demoblaze.com/index.html");
			break;
		}
		AssertCategory(categor);
	}

	// Navigate to an specific item page

	public PageItem NavigateToItem(String item) {
//		this.path = "(//a[normalize-space()='"+item+"'])[1]";
		this.path = "//*[normalize-space(text())='" + item + "']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		driver.findElement(By.xpath(path)).click();
		PageItem pageItem = new PageItem(driver, item);
		return pageItem;
	}

	// Navigate to home page

	public void NavigateToHome() {
		this.path = "//li[@class='nav-item active']//a[@class='nav-link']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		driver.findElement(By.xpath(path)).click();

	}

	// Assert that there are items from multiple categories

	public void AssertHome() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(assert_testPhone));

		// Try out the asserts, catch the error if any, and execute the asserts again so scenary fails
		try {
			assertNotNull(driver.findElement(By.xpath("//a[contains(text(),'CATEGORIES')]")));
			assertTrue(driver.getCurrentUrl().contains("https://www.demoblaze.com/index.html"));

		} catch (AssertionError e) {
			HelperStepDefinitions.logError("Assertion error", e);
			assertNotNull(driver.findElement(By.xpath("//a[contains(text(),'CATEGORIES')]")));
			assertTrue(driver.getCurrentUrl().contains("https://www.demoblaze.com/index.html"));

		}
	}

	// Assert that there are only items from Phone category

	public void AssertCategory(String category) {
		switch (category) {
		case "Phones":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(assert_testLaptop));
			
			try {
				assertEquals(driver.findElements(assert_testLaptop).size(), 0);
				assertEquals(driver.findElements(assert_testMonitor).size(), 0);
				assertEquals(driver.findElements(assert_testPhone).size(), 1);

			} catch (AssertionError e) {
				HelperStepDefinitions.logError("Assertion error", e);
				assertEquals(driver.findElements(assert_testLaptop).size(), 0);
				assertEquals(driver.findElements(assert_testMonitor).size(), 0);
				assertEquals(driver.findElements(assert_testPhone).size(), 1);
			}
			break;
		case "Laptops":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(assert_testPhone));
			try {
				assertEquals(driver.findElements(assert_testLaptop).size(), 1);
				assertEquals(driver.findElements(assert_testPhone).size(), 0);
				assertEquals(driver.findElements(assert_testMonitor).size(), 0);

			} catch (AssertionError e) {
				HelperStepDefinitions.logError("Assertion error", e);
				assertEquals(driver.findElements(assert_testLaptop).size(), 1);
				assertEquals(driver.findElements(assert_testPhone).size(), 0);
				assertEquals(driver.findElements(assert_testMonitor).size(), 0);

			}

			break;
		case "Monitors":
			wait.until(ExpectedConditions.visibilityOfElementLocated(assert_testMonitor));

			try {
				assertEquals(driver.findElements(assert_testLaptop).size(), 0);
				assertEquals(driver.findElements(assert_testPhone).size(), 0);
				assertEquals(driver.findElements(assert_testMonitor).size(), 1);

			} catch (AssertionError e) {
				HelperStepDefinitions.logError("Assertion error", e);
				assertEquals(driver.findElements(assert_testLaptop).size(), 0);
				assertEquals(driver.findElements(assert_testPhone).size(), 0);
				assertEquals(driver.findElements(assert_testMonitor).size(), 1);
			}
			break;
		default:
			break;

		}

	}

}
