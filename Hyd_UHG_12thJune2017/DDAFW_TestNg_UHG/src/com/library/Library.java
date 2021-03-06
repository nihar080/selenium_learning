package com.library;

import org.openqa.selenium.By;

import com.testBase.TestBase;

public class Library extends TestBase {
	
	public static void login(){
		driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys("admin");
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys("manager");
		driver.findElement(By.xpath(prop.getProperty("loginnow"))).click();
	}
	
	public static void clickontask(){
		driver.findElement(By.xpath(prop.getProperty("tasks"))).click();
	}
	public static void clickonproandcustomer(){
		driver.findElement(By.xpath(prop.getProperty("gotoproandcusto"))).click();
	}
	public static void clickonaddnewcustomer(){
		driver.findElement(By.xpath(prop.getProperty("clickonnewcreatecustomer"))).click();
	}
	
	public static void clickonaddnewproject(){
		driver.findElement(By.xpath(prop.getProperty("clickonnewcreateproject"))).click();
	}
	
	public static void createcustomer(String cname,String cdesc,String cradio){
		driver.findElement(By.xpath(prop.getProperty("customername"))).sendKeys(cname);
		driver.findElement(By.xpath(prop.getProperty("customerdescription"))).sendKeys(cdesc);
		driver.findElement(By.xpath(prop.getProperty(cradio))).click();
		driver.findElement(By.xpath(prop.getProperty("createcustomer"))).click();
	}
	
	public static void verifysucessmsg(){
		try{
			driver.findElement(By.xpath(prop.getProperty("verifysuccessmsg"))).isDisplayed();
			driver.findElement(By.xpath(prop.getProperty("logout"))).click(); //Logout
			}catch(Throwable t){
				st.fail("Success msg does not dispalyed");
				driver.findElement(By.xpath(prop.getProperty("logout"))).click(); //Logout
				driver.findElement(By.xpath(prop.getProperty("cancelcreation"))).click(); // click on cancelcreation
			}
				
	}
	
	public static void assertall(){
		st.assertAll();
	}
	
}
