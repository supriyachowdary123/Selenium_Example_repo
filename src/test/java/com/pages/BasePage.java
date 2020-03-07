package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver= driver;
		
	}


	@FindBy(xpath="//a[@id='redBus']") WebElement busTkt;
	@FindBy(xpath=("//a[@id='cars']")) WebElement rpool;
	@FindBy(xpath=("//a[@id='redBus Bus Hire']")) WebElement busHire;
	@FindBy(xpath=("//a[@id='pilgrimages']")) WebElement piligriages;
	@FindBy(xpath="//a[contains(text(),'Help')]") WebElement help;
	@FindBy(xpath="//div[@class='manageHeaderLbl']") WebElement manageHeader;
	@FindBy(xpath="//i[@id='i-icon-profile']") WebElement profile;
	
	public void Bookingtkts(){
		busTkt.click();
		
	}

	public void cars(){
		rpool.click();
		
	}
	public void Bushire(){
		busHire.click();
		
	}
	public void piligriages(){
		piligriages.click();
		
	}
	
	

}

