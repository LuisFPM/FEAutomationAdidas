package pages;

import static org.junit.Assert.assertNotNull;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.HelperStepDefinitions;

public class PageItem {

	private WebDriver driver;
	private String item;
	private By button_AddToCart;
	private WebDriverWait wait;

	public PageItem(WebDriver driver, String item) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.driver = driver;
		this.item = item;
		this.button_AddToCart = By.xpath("//a[contains(text(),'Add to cart')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_AddToCart));

	}

	// Add current item to cart

	public void addToCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_AddToCart));
		driver.findElement(button_AddToCart).click();
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// Accept confirmation popUp
	public void acceptConfirmationPopUp() {
		driver.switchTo().alert().accept();

	}

	// Navigate to cart

	public PageCart NavigateToCart(WebDriver driver) {
		driver.findElement(By.xpath("//a[@id='cartur']")).click();
		PageCart pageCart = new PageCart(driver);
		try {
			pageCart.assertPageCart();
		} catch (AssertionError e) {
			HelperStepDefinitions.logError("Assertion error", e);
			pageCart.assertPageCart();
		}

		return pageCart;

	}

	// Assert this is the current item page

	public void AssertPageItem(String item) {

		String path = "//h2[contains(text(),'" + item + "')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		try {
			assertNotNull(driver.findElement(By.xpath(path)));
		} catch (AssertionError e) {
			HelperStepDefinitions.logError("Assertion error", e);
			assertNotNull(driver.findElement(By.xpath(path)));
		}
	}

}
