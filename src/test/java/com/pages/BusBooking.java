package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusBooking extends BasePage{
	public BusBooking(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@id='src']")WebElement fromcity;
	@FindBy(xpath="//input[@id='dest']") WebElement tocity;
	@FindBy(xpath="//div[@class='clearfix rb-calendar-main']//div[@id='rb-calmiddle']//span[contains(text(),'13')]") WebElement onwarddate;
	@FindBy(xpath="//div[@class='clearfix rb-calendar-main']//div[@id='rb-calmiddle']//span[contains(text(),'22')]") WebElement returndate;
	@FindBy(xpath="//button[@class='D120_search_btn searchBuses']") WebElement search;
	
	public void Fromcity(String src){
		fromcity.sendKeys(src);
		
	}
	public void Tocity(String dst){
		tocity.sendKeys(dst);
		
	}
	public void Onwarddate(){
		onwarddate.click();
		
	}
	public void Returndate(){
		returndate.click();
		
	}
	public void Search(){
		search.click();
		
	}
	
	
	
	

}

