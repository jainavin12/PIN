package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import Utils.Base;

public class PM_Functionlities extends Base

{

	public static void Clients() throws InterruptedException
	{
		sendKeys("name", "userName", "pmnew@mailinator.com");
		sendKeys("name", "password", "Admin@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		//Clients side menu
		driver.findElement(By.xpath("//div[@class='navigation d-none d-md-block d-xl-block']//span[contains(text(),'Clients')]")).click();
		
		Thread.sleep(2000);
		
		//Add button
		driver.findElement(By.xpath("//tr[1]//td[6]//span[1]//span[1]")).click();
		
		Thread.sleep(2000);
		
		//Client info
		driver.findElement(By.xpath("//a[@class='client_info']")).click();
		
		// To scroll web page down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(1000);

		// To scroll web page up
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Master Client - TCS')]")).click();
		
		Thread.sleep(2000);
		
		//Sider round
		driver.findElement(By.xpath("//label[@class='switch']")).click();
		
		// To scroll web page down
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		driver.findElement(By.xpath("//li[3]//div[1]//input[1]")).click();
		
		driver.findElement(By.xpath("//li[4]//div[1]//input[1]")).click();
		
		Thread.sleep(2000);		
		
		//continue button
		driver.findElement(By.xpath("//a[@class='continue_button btn']")).click();
		
		Thread.sleep(2000);
		
		// every month button
		driver.findElement(By.xpath("//mat-radio-button[@id='mat-radio-3']//div[@class='mat-radio-outer-circle']")).click();

		Thread.sleep(4000);
		
		Select date = new Select(driver.findElement(By.xpath("//select[@class='cutoff_date ng-untouched ng-pristine ng-valid']")));
		
		date.selectByValue("25");
		
		Thread.sleep(2000);

		// apply recurrence button
		driver.findElement(By.xpath("//button[@class='apply_recur']")).click();
	}

}
