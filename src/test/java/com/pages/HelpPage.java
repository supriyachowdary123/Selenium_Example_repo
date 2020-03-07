package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage extends BasePage {
	
	
	public HelpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[contains(text(),'Help')]") WebElement help;
	@FindBy(xpath="//span[contains(text(),'I need help with offers and promotions')]") WebElement help1;
	@FindBy(xpath="//span[contains(text(),'I need help with redBus wallet')]") WebElement help2;
	@FindBy(xpath="//span[contains(text(),'I have signed up with referral code but no amount')]") WebElement help3;
	@FindBy(xpath="//span[contains(text(),'My friend travelled but no amount credited to me')]") WebElement help4;
	
	 public void Help() {
		 help.click();
}
	 public void Help1() {
		 help1.click();
}
	 public void Help2() {
		 help2.click();
}
	 public void Help3() {
		 help3.click();
}
	 public void Help4() {
		 help4.click();
}

}