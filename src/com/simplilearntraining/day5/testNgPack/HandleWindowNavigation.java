package com.simplilearntraining.day5.testNgPack;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HandleWindowNavigation {
	WebDriver driver = null;
	@Test
	public void HandleWindowNav() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.online.citibank.co.in/personal-banking/internet-banking");
		//maximize my window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//One Window Open
		String ParentWindowID = driver.getWindowHandle();
		System.out.println("Parent Window ID = " + ParentWindowID);
		WebElement LoginNow = driver.findElement(By.xpath("//*[@title='LOGIN NOW']"));
		LoginNow.click();
		//There are 2 open windows
		Set<String> winids = driver.getWindowHandles();
		//2 winids 
		System.out.println("Number of Open Windows = " + winids.size());
		//Iterator is used to iterator through each of element in the Set Collection using next function
		Iterator<String> iter= winids.iterator();
		String mainWinId = iter.next();
		String subWinId = iter.next();
		//switch to the sub window - enter selenium in User Id
		driver.switchTo().window(subWinId);
		WebDriverWait wait = new WebDriverWait(driver,30);
		try{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("User_Id")));
		WebElement User_Id = driver.findElement(By.id("User_Id"));
		User_Id.sendKeys("Selenium");
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(mainWinId);
		Thread.sleep(3000);
		WebElement Insurance = driver.findElement(By.id("topMnuinsurance"));
		Insurance.click();
		}catch(NoSuchElementException e){
			System.out.println("User_Id is not Present");
		}
	}
}