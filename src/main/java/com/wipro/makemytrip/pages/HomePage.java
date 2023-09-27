package com.wipro.makemytrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver ldriver;
	@FindBy(xpath="//span[contains(text(),'Account')]")
	@CacheLookup
	WebElement Account;
	
	@FindBy(xpath="//*[@id=\"account_dd\"]/div[2]/ul/li[5]")
	@CacheLookup
	WebElement Login_createaccount;
	public HomePage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	public void Account() {
		
		Account.click();
	}
public void signup() {
		
	Login_createaccount.click();
	}

}
