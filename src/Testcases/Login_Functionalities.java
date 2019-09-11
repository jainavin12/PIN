package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utils.Base;

public class Login_Functionalities extends Base {

	public static void LoginNegative() throws InterruptedException {
		String testcase1 = "Login Negative - Invalid UserName & Password";

		sendKeys("name", "userName", "test@mail.com");
		sendKeys("name", "password", "Admin@12");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		WebElement invalidpwd = driver
				.findElement(By.xpath("/html/body/app-root/div[1]/app-sign/section/div/div/div[2]/form/div[1]/span"));
		if (invalidpwd.isDisplayed()) {
			Assert.assertEquals(invalidpwd.getText(), "Incorrect User Name / Password");
			System.out.println(testcase1 + " = Passed");
		} else {
			System.out.println(testcase1 + " = Failed");
		}
		Thread.sleep(2000);
	}

	public static void LoginNegative1() throws InterruptedException {
		String testcase2 = "Login Negative1 - Invalid EmailId";

		Thread.sleep(1000);
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("password")).clear();
		sendKeys("name", "userName", "pms@");
		sendKeys("name", "password", "Admin@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		WebElement invalideml = driver.findElement(By.xpath("//span[contains(text(),'Invalid Email ID')]"));
		if (invalideml.isDisplayed()) {
			Assert.assertEquals(invalideml.getText(), "Invalid Email ID");
			System.out.println(testcase2 + " = Passed");
		} else {
			System.out.println(testcase2 + " = Failed");
		}
		Thread.sleep(2000);
	}

	public static void LoginPositive() throws InterruptedException {
		String testcase3 = "Login Positive - Valid Credentials";

		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("password")).clear();
		sendKeys("name", "userName", "rms@mailinator.com");
		sendKeys("name", "password", "Admin@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		System.out.println(testcase3 + " = Passed");

		// logout
		driver.findElement(By.xpath("//div[@class='profile_box']//div[@class='dropdown-toggle']")).click();

		// logout button
		driver.findElement(By.xpath("//a[@class='dropdown-item btn logout']")).click();

		Thread.sleep(3000);

		// logout yes button
		driver.findElement(By.xpath("//button[2]")).click();
		Thread.sleep(6000);
	}

	public static void forgotpassword() throws InterruptedException {
		String testcase4 = "Forgot password - Unregister email";

		driver.findElement(By.xpath("//span[contains(text(),'Forgot Password')]")).click();
		sendKeys("name", "userName", "hep@mail.com");
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("/html/body/app-root/div[1]/app-sign/section/div/div/div[2]/form/div[3]/button")).click();
		
		Thread.sleep(3000);
		WebElement unregister = driver.findElement(By.xpath("//span[contains(text(),'Email Id does not exist')]"));
		
		if (unregister.isDisplayed()) 
		{
			Assert.assertEquals(unregister.getText(), "Email Id does not exist");
			System.out.println(testcase4 + " = Passed");
		} 
		else 
		{
			System.out.println(testcase4 + " = Failed");
		}
		Thread.sleep(2000);
	}

}
