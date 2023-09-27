package com.wipro.makemytrip.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bookingpage {
	public WebDriver ldriver;
	public WebDriverWait wait;
	public  Bookingpage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(xpath="//input[@id='src']")
	WebElement source;
	@FindBy(xpath="//*[@class='sc-dnqmqq eFEVtU']")
	WebElement source_input;
	@FindBy(xpath="//input[@id='dest']")
	WebElement destination;
	
	@FindBy(xpath="//span[@class='dateText']")
	WebElement dateselection;
	@FindBy(xpath="//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//div[2]")
	WebElement Month_Year;
	@FindBy(xpath="//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//div[3]//*[name()='svg']")
	WebElement nextbutton;
	@FindBy(xpath="//span[normalize-space()='16']")
	WebElement date;
	@FindBy(xpath="//button[@id='search_button']")
	WebElement search_bus;
	
	
		public void source() {
		source.sendKeys("Bandarulanka",Keys.TAB);
//		wait=new WebDriverWait(ldriver,Duration.ofSeconds(15000));
//		wait.until(ExpectedConditions.elementToBeClickable(source));
		
	}
	public void destination() {
		destination.sendKeys("Banglore");
//		wait=new WebDriverWait(ldriver,Duration.ofSeconds(15000));
//		wait.until(ExpectedConditions.elementToBeClickable(destination));
	}
	public void date() {
		
		dateselection.click();
		while(true) {
			String month_year=Month_Year.getText();
	String arr[]=month_year.split("\n");
	String month[]=arr[0].split(" ");
	String actualmonth=month[0];
	String actualyear=month[1];
	if(actualmonth.equals("Sep")&&(actualyear.equals("2023"))) {
		break;
	}
	else
	{
		nextbutton.click();
	}
	date.click();
	wait=new WebDriverWait(ldriver,Duration.ofSeconds(15000));
	wait.until(ExpectedConditions.elementToBeClickable(date));
	
//	for(WebElement ele:date) {
//		String dt=ele.getText();
//		if(dt.equals("15")) {
//			ele.click();
//			break;
//		}
//		
//	}

	
}
}
	public void search_bus()
{
		search_bus.click();
	
		}
}