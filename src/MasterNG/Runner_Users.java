package MasterNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Testcases.Login_Functionalities;
import Testcases.PM_Functionlities;
import Utils.Base;

public class Runner_Users extends Base {

	@BeforeTest
	public void callDriver() {
		driverInit("test");
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {

		Login_Functionalities.LoginNegative();
		Login_Functionalities.LoginNegative1();
		Login_Functionalities.LoginPositive();
		Login_Functionalities.forgotpassword();
	}

	
	@Test(priority = 2)
	public void PM() throws InterruptedException {
       PM_Functionlities.Clients();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
