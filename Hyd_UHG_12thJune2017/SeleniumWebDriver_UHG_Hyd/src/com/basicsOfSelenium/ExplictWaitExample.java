package com.basicsOfSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplictWaitExample {
	public WebDriver driver;
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
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin"); //Open url
		driver.manage().window().maximize(); // maximize the window
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//	WebDriverWait wait=new WebDriverWait(driver,20);
		//Enter wrong email id
		driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("sreinierenier");
		//click on next
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		
		new FluentWait<WebDriver>(driver)
	       .withTimeout(20, TimeUnit.SECONDS)
	       .pollingEvery(2, TimeUnit.SECONDS)
	       .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='view_container']/form/div[2]/div/div[1]/div[1]/div/div[2]/div[2]"))));
	
		//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='view_container']/form/div[2]/div/div[1]/div[1]/div/div[2]/div[2]"))));
		//print text
		String text = driver.findElement(By.xpath(".//*[@id='view_container']/form/div[2]/div/div[1]/div[1]/div/div[2]/div[2]")).getText();
		System.out.println("text="+text);
}
}