package Utils;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base {

	public static WebDriver driver;
	public static ChromeOptions options;

	//Method for initiate driver 
	public static void driverInit(String environment) {
		System.setProperty("webdrive.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		driver = new ChromeDriver(ops);
		driver.get("https://paperlessinvoice-" + environment + ".heptagon.tech/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(title));
		Assert.assertEquals(title, "Paperless Invoicing");
	}

	//Method for chrome notification enable
	public static void chromeOption() throws InterruptedException {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
	}

	//Method for sendkeys
	public static void sendKeys(String locator, String element, String value) {
		try {
			Thread.sleep(1000);
			if (locator.equals("xpath")) {
				driver.findElement(By.xpath(element)).sendKeys(value);
			} else if (locator.equals("id")) {
				driver.findElement(By.id(element)).sendKeys(value);
			} else if (locator.equals("name")) {
				driver.findElement(By.name(element)).sendKeys(value);
			} else if (locator.equals("className")) {
				driver.findElement(By.className(element)).sendKeys(value);
			} else if (locator.equals("linkText")) {
				driver.findElement(By.linkText(element)).sendKeys(value);
			} else if (locator.equals("partialLinkText")) {
				driver.findElement(By.partialLinkText(element)).sendKeys(value);
			} else if (locator.equals("cssSelector")) {
				driver.findElement(By.cssSelector(element)).sendKeys(value);
			} else {
				System.out.println("no locator is identified");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method for wait
		public static void wait(int ele) throws InterruptedException {
			try {
				Thread.sleep(ele);
			} catch (Exception e) {
				System.out.println("Exception occurred in wait" + e);
			}
		}

		//Method for implicit wait
		public static void Xwait(WebElement element) throws InterruptedException {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOfAllElements(element));
			} catch (Exception e) {
				System.out.println("Exception occurred in Xwait" + e);
			}
		}

}
