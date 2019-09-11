package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utils.Base;

public class RM_Functionalities extends Base 
{

	public static void Clients() throws InterruptedException
	{
		sendKeys("name", "userName", "rmnew@mailinator.com");
		sendKeys("name", "password", "Admin@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		//Clients side menu
		driver.findElement(By.xpath("//div[@class='navigation d-none d-md-block d-xl-block']//span[contains(text(),'Clients')]")).click();
		
		Thread.sleep(2000);
		
		//client view button
		driver.findElement(By.xpath("//tr[1]//td[6]//span[2]//span[1]")).click();
		
		//To scroll web page down
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(1000);
		
		//To scroll web page up
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 js1.executeScript("window.scrollBy(0,-250)", "");
        
		Thread.sleep(2000);
		
		//Assign
        driver.findElement(By.xpath("/html/body/app-root/div[1]/app-process/section/div/main/app-client-profile/section/div[1]/div[2]/a/span")).click();
        
        Thread.sleep(2000);
        String testcase1 ="Popheader - Select Manager";
        
        WebElement Popheader = driver.findElement(By.xpath("//h6[@class='m-0 font-weight-bold']"));
        if(Popheader.isDisplayed()) 
        {
        	Assert.assertEquals(Popheader.getText(), "Select Manager");
			System.out.println(testcase1 + " = Passed");
        }
        else 
        {
        	System.out.println(testcase1 + " = Failed");
        }
        
        Thread.sleep(2000);
        //radio button
        driver.findElement(By.xpath("(//label[@class='mat-radio-label'])[2]")).click();
	    System.out.println("radio button clicked");
	    
	    Thread.sleep(2000);
	    
        //okay button
        driver.findElement(By.xpath("//button[@class='apply_recur pl-5 pr-5']")).click();
        
        Thread.sleep(3000);
        
        //clients assigned successfully ok button
        driver.findElement(By.xpath("(//div[@class='text-center p-3'])[1]")).click();
       
        Thread.sleep(4000);
        
        //Assigned tab
        driver.findElement(By.xpath("/html/body/app-root/div[1]/app-process/section/div/main/app-client/section/div[2]/app-inner-nav-bar/div/div/ul/li[2]/a")).click();        
        
        Thread.sleep(5000);
        
        //logout dropdown toggle
        driver.findElement(By.xpath("//p[@class='pl-3 nowrap_ellipsis user overflow-hide float-left']")).click();
        
        //logout button
        driver.findElement(By.xpath("//a[@class='dropdown-item btn logout']")).click();
        
        Thread.sleep(2000);
        
        //logout yes
        driver.findElement(By.xpath("//button[@class='apply_recurPositive px-2 py-2 my-0 mx-3']")).click();
        
        System.out.println("Client Assigned successfully");
        
	}
	

}
