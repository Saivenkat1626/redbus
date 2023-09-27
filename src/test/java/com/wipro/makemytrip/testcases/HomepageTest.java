package com.wipro.makemytrip.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wipro.makemytrip.pages.HomePage;


public class HomepageTest extends Base {
	
HomePage homepage;
	public HomepageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
			driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
			homepage=new HomePage(driver);
			
	}
	
	@AfterMethod
	public void tear_down() {
		driver.close();
		
	}
	@Test
	public void LoginTest() throws InterruptedException
	{
		homepage.Account();
		homepage.signup();
		Thread.sleep(3000);
		
		
		
		

	}

}
