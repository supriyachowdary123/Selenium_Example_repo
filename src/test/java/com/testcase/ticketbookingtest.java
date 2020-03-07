package com.testcase;

import org.testng.annotations.Test;

import com.pages.BasePage;
import com.pages.BusBooking;
import com.pages.HelpPage;
import com.pages.XlReading;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ticketbookingtest {

	WebDriver driver;
	BusBooking busbooking;
	HelpPage helppage;
	BasePage basepage;
	XlReading excel;

	@BeforeSuite
	public void beforeSuite() {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
	}
	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		busbooking = new BusBooking(driver);
		//helppage = new HelpPage(driver);
		basepage = new BasePage(driver);
		excel = new XlReading();
	}

	@Test(dataProvider="data")
	public void f(String src, String dst) {
		busbooking.Fromcity(src);
		busbooking.Tocity(dst);
		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		//driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='we day'][contains(text(),'22')]")).click();
		//driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='we day'][contains(text(),'9')]")).click();
		WebElement dateWidgetFrom = driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//tbody"));
		//This are the columns of the from date picker table
		        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
		        for (WebElement cell: columns) {
		     //      
		            //If you want to click 18th Date
		          //  if (cell.getText().equals("18")) {
		           
		            //Select Today's Date
		            if (cell.getText().equals("18")) {
		                cell.click();
		                break;
		            }
		       }
		busbooking.Search();
	
	}

	@DataProvider(name = "data")
	public Object[][] datasheet() {
		return excel.getXLSXFile("D:\\Cts java examples\\AssesmentResdBus\\src\\TestData\\testdata.xlsx");

	}



	

	@AfterTest
	public void afterTest() {
		driver.close();
	}



}
