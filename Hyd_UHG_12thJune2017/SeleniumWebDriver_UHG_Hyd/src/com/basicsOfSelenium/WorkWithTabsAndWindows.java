package com.basicsOfSelenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class WorkWithTabsAndWindows {
	public static WebDriver driver;
	public String Browser="chrome";
	
	@Test
	public void workwithAlert() throws Throwable{
		if(Browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver(); // Open Browser
		}else if(Browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}else if(Browser.equalsIgnoreCase("mozilla")){
			System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
			driver=new FirefoxDriver(); // Open Browser
		}
		driver.get("https://www.naukri.com/"); //Open url
		driver.manage().window().maximize(); // maximize the window
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String mainwindow = driver.getWindowHandle();
		CloseAllUnwantedwindows(mainwindow);
		driver.switchTo().window(mainwindow); //switch to main window
		driver.findElement(By.xpath("html/body/div[2]/div/ul/li[2]/a/div")).click(); //click on recruiters
		Set<String> allwinids = driver.getWindowHandles(); //collected all window ids
		Iterator<String> it=allwinids.iterator();
		it.next(); //main window id
		String t1 = it.next(); //tab window id
		driver.switchTo().window(t1); // switching to tab
		driver.findElement(By.xpath(".//*[@id='skill']/div[1]/div[2]/input")).sendKeys("Tester");
}
	
	public static void CloseAllUnwantedwindows(String mid){
		Set<String> allids = driver.getWindowHandles();
		for(String x:allids){
			if(!x.equals(mid)){
				driver.switchTo().window(x);
				driver.close();
			}
		}
	}
}