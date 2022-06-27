package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utilities {
	
	public static WebDriver startDriver(String navegador) {

		WebDriver driver;
		switch (navegador) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", "src\\test\\resources\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		return driver;
	}

	public static void closeDriver(WebDriver driver) {
		driver.quit();
	}

}