package com.wipro.makemytrip.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wipro.makemytrip.pages.Bookingpage;


public class Bookingbus extends Base {
	Bookingpage bp;
	public  Bookingbus()
	{
		super();
	}
	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndOpenApplicationURL(Get_Browsername());
		bp=new Bookingpage(driver);
		
}

@AfterMethod
public void tear_down() {
	driver.close();
	
}
@Test
public void booking() throws InterruptedException {
	bp.source();
	
	bp.destination();
	bp.date();

	bp.search_bus();
	
}
	
}

